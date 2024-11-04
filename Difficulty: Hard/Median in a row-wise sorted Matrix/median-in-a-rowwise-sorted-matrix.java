//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for(int i = 0; i < R; i++){
            min = Math.min(min,matrix[i][0]);   
            max = Math.max(max,matrix[i][C - 1]);
        }
        
        int low = min;
        int high = max;
        int required = (R * C) / 2;
        while(low <= high){
            int mid = (low + high) / 2;
            
            int noOfElementsSmallerThanMid = func(matrix,mid,R,C);
            if(noOfElementsSmallerThanMid <= required)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return low;
    }
    
    private int func(int[][] matrix, int mid, int R, int C){
        int cnt = 0;
        for(int i = 0; i < R; i++){
            int[] arr = matrix[i];
            
            int low = 0;
            int high = C - 1;
            int res = C;
            
            while(low <= high){
                int midElem = (low + high) / 2;
                if(arr[midElem] > mid){
                    res = midElem;
                    
                    high = midElem - 1;
                }else{
                    low = midElem + 1;
                }
            }
            //System.out.println(res);
            cnt += res;
        }
        return cnt;
    }
}