//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int n = arr1.length;
        int m = arr2.length;
        
        if(n > m)
            return kthElement(k,arr2,arr1);
        
        int low = Math.max(0,k-m);
        int high = Math.min(k,n);
        
        while(low <= high){
            int mid1 = low + (high - low) / 2;
            int mid2 = k - mid1;
            
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int r1 = mid1 == n ? Integer.MAX_VALUE : arr1[mid1];
            int r2 = mid2 == m ? Integer.MAX_VALUE : arr2[mid2];
            
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }else if(l1 > r2){
                high = mid1 - 1;
            }else{
                low = mid1 + 1;
            }
            
        }
        
        return 1;
    }
}