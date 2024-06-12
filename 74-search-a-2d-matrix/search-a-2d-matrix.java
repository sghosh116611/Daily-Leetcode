class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = m - 1;
        while(row >= 0){
            if(target < matrix[row][0])
                row--;
            else
                break;
        }

        if(row < 0)
            return false;

        for(int i = 0; i < n; i++){
            if(matrix[row][i] == target)
                return true;
        }

        return false;
    }
}