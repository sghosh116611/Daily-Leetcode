class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid <= high){
            if(nums[mid] == 2){
                swap(nums,high,mid);
                high--;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                swap(nums,low,mid);
                low++;
                mid++;
            }
        }
    }
    private void swap(int nums[], int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}