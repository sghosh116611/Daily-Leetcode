class Solution {
    public int countSubstrings(String s) {
        int[][]dp = new int[s.length()][s.length()];
        int count = 0;
        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = i; j < dp.length; j++){
                if(i == j)
                    dp[i][j] = 1;
                else if(i + 1 == j){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 1 : 0;
                }
                else{
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i+1][j-1] : 0;
                }
                count += dp[i][j];
            }
        }
        return count;
    }
}