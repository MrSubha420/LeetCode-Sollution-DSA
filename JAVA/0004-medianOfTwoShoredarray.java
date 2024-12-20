class Solution {
   public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int totalLength = nums1.length + nums2.length;

       // If total length is odd, return the middle element
       if (totalLength % 2 == 1) {
           return findKth(nums1, nums2, totalLength / 2);
       }
       // If total length is even, return the average of the two middle elements
       else {
           return (findKth(nums1, nums2, totalLength / 2 - 1) + findKth(nums1, nums2, totalLength / 2)) / 2.0;
       }
   }

   private int findKth(int[] nums1, int[] nums2, int k) {
       int index1 = 0, index2 = 0;

       while (true) {
           // If nums1 is exhausted, return the k-th element from nums2
           if (index1 == nums1.length) {
               return nums2[index2 + k];
           }

           // If nums2 is exhausted, return the k-th element from nums1
           if (index2 == nums2.length) {
               return nums1[index1 + k];
           }

           // If k == 0, return the smaller of the first elements of nums1 and nums2
           if (k == 0) {
               return Math.min(nums1[index1], nums2[index2]);
           }

           // Calculate the new indices to compare elements
           int halfK = (k - 1) / 2;
           int newIndex1 = Math.min(index1 + halfK, nums1.length - 1);
           int newIndex2 = Math.min(index2 + halfK, nums2.length - 1);

           int pivot1 = nums1[newIndex1];
           int pivot2 = nums2[newIndex2];

           // Eliminate the half of the array with smaller pivot
           if (pivot1 <= pivot2) {
               k -= (newIndex1 - index1 + 1);
               index1 = newIndex1 + 1;
           } else {
               k -= (newIndex2 - index2 + 1);
               index2 = newIndex2 + 1;
           }
       }
   }
}
