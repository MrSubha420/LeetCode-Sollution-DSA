class Solution {
   public int countGoodStrings(int low, int high, int zero, int one) {
       final int MOD = 1_000_000_007; // Modulo constant to handle large numbers
       int[] dp = new int[high + 1];

       // Base case: Strings of length in the range [low, high] are initially valid
       for (int i = low; i <= high; i++) {
           dp[i] = 1;
       }

       // Traverse from high to 0 to accumulate the number of good strings
       for (int length = high; length >= 0; length--) {
           // Extend the string by appending '0's if within bounds
           if (length + zero <= high) {
               dp[length] = (dp[length] + dp[length + zero]) % MOD;
           }
           // Extend the string by appending '1's if within bounds
           if (length + one <= high) {
               dp[length] = (dp[length] + dp[length + one]) % MOD;
           }
       }

       return dp[0]; // Return the total count of good strings starting from length 0
   }
}
