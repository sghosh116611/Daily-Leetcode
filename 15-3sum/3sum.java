class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 1; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int p = i + 1;
            int q = nums.length - 1;
            
            while(p < q){
                int sum = nums[i] + nums[p] + nums[q];
                if(sum == 0){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[p]);
                    res.add(nums[q]);
                    result.add(res);
                    while(p < q && nums[p] == nums[p + 1]) p++;
                    while(p < q && nums[q] == nums[q - 1]) q--;
                    p++;
                    q--;
                }else if(sum > 0){
                    q--;
                }else{
                    p++;
                }
            }

            
        }

        return result;
    }
}