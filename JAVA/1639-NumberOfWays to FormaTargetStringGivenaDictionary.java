public class Solution {
   public int numWays(String[] words, String target) {
       final int MOD = 1_000_000_007;
       int m = words[0].length(); // Number of columns in the dictionary
       int n = target.length();  // Length of the target string
       
       // Step 1: Count the frequency of each character in each column of words
       int[][] freq = new int[26][m];
       for (String word : words) {
           for (int j = 0; j < m; j++) {
               freq[word.charAt(j) - 'a'][j]++;
           }
       }

       // Step 2: Initialize a 1D DP array
       long[] dp = new long[n + 1];
       dp[0] = 1; // Base case: 1 way to form an empty target

       // Step 3: Fill the DP array
       for (int j = 0; j < m; j++) { // Iterate through each column
           for (int i = n; i >= 1; i--) { // Iterate backwards through the target
               char targetChar = target.charAt(i - 1);
               dp[i] += dp[i - 1] * freq[targetChar - 'a'][j];
               dp[i] %= MOD;
           }
       }

       return (int) dp[n];
   }

   // public static void main(String[] args) {
   //     Solution solution = new Solution();
   //     String[] words = {"acca", "bbbb", "caca"};
   //     String target = "aba";
   //     System.out.println(solution.numWays(words, target)); // Output: 6
   // }
}
