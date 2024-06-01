class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int br = -1;
        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[ i + 1 ]){
                br = i;
                break;
            }
        }

        if(br == -1)
            reverse(nums);
        else{
            
            for(int i = n - 1; i > br; i--){
                if(nums[i] > nums[br])
                {
                    int temp = nums[i];
                    nums[i] = nums[br];
                    nums[br] = temp;
                    break;
                }
            }

            reverse(nums,br + 1);
        }
    }

    private void reverse(int[] nums, int idx){
        int n = nums.length;
        int i = idx, j = n - 1;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    private void reverse(int[] nums){
        reverse(nums,0);
    }
}