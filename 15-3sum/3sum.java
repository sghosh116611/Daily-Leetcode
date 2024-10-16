class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            long sum = 0;
            int low = i + 1;
            int high = nums.length - 1;
            while(low < high){
                sum = nums[i] + nums[low] + nums[high];
                if(sum == 0){
                    List<Integer> row = new ArrayList<>();
                    row.add(nums[i]);
                    row.add(nums[low]);
                    row.add(nums[high]);
                    low++;
                    high--;

                    result.add(row);

                    while(low < high && nums[low] == nums[low - 1]) low++;
                    while(high < nums.length - 1 && high >= 0 && nums[high] == nums[high + 1]) high--;
                }else if(sum > 0){
                    high--;
                }else{
                    low++;
                }
                
            }
        }

        return result;
    }
}