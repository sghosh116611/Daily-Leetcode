class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            int midElem = nums[mid];
            if(mid + 1 <= high && midElem == nums[mid + 1]){
                if(mid % 2 == 0){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else if(mid - 1 >= 0 && midElem == nums[mid - 1]){
                if(mid % 2 == 1){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            } else{
                return midElem;
            }
        }
        return -1;
    }
}