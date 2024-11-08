//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        
        int low = 1;
        int high = stalls[stalls.length - 1];
        
        while(low <= high){
            int mid = (low + high) >> 1;
            if(canPlace(stalls,k,mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return high;
    }
    
    private static boolean canPlace(int[] stalls, int k, int dist){
        int totalCow = 1, last = stalls[0];
        
        for(int i = 1; i < stalls.length; i++){
            if(stalls[i] - last >= dist ){
                totalCow++;
                last = stalls[i];
            }
        }
        return totalCow >= k;
    }
}