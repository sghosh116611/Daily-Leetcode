class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int pile : piles){
            high = Math.max(pile,high);
        }

        while(low <= high){
            int mid = (low + high) / 2;
            System.out.println(mid);
            int totalHrs = totalHrsToEatAllBanana(piles,mid);
            if(totalHrs > h){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    private int totalHrsToEatAllBanana(int[] piles, int rate){
        int totalHrs = 0;
        for(int pile : piles){
            totalHrs += Math.ceil((double)pile / rate);
        }
        return totalHrs;
    }
}