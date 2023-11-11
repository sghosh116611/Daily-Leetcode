class Solution {
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while(mid <= right){
            if(nums[mid] == 2){
                swap(mid,right,nums);
                right--;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 0){
                swap(mid,left,nums);
                mid++;
                left++;
            }
        }
    }

    public void swap(int idx1, int idx2, int[] nums){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}