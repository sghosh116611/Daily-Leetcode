class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums);
        return nums;
    }

    public void sort(int[] nums){
        //mergeSort(nums,0,nums.length - 1);
        quickSort(nums,0,nums.length - 1);
    }

    public void mergeSort(int[] nums, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;

            mergeSort(nums,low,mid);
            mergeSort(nums,mid + 1,high);

            merge(nums,low, mid, high);
        }
    }

    public void merge(int[] arr, int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for(int i = 0; i < n1; i++){
            left[i] = arr[low + i];
        }

        for(int i = 0; i < n2; i++){
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;

        while(i < n1 && j < n2){
            if(left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while(i < n1){
            arr[k++] = left[i++];
        }

        while(j < n2){
            arr[k++] = right[j++];
        }
    }

    public void quickSort(int[] arr, int low, int high){
        if(low < high){
            
            int pvIdx = partition(arr, low, high);

            quickSort(arr,low,pvIdx - 1);
            quickSort(arr,pvIdx + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high){
        int pvIdx = new Random().nextInt(high - low + 1) + low;
        int pivot = arr[pvIdx];

        swap(arr, pvIdx, high);

        int i = low - 1;
        for(int j = low; j <= high - 1; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i + 1,high);
        return i + 1;
    }

    private void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}