class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);  
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = n - 1;

                while(l < r){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[l];
                    sum += nums[r];
                    if(sum == target)
                    {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        result.add(temp);
                        l++;
                        r--;

                        while(l < r && nums[l] == nums[l - 1]) l++;
                        while(l < r && nums[r] == nums[r + 1]) r--;
                    }else if(sum > target){
                        r--;
                    }else{
                        l++;
                    }
                }
            }
        }

        return result;
    }
}