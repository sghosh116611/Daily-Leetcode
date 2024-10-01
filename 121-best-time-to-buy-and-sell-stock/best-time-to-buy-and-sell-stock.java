class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int price : prices){
            min = Math.min(price,min);
            max = Math.max(price - min,max);
        }

        return max;
    }
}