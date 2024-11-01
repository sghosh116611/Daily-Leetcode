class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] ds = new int[n][n];
        List<int[][]> rs = new ArrayList<>();

        List<List<String>> result = new ArrayList<>();

        fn(n,0,ds,rs);

        for(int matIdx = 0; matIdx < rs.size(); matIdx++){
            int[][] mat = rs.get(matIdx);
            List<String> rowRs = new ArrayList<>();
            for(int i = 0; i < n; i++){
                String row = "";
                for(int j = 0; j < n; j++){
                    if(mat[i][j] == 1)
                        row += "Q";
                    else
                        row += ".";
                }
                rowRs.add(row);
            }
            result.add(rowRs);
        }

        return result;
    }

    public void fn(int n, int col,int[][] ds, List<int[][]> result){
        if(col == n){
            int[][] dsCopy = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    dsCopy[i][j] = ds[i][j];
                }
            }
            result.add(dsCopy);
            return;
        }
        int j = col;
        for(int i = 0; i < n; i++){
            if(canFill(i,j,ds,n)){
                ds[i][j] = 1;
                fn(n,col + 1,ds,result);
                ds[i][j] = 0;
            }
        }
    }

    public boolean canFill(int i, int j, int[][] ds, int n){
        if(i < 0 || i >= n || j < 0 || j >= n)
            return false;
        
        // Check row
        for(int idx = 0; idx < n; idx++){
            if(ds[i][idx] == 1)
                return false;
        }

        // Check column
        for(int idx = 0; idx < n; idx++){
            if(ds[idx][j] == 1)
                return false;
        }

        // Check diagonal
        int[][] directions = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for (int[] direction : directions) {
            int idx1 = i, idx2 = j;
    
            while (idx1 >= 0 && idx1 < n && idx2 >= 0 && idx2 < n) {
                if (ds[idx1][idx2] == 1) 
                    return false;
                idx1 += direction[0];
                idx2 += direction[1];
            }
        }

        return true;
    }
}