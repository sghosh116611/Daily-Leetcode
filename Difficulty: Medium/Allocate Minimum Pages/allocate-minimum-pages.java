
//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k) return -1;
        
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int page : arr){
            low = Math.max(page,low);
            high += page;
        }
        //System.out.println(low + " " + high);
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(canAllocateWithMaxPages(arr,mid,k)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return low;
    }
    
    private static boolean canAllocateWithMaxPages(int[] arr, int maxPage,int k){
        int count = 1;
        int sum = 0;
        for(int page:arr){
            
            if(sum + page <= maxPage){
                sum += page;
            }else{
                sum = page;
                count++;
            }
            
            if(count > k) return true;
        }
        
        return false;
    }
}