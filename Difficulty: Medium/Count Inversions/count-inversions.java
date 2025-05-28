// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        return divide(arr,0,arr.length - 1);
    }
    
    private static int divide(int[] arr, int low, int high){
        int res = 0;
        if(low < high){
            int mid = (low + high) / 2;
            
            res += divide(arr,low,mid);
            res += divide(arr,mid + 1, high);
            
            res += countAndSort(arr,low,mid,high);
        }
        return res;
    }
    
    private static int countAndSort(int[] arr, int low, int mid, int high){
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];
        int res = 0;
        
        int k = 0;
        for(int i = low; i <= mid; i++) left[k++] = arr[i];
        k = 0;
        for(int i = mid + 1; i <= high; i++) right[k++] = arr[i];
    
        int i = 0, j = 0; k = low;
        while(i < mid - low + 1 && j < high - mid){
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else{
                arr[k++] = right[j++];
                res += (mid - low + 1 - i);
            }
        }
        
        while (i < mid - low + 1)
            arr[k++] = left[i++];
        while (j < high - mid)
            arr[k++] = right[j++];

        return res;
    }
}