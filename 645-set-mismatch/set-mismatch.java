class Solution {
    public int[] findErrorNums(int[] nums) {
        int res[] = new int[2];
        int duplicate = -1,miss = 1;
        
        for(int num : nums)
        {
            if(nums[Math.abs(num) - 1] < 0)
                duplicate = Math.abs(num);
            else
                nums[Math.abs(num) - 1] *= -1;
        }
        
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] > 0)
                miss = i + 1;
        }
        return new int[]{duplicate,miss};
    }
}