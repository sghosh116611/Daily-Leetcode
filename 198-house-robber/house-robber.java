class Solution {
    public int rob(int[] nums) {
        //return f(nums,0);

        // int[] dp = new int[nums.length];
        // Arrays.fill(dp,-1);

        // return f(nums,0,dp);

        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp,-1);

        return f(nums,dp);
    }

    // int f(int[] nums, int idx){
    //     if(idx >= nums.length) return 0;

    //     int take = nums[idx] + f(nums,idx + 2);
    //     int notTake = f(nums,idx + 1);

    //     return Math.max(take,notTake);
    // }

    // int f(int[] nums, int idx, int[] dp){
    //     if(idx >= nums.length) return 0;

    //     if(dp[idx] != -1)
    //         return dp[idx];

    //     int take = nums[idx] + f(nums,idx + 2,dp);
    //     int notTake = f(nums,idx + 1,dp);

    //     return dp[idx] = Math.max(take,notTake);
    // }

    int f(int[] nums, int[] dp){
        dp[nums.length] = 0;

        for(int i = nums.length - 1; i >= 0; i--){
            int take = nums[i];
            if(i + 2 <= nums.length)
                take += dp[i + 2];

            int notTake = dp[i + 1];
            
            dp[i] = Math.max(take,notTake);
        }

        return dp[0];
    }
}