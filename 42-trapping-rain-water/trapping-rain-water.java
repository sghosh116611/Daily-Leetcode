class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;

        int maxLeft = Integer.MIN_VALUE, maxRight = Integer.MIN_VALUE, total = 0;
        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }else{
                    total += maxLeft - height[left];
                }
                left++;
            }else{
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }else{
                    total += maxRight - height[right];
                }
                right--;
            }
        }

        return total;
    }
}