// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        
        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int res = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            
            boolean canBePlaced = checkIfCowsCanBePlacedWithMinimumDistance(stalls,mid,k);
            if(canBePlaced){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return high;
    }
    
    private static boolean checkIfCowsCanBePlacedWithMinimumDistance(int[] stalls, int minDist, int k){
        int count = 1;
        int prevPlacedPos = stalls[0];
        for(int i = 1; i < stalls.length; i++){
            int stallPos = stalls[i];
            if(stallPos - prevPlacedPos >= minDist){
                count++;
                prevPlacedPos = stalls[i];
            }
            if (count >= k) return true;
        }
        
        return false;
    }
}