class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> countMap = new HashMap<>();

        for(int num : nums){
            countMap.put(num,countMap.getOrDefault(num,0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer,Integer> entry : countMap.entrySet()){
            if(entry.getValue() == 1)
                return -1;
                
            if(entry.getValue() % 3 == 1){
                count += (entry.getValue() / 3) - 1;
                count += 2;
            }else{
                count += entry.getValue() / 3;
                count += (entry.getValue() % 3) / 2;
            }
        }
        return count;
    }
}