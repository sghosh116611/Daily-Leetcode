class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        func(nums,res,ds,0);
        return res;
    }

    public void func(int[] nums, List<List<Integer>> res, List<Integer> ds, int idx) {
        res.add(new ArrayList<>(ds));
        for(int i = idx; i < nums.length; i++) {
            if(i != idx && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            func(nums,res,ds, i + 1);
            ds.remove(ds.size() - 1);
        }
    }
}