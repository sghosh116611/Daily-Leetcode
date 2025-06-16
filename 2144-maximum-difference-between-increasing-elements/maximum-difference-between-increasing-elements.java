class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] maxElementToRight = new int[n];
        int max = 0;

        for(int i = n - 1; i >= 0; i--){
            max = Math.max(nums[i],max);
            maxElementToRight[i] = max;
        }

        int diff = 0;
        for(int i = 0; i < n; i++){
            diff = Math.max(diff,maxElementToRight[i] - nums[i]);
        }

        return diff == 0 ? - 1 : diff;
    }
}