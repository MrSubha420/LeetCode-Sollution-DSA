class Solution {
   public int maxScoreSightseeingPair(int[] values) {
       int n = values.length;
       int maxPref = values[0]; // max value of values[i] + i
       int maxScore = Integer.MIN_VALUE; // to store the maximum score

       for (int j = 1; j < n; j++) {
           // Update max score by considering the current pair
           maxScore = Math.max(maxScore, maxPref + values[j] - j);

           // Update maxPref to include the current position
           maxPref = Math.max(maxPref, values[j] + j);
       }

       return maxScore;
   }
}
