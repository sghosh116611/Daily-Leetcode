//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        fn(arr,0,0,n);
        return result;
    }
    
    public void fn(ArrayList<Integer> arr, int idx, int sum, int n){
        if(idx == n){
            result.add(sum);
            return;
        }
            
        fn(arr,idx + 1, sum + arr.get(idx), n);
        fn(arr,idx + 1, sum, n);
    }
}