// import java.util.Arrays;

class Solution {
   public int findTargetSumWays(int[] nums, int S) {
       int totalSum = Arrays.stream(nums).sum();
       
       // Check if target is feasible
       if ((S + totalSum) % 2 != 0 || S > totalSum || S < -totalSum) {
           return 0;
       }
       
       int target = (S + totalSum) / 2;
       return subsetSum(nums, target);
   }

   private int subsetSum(int[] nums, int target) {
       int[] dp = new int[target + 1];
       dp[0] = 1; // There's one way to make sum 0: choose no elements.

       for (int num : nums) {
           for (int j = target; j >= num; j--) {
               dp[j] += dp[j - num];
           }
       }

       return dp[target];
   }
}
