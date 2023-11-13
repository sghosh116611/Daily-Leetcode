class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int k = 0;
        for(int i = 0; i < m;i++){
            for(int j = k; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                //swap(matrix[i][j],matrix[j][i]);
            }
            k++;
        }

        for(int i = 0; i <= (m - 1) / 2; i++){
            int l = i;
            int r = m - 1 - i;
            for(int j = 0; j < n; j++){
                int temp = matrix[j][l];
                matrix[j][l] = matrix[j][r];
                matrix[j][r] = temp;
            }
        }

        for(int i = 0; i < m;i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
            // k++;
        }
    }

    public void swap(int i, int j){
        int k = i;
        i = j;
        j = k;
    }
}