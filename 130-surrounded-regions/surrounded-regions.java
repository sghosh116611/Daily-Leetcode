class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O' && !visited[0][j]) {
                dfs(board,0,j,visited);
            }

            if(board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                dfs(board,m - 1,j,visited);
            }
        }

        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O' && !visited[i][0]) {
                dfs(board,i,0,visited);
            }

            if(board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                dfs(board,i,n - 1,visited);
            }
        }

        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        visited[row][col] = true;
        int[][] trav = {{0,1},{0,-1},{1,0},{-1,0}};

        for(int i = 0; i <= 3; i++) {
            int nrow = row + trav[i][0];
            int ncol = col + trav[i][1];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                && !visited[nrow][ncol] && board[nrow][ncol] == 'O') {
                dfs(board, nrow, ncol, visited);
            }
            
        }
    }
}