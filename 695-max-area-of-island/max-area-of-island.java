class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int max = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 1 && !visited[i][j]){
                    max = Math.max(bfs(i,j,grid,visited,m,n),max);
                }
            }
        }

        return max;
    }

    public int bfs(int x, int y, int[][] grid, boolean[][] visited, int m, int n){

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x,y));
        visited[x][y] = true;
        int count = 0;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int i = point.i;
            int j = point.j;
            count++;

            if(j + 1 < n && grid[i][j + 1] == 1 && !visited[i][j + 1]){
                queue.offer(new Point(i,j + 1));
                visited[i][j + 1] = true;
                
            }

            if(j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]){
                queue.offer(new Point(i,j - 1));
                visited[i][j - 1] = true;
            }
                    
            if(i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]){
                queue.offer(new Point(i - 1,j));
                visited[i - 1][j] = true;
            }

            if(i + 1 < m && grid[i + 1][j] == 1 && !visited[i + 1][j]){
                queue.offer(new Point(i + 1,j));
                visited[i + 1][j] = true;
            }
        }

        //System.out.println(x + " " + y + " " + count);
        return count;
    }
}

class Point{
    int i;
    int j;

    Point(int _i, int _j){
        i = _i;
        j = _j;
    }
}