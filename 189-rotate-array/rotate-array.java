class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length != 1){
            k = k % nums.length;
            reverse(nums);
            reverse(nums,k - 1);
            reverse(nums,k,nums.length - 1);
        }
    }

    private void reverse(int[] nums){
        int n = nums.length;
        for(int i = 0; i <= (n - 1 )/ 2; i++){
            swap(nums,i,n-1-i);
        }
    }

    private void reverse(int[] nums, int idx){
        int idx1 = 0, idx2 = idx;
        while(idx1 <= idx2){
            swap(nums,idx1,idx2);
            idx1++;
            idx2--;
        }
    }

    private void reverse(int[] nums, int idx1, int idx2){
        while(idx1 <= idx2){
            swap(nums,idx1,idx2);
            idx1++;
            idx2--;
        }
    }

    private void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}