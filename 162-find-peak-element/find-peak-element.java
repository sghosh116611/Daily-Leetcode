class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        if(nums.length == 1) return 0;
        while(low <= high){
            int mid = (low + high) / 2;
            if(mid == 0){
                if(nums[mid] > nums[mid + 1]) return 0;
            }
            if(mid == nums.length - 1){
                if(nums[mid] > nums[mid - 1]) return mid;
            }

            if(nums[mid] > nums[mid + 1]) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }
}