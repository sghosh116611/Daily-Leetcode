class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0, result = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int prefixSum = sum - k;

            if(map.containsKey(prefixSum)){
                result += map.get(prefixSum);
            }
            
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }

        return result;
    }
}