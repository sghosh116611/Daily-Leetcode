class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[m][n];
        int rotten = 0,empty = 0,fresh = 0;
        int mins = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0)
            return 0;

        System.out.println(fresh);

        while(!queue.isEmpty()){
            mins++;
            int size = queue.size();
            while(size-- > 0){
                Pair cell = queue.poll();
                int i = cell.i;
                int j = cell.j;

                    if(i + 1 < m && visited[i + 1][j] != 1 && grid[i + 1][j] == 1){
                        grid[i + 1][j] = 2;
                        queue.add(new Pair(i + 1,j));
                        
                fresh--;
                    }

                    if(i - 1 >= 0 && visited[i - 1][j] != 1 && grid[i - 1][j] == 1){
                        grid[i - 1][j] = 2;
                        queue.add(new Pair(i - 1,j));
                        
                fresh--;
                    }

                    if(j + 1 < n && visited[i][j + 1] != 1 && grid[i][j + 1] == 1){
                        grid[i][j + 1] = 2;
                        queue.add(new Pair(i,j + 1));
                        
                fresh--;
                    }

                    if(j - 1 >= 0 && visited[i][j - 1] != 1 && grid[i][j - 1] == 1){
                        grid[i][j - 1] = 2;
                        queue.add(new Pair(i,j - 1));
                        
                fresh--;
                    }
                
                System.out.println(fresh);
            }
            
        }
        return fresh == 0 ? mins - 1 : -1;
    }

    class Pair{
        int i;
        int j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}