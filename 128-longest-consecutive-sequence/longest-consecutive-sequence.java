class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;

        for(int n : nums)
            set.add(n);
        
        for(int n : nums){
            int temp = n;
            if(set.contains(temp - 1)) continue;
            int count = 1;
            while(set.contains(++temp))
            {
                set.remove(temp);
                count++;
            }
            max = Math.max(max,count);
            
        }

        return max;
    }
}