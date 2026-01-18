class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        func(candidates,target,res,new ArrayList<>(),0);
        return res;
    }
    
    private void func(int[] nums, int k, List<List<Integer>> res, List<Integer> ds, int idx) {
        
        if(idx == nums.length) {
            if(k == 0)
                res.add(new ArrayList<>(ds));
            return;
        }

        if(nums[idx] <= k) {
            ds.add(nums[idx]);
            int take = k - nums[idx];
            func(nums,take,res,ds,idx);
            ds.remove(ds.size() - 1);
        }

        int notTake = k;
        func(nums,notTake,res,ds,idx + 1);
    }

}