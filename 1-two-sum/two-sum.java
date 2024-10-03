class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int idx1 = -1, idx2 = -1;
        for(int i = 0; i < nums.length; i++){
            int x = target - nums[i];
            if(map.containsKey(x))
            {
                idx1 = i; idx2 = map.get(x);
                break;
            }
            map.put(nums[i],i);
        }
        return new int[]{idx1,idx2};
    }
}