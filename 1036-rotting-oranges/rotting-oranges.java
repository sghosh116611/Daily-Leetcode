class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int fresh = 0, mins = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    queue.add(new Pair(i,j));
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0)
            return 0;
        
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

        System.out.println(fresh);

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Pair pair = queue.poll();
                int i = pair.i;
                int j = pair.j;
            
                for(int k = 0; k <= 3; k++){
                    int x1 = i + dir[k][0];
                    int y1 = j + dir[k][1];

                    if(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && grid[x1][y1] == 1){
                        fresh--;
                        queue.add(new Pair(x1,y1));
                        grid[x1][y1] = 2;
                    }   
                }
            }
            mins++;
        }

        System.out.println(fresh);

        return fresh == 0 ? mins - 1 : -1;
        
    }

    private class Pair{
        int i;
        int j;

        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}