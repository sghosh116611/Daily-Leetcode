class Solution {
    public void nextPermutation(int[] nums) {
        
        int point = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                point = i;
                break;
            }
        }

        if(point != nums.length - 1){
            for(int i = nums.length - 1; i > point; i--){
                if(nums[i] > nums[point]){
                    int temp = nums[point];
                    nums[point] = nums[i];
                    nums[i] = temp;
                    break;
                }   
                
            }
            reverse(nums, point + 1, nums.length - 1);
           
        }else{
            reverse(nums, 0, nums.length - 1);
        }
    }

    public void reverse(int[] nums, int startIdx, int endIdx){
        int i = startIdx, j = endIdx;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}