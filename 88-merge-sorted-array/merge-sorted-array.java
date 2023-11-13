class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        n = (m + n) - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[n] = nums1[i];
                i--;
            }else if(nums1[i] < nums2[j]){
                nums1[n] = nums2[j];
                j--;
            }else{
                nums1[n] = nums2[j];
                nums1[--n] = nums1[i];
                i--;
                j--;
            }
            System.out.println(nums1[n]);
            n--;
        }
         System.out.println(j);
        while(j >= 0){
            nums1[n--] = nums2[j--];
        }
    }
}