class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] maxElementToRight = new int[n];
        int min = nums[0];
        int diff = 0;

        for(int i = 1; i < n; i++){
            min = Math.min(min,nums[i - 1]);
            if(min < nums[i]) diff = Math.max(diff,nums[i] - min);
        }
        
        return diff == 0 ? - 1 : diff;
        // for(int i = n - 1; i >= 0; i--){
        //     max = Math.max(nums[i],max);
        //     maxElementToRight[i] = max;
        // }

        
        // for(int i = 0; i < n; i++){
        //     diff = Math.max(diff,maxElementToRight[i] - nums[i]);
        // }
    }
}