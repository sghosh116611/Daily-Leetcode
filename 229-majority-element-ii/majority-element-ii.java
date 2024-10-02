class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int maj1 = -1;
        int count1 = 0;
        int maj2 = -1;
        int count2 = 0;

        for(int num : nums){
            if(num == maj1){
                count1++;
            }else if(num == maj2){
                count2++;
            }else if(count1 == 0){
                maj1 = num;
                count1 = 1;
            }else if(count2 == 0){
                maj2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
            System.out.println(maj1 + " " + maj2);
        }
        
        count1 = 0;
        count2 = 0;
        for(int num: nums){
            if(num == maj1) count1++;
            else if(num == maj2) count2++;
        }

        if(count1 > nums.length / 3)
            result.add(maj1);
        if(count2 > nums.length / 3)
            result.add(maj2);
        
        return result;
    }
}