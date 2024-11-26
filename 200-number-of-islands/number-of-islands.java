class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                char ch = grid[i][j];

                if(!visited[i][j] && grid[i][j] == '1'){
                    System.out.println(i + " " + j);
                    count++;
                    bfs(visited,grid,i,j);
                }
            }
        }

        return count;
    }

    public void bfs(boolean[][] visited, char[][] grid, int i, int j){
        int[][] trav = {{0,1},{0,-1},{1,0},{-1,0}};

        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Index> queue = new LinkedList<>();
        queue.add(new Index(i,j));
        visited[i][j] = true; 

        while(!queue.isEmpty()){
            Index index = queue.poll();
            int row = index.row;
            int col = index.col;
            
            visited[row][col] = true;

            for (int[] dir : trav) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
                    && grid[newRow][newCol] == '1' && !visited[newRow][newCol]) {
                    queue.offer(new Index(newRow, newCol));
                    visited[newRow][newCol] = true;
                }
            }

        }
        
    }

    class Index{
        int row;
        int col;

        Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}