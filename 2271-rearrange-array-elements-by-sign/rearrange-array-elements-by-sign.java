class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] arr = new int[nums.length];
        int pos0 = 0, pos1 = 1;
        for(int num : nums){
            if(num > 0){
                arr[pos0] = num;
                pos0+= 2;
            }else if(num < 0){
                arr[pos1] = num;
                pos1+= 2;
            }
        }
        return arr;
    }
}