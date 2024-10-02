class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        while(i < m && j < n){
            if(matrix[i][n - 1] < target){
                System.out.println(i);
                i++;
            }
            else{
                System.out.println(i);
                while(j < n){ 
                    System.out.println("j ===" + j);
                    if(matrix[i][j] == target)
                        return true;
                    j++;
                }
            }
        }
        return false;
    }
}