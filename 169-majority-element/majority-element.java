class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int maj = nums[0];
        for(int num : nums){
            if(num == maj)
                count++;
            else 
                count--;
            if(count <= 0){
                maj = num;
                count = 1;
            }
            System.out.println(count);
        }
        return maj;
    }
}