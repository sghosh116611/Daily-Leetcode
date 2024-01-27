class Solution {
    public int kInversePairs(int n, int k) {
        int dp[][] = new int[n + 1][k + 1];

        for(int i = 1; i < n + 1; i ++)
        {
            dp[i][0] = 1;
        }
        long mod = (long)(1e9 + 7);
        for(int i = 1; i < n + 1; i ++)
        {
            for(int j = 1; j < k + 1; j++){
                dp[i][j] = (int)((dp[i][j]  +  (long)dp[i - 1][j]) % mod);
                for(int l = 1 ; j - l >= 0 && l < i &&  j <= ((i-1) * i ) / 2 ; l++){
                    dp[i][j] = (int)((dp[i][j]  +  (long)dp[i-1][j-l]) % mod);

                }
            }

        }

        return dp[n][k] ;
    }
}