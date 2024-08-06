class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        func(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    private void func(int idx, int[] nums, int target, List<List<Integer>> ans, 
    List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]) continue;
            if(nums[i] > target) break;

            // Take
            ds.add(nums[i]);
            func(i + 1, nums, target - nums[i], ans, ds);
            ds.remove(ds.size() - 1);

            // Not take
            //func(i + 1, nums, target, ans, ds);
        }
        // // Base
        // if(idx == nums.length - 1){
        //     if(target == 0){
        //         ans.add(new ArrayList<>(ds));
        //     }
        //     return;
        // }
        
    }
}