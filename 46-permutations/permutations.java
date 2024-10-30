class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        fn(nums,0,result);
        return result;
    }

    public void fn(int[] nums, int idx, List<List<Integer>> result){
        if(idx == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                ds.add(nums[i]);
            }
            result.add(new ArrayList<>(ds));
            return;
        }
        for(int i = idx; i < nums.length; i++){
            swap(nums,i,idx);
            fn(nums,idx + 1, result);
            swap(nums,i,idx);
        }
    }

    public void swap(int[] nums, int idx1, int idx2){
        int k = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = k;
    }
}