class Solution {
    public int climbStairs(int n) {
        return fSpaceOptimised(n);
    }

    private int f(int n){
        if(n == 0 || n == 1)
            return 1;
        return f(n - 1) + f(n - 2);
    }

    private int fMemoization(int n){
        int dp[] = new int[n];

        if(n == 0 || n == 1)
            return 1;
        if(dp[n - 1] != 0)
            return dp[n - 1];
        
        return dp[n - 1] = fMemoization(n - 1) + fMemoization(n - 2);
    }

    private int fTabulation(int n){
        int dp[] = new int[n + 1];

        if(n == 0 || n == 1)
            return 1;
        
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        
        return dp[n];
    }

    private int fSpaceOptimised(int n){
        int a = 1;
        int b = 1;

        for(int i = 2; i <= n; i++){
            int s = a + b;
            a = b;
            b = s;
        }

        return b;
    }
}