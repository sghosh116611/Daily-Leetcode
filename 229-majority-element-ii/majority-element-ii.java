class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int can1 = -1;
        int count1 = 0;

        int can2 = -1;
        int count2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == can1) count1++;
            else if(nums[i] == can2) count2++;
            else if(count1 == 0){
                count1 = 1;
                can1 = nums[i];
            }else if(count2 == 0){
                count2 = 1;
                can2 = nums[i];
            }else{
                count1--;
                count2--;
            }
        }

        System.out.println(can1 + " " + count1 + " " + can2 + " " + count2);

        count1 = 0; count2 = 0;
        for(int num : nums){
            if(num == can1) count1++;
            else if(num == can2) count2++;
        }

        if(count1 > nums.length / 3) list.add(can1);
        if(count2 > nums.length / 3) list.add(can2);

        return list;
    }
}