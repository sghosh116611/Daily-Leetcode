class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        transpose(matrix,m,n);
        print(matrix,m,n);
        System.out.println("-------");
        swapColumns(matrix,m,n);
        print(matrix,m,n);
    }

    private void transpose(int[][] matrix, int m, int n){

        for(int i = 0; i < m; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void swapColumns(int[][] matrix, int m, int n){

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    private void print(int[][] matrix, int m, int n){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}