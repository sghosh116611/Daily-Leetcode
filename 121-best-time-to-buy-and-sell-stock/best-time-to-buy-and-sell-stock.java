class Solution {
    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int profit = 0;
        for(int price : prices){
            lowest = Math.min(price,lowest);
            profit = Math.max(profit, price - lowest);
        }
        return profit;
    }
}