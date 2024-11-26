class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int max = 0;

        int i = 0;
        for( ; i < n - 1; i++){
            if(i > max)return false;
            max = Math.max(nums[i] + i,max);
            if (max >= n - 1) return true;
        }
        return max >= n - 1;
    }
}