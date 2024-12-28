class Solution {
   public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
       int n = nums.length;
       int[] windowSum = new int[n - k + 1];
       int currentSum = 0;

       // Step 1: Calculate sums of all subarrays of size k
       for (int i = 0; i < k; i++) {
           currentSum += nums[i];
       }
       windowSum[0] = currentSum;
       for (int i = 1; i <= n - k; i++) {
           currentSum += nums[i + k - 1] - nums[i - 1];
           windowSum[i] = currentSum;
       }

       // Step 2: Compute the best indices for left and right intervals
       int[] left = new int[windowSum.length];
       int[] right = new int[windowSum.length];

       // Best index for the left interval
       int bestLeftIdx = 0;
       for (int i = 0; i < windowSum.length; i++) {
           if (windowSum[i] > windowSum[bestLeftIdx]) {
               bestLeftIdx = i;
           }
           left[i] = bestLeftIdx;
       }

       // Best index for the right interval
       int bestRightIdx = windowSum.length - 1;
       for (int i = windowSum.length - 1; i >= 0; i--) {
           if (windowSum[i] >= windowSum[bestRightIdx]) { // Tie-breaking to favor smaller indices
               bestRightIdx = i;
           }
           right[i] = bestRightIdx;
       }

       // Step 3: Find the maximum sum of three subarrays
       int maxSum = 0;
       int[] result = new int[3];
       for (int mid = k; mid < windowSum.length - k; mid++) {
           int l = left[mid - k];
           int r = right[mid + k];
           int total = windowSum[l] + windowSum[mid] + windowSum[r];
           if (total > maxSum) {
               maxSum = total;
               result[0] = l;
               result[1] = mid;
               result[2] = r;
           }
       }

       return result;
   }
}
