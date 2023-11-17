class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int result = 0;

        for(int num : nums){
            set.add(num);
        }

        for(Integer num : set){
            if(set.contains(num - 1))   continue;
            else{
                int temp = num;
                int count = 0;
                while(set.contains(temp++)){
                    count++;
                }
                result = Math.max(result,count);
            }
        }

        return result;
    }
}