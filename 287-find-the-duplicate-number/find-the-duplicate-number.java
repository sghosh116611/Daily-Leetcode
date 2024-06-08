class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int idx = nums[i];
            if(nums[(int)Math.abs(idx)] < 0)
                return (int)Math.abs(idx);
            nums[(int)Math.abs(idx)] *= -1; 
        }
        return -1;
    }
}