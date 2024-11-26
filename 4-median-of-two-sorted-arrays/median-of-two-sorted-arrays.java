class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    
    if (nums1.length > nums2.length) {
        int[] temp = nums1;
        nums1 = nums2;
        nums2 = temp;
    }

    int total = nums1.length + nums2.length;
    int half = total / 2;

    int l = 0, r = nums1.length;
    while (l <= r) {
        int Amid = (l + r) / 2;
        int Bmid = half - Amid;

        int Aleft = (Amid > 0) ? nums1[Amid - 1] : Integer.MIN_VALUE;
        int Aright = (Amid < nums1.length) ? nums1[Amid] : Integer.MAX_VALUE;
        int Bleft = (Bmid > 0) ? nums2[Bmid - 1] : Integer.MIN_VALUE;
        int Bright = (Bmid < nums2.length) ? nums2[Bmid] : Integer.MAX_VALUE;

        if (Aleft <= Bright && Bleft <= Aright) {
            if (total % 2 == 0) {
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            } else {
                return Math.min(Aright, Bright);
            }
        } else if (Aleft > Bright) {
            r = Amid - 1; 
        } else {
            l = Amid + 1; 
        }
    }

    throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
}
