// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int nums[]) {
        // code here
        int twice = -1, once = -1;
        for(int i = 0; i < nums.length; i++){
            int idx = (int)Math.abs(nums[i]) - 1;
            if(nums[idx] < 0) twice = idx + 1;
            nums[idx] *= -1;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && i != twice - 1) once = i + 1;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(twice);
        list.add(once);
        
        return list;
    }
}
