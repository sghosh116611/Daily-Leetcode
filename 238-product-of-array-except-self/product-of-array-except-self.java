class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i = 1; i < res.length; i++){
            res[i] = nums[i - 1] * res[i - 1];
        }
        int prod = nums[res.length - 1];
        for(int i = res.length - 2; i >= 0; i--){
            res[i] = res[i] * prod;
            prod *= nums[i];
        }
        return res;
    }
}