class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i <= n - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1])  continue;
            for(int j = i + 1; j <= n - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1])  continue;

                int l = j + 1;
                int r = n;
                while(l < r){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[l];
                    sum += nums[r];
                    if(target == sum){
                        System.out.println(target + " " + sum);
                        List<Integer> row = new ArrayList<>();
                        row.add(nums[i]);
                        row.add(nums[j]);
                        row.add(nums[l]);
                        row.add(nums[r]);
                        result.add(row);
                        l++;
                        r--;

                        while(l < r && nums[l] == nums[l - 1]) l++;
                        while(l < r && nums[r] == nums[r + 1]) r--;
                    }else if(sum < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }

        return result;
    }
}