class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int major1 = -1;
        int major2 = -1;

        int count1 = 0;
        int count2 = 0;

        for(int num : nums){
            if(num == major1)   count1++;
            else if(num == major2) count2++;
            else if(count1 == 0){
                major1 = num;
                count1 = 1;
            }else if(count2 == 0){
                major2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums){
            if(num == major1) count1++;
            else if(num == major2) count2++;
        }

        if(count1 > Math.floor(nums.length / 3)){
            result.add(major1);
        }

        if(count2 > Math.floor(nums.length / 3)){
            result.add(major2);
        }

        return result;
    }
}