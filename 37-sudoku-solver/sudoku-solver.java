class Solution {
    public void solveSudoku(char[][] board) {
        fn(board);
    }

    public boolean fn(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(canFill(i,j,board,c)){
                            board[i][j] = c;

                            if(fn(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean canFill(int row, int col, char[][] board, char c){
        for(int j = 0; j < 9; j++){
            if(board[row][j] == c)
                return false;
        }

        for(int i = 0; i < 9; i++){
            if(board[i][col] == c)
                return false;
        }

        for(int i = 0; i < 9; i++){
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        
        return true;
    }
}