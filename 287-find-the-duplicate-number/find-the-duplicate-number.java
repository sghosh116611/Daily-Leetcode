class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int elem = nums[i];
            elem = (int) Math.abs(elem);
            if(nums[elem - 1] < 0)
                return elem;
            nums[elem - 1] *= -1;
        }
        return -1;
    }
}