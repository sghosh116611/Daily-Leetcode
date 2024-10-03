class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int low = j + 1;
                int high = n - 1;

                while(low < high){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[low];
                    sum += nums[high];
                    if(sum == target){
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[low]);
                        res.add(nums[high]);
                        result.add(res);
                        low++;
                        high--;
                        while(low < high && nums[low - 1] == nums[low])
                            low++;
                        while(low < high && nums[high + 1] == nums[high])
                            high--;
                    }else if(sum < target){
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }
        return result;
    }
}