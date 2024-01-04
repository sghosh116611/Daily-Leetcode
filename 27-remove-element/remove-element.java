class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for(; j < nums.length; j++){
            if(nums[j] != val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }

}