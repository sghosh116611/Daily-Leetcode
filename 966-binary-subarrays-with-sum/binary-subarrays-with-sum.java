class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // SC -> O(N)
        // Map<Integer,Integer> freq = new HashMap<>();
        // freq.put(0,1);

        // int sum = 0, count = 0;

        // for(int num : nums) {
        //     sum += num;

        //     if(freq.containsKey(sum - goal)) {
        //         count += freq.get(sum - goal);
        //     }

        //     freq.put(sum, freq.getOrDefault(sum,0) + 1);
        // }

        // return count;

        // SC -> O(1)
        return func(nums,goal) - func(nums,goal - 1);
    }

    int func(int[] nums, int k) {
        int sum = 0;
        int l = 0, r = 0, count = 0;
        if(k < 0) return 0;
        while(r < nums.length) {
            sum += nums[r];

            while(sum > k) {
                sum -= nums[l];
                l++;
            }

            count += r - l + 1;
            r++;
        }
        return count;
    }
}