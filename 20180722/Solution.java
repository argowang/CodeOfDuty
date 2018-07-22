class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen %2 ==1 ){
            return findKth(nums1,0,nums2,0,totalLen/2 + 1);
        }
        return (findKth(nums1,0,nums2,0,totalLen/2)+findKth(nums1,0,nums2,0,totalLen/2+1)/2);
    }

    // find the kth value in two sorted array
    public double findKth(int[] a, int startA, int[] b, int startB, int k) {
        if (startA >= a.length) return b[startB+k-1];
        if (startB >= b.length) return a[startA+k-1];
        if (k == 1) return Math.min(a[startA], b[startB]);

        int aValue = startA + k/2 -1 < a.length ? a[startA+k/2-1] : Integer.MAX_VALUE;
        int bValue = startB + k/2 -1 < b.length ? b[startB+k/2-1]: Integer.MAX_VALUE;

        if (aValue<bValue) {
            return findKth(a,startA+k/2, b, startB, k-k/2);
        } else {
            return findKth(a,startA, b, startB+k/2, k-k/2);
        }
    }
}
