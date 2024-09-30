class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }

        if(idx != -1){
            for(int i = n - 1; i > idx; i--)
                if(nums[i] > nums[idx]){
                    swap(nums,idx,i);
                    break;
                }

            int i = idx + 1;
            int j = n - 1;
            while(i < j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }else{
            Arrays.sort(nums);
        }
    }

    private void swap(int[] nums, int i, int j){
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }
}