class Solution {
    int mod=1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn)
    {
        
        int[][][] dp=new int[m][n][maxMove+1];
        
        for(int[][] mat:dp)
        {
            for(int[] row:mat)
            {
                Arrays.fill(row,-1);
            }
        }
        
        return f(startRow,startColumn,m,n,maxMove,dp);
    }
    
    public int f(int i, int j, int m, int n, int k, int[][][] dp)
    {
        if(i<0 || i>=m || j<0 || j>=n)
        {
            return 1;
        }
        
        if(k==0)
        {
            return 0;
        }
        
        if(dp[i][j][k]!=-1)
        {
            return dp[i][j][k];
        }
        
        
        int res=0;
        res=(res+f(i+1,j,m,n,k-1,dp))%mod;
        res=(res+f(i-1,j,m,n,k-1,dp))%mod;
        res=(res+f(i,j+1,m,n,k-1,dp))%mod;
        res=(res+f(i,j-1,m,n,k-1,dp))%mod;
        
        dp[i][j][k]=res%mod;
        return dp[i][j][k];
    }
}