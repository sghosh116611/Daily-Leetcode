class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                bfs(i,0,board);
            }
            if(board[i][n - 1] == 'O') {
                bfs(i,n - 1,board);
            }
        }

        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                bfs(0,j,board);
            }
            if(board[m - 1][j] == 'O') {
                bfs(m - 1,j,board);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '#')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    public void bfs(int i, int j, char[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        board[i][j] = '#';

        int m = board.length;
        int n = board[0].length;
        
        int[][] traverse = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()) {
            int[] pop = queue.poll();
            
            for(int trav[] : traverse) {
                int x = pop[0] + trav[0];
                int y = pop[1] + trav[1];

                if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
                    board[x][y] = '#';
                    queue.add(new int[]{x,y});
                }
            }
        }
    }
}