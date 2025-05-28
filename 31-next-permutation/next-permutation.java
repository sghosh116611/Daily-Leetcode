class Solution {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                idx = i;
                break;
            }
        }
        if(idx != -1){
            for(int i = nums.length - 1; i > idx; i--){
                if(nums[i] > nums[idx]){
                    swap(nums,idx,i);
                    break;
                }
            }
            reverse(nums,idx + 1);
        }else{
            Arrays.sort(nums);
        }
            
    }

    private void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    
    private void reverse(int[] nums, int idx){
        int p1 = idx;
        int p2 = nums.length - 1;
        while(p1 < p2){
            swap(nums,p1,p2);
            p1++;
            p2--;
        }
    }
}