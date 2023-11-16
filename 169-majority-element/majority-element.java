class Solution {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 0;
        for(int num : nums){
            
            if(count == 0){
                major = num;
            }

            if(num != major)
                if(count == 0)
                    count = 0;
                else
                    count--;
            else
                count++;

        } 
        return major; 
    }
}