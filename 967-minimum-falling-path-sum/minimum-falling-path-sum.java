class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int dp[][] = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix.length; j++)
                dp[i][j] = -1;

        // for(int i = 0; i < matrix.length; i++){
        //     ans = Math.min(ans,fMemoization(0,i,matrix.length - 1,matrix.length - 1,matrix,dp));
        // }

        return fDP(matrix.length,matrix.length,matrix,dp);
        //return ans;
    }

    private int f(int i, int j, int m, int n, int[][] matrix){
        if(i < 0 || j < 0 || i > m || j > n) return Integer.MAX_VALUE;
        if(i == m) return matrix[i][j];

        return matrix[i][j] + Math.min(f(i + 1, j - 1,m,n,matrix),Math.min(f(i + 1,j + 1,m,n,matrix),f(i + 1,j,m,n,matrix)));
    }

    private int fMemoization(int i, int j, int m, int n, int[][] matrix, int[][] dp){
        if(i < 0 || j < 0 || i > m || j > n) return Integer.MAX_VALUE;
        if(i == m) return matrix[i][j];
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = matrix[i][j] + Math.min(fMemoization(i + 1, j - 1,m,n,matrix,dp),Math.min(fMemoization(i + 1,j + 1,m,n,matrix,dp),fMemoization(i + 1,j,m,n,matrix,dp)));
    }

    private int fDP(int m, int n, int[][] matrix, int[][] dp){
        for(int j=0;j<n;j++)
        {
            dp[0][j] = matrix[0][j];
        }
        
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j == 0)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],dp[i-1][j+1]);
                
                else if(j == n-1)
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1],dp[i-1][j]);
                
                else
                {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j-1],
                                                Math.min(dp[i-1][j],dp[i-1][j+1]));
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
        {
            ans = Math.min(ans,dp[m - 1][j]);
        }
        return ans;
    }
}