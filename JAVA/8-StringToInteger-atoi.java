class Solution {
   public int myAtoi(String s) {
       // Step 1: Trim the input string to remove leading/trailing whitespaces
       s = s.trim();
       if (s.isEmpty()) {
           return 0;
       }

       // Step 2: Handle the sign
       int sign = 1;
       int index = 0;
       if (s.charAt(0) == '-') {
           sign = -1;
           index++;
       } else if (s.charAt(0) == '+') {
           index++;
       }

       // Step 3: Convert digits to an integer
       int result = 0;
       while (index < s.length() && Character.isDigit(s.charAt(index))) {
           int digit = s.charAt(index) - '0';

           // Check for overflow/underflow
           if (result > (Integer.MAX_VALUE - digit) / 10) {
               return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
           }

           result = result * 10 + digit;
           index++;
       }

       return result * sign;
   }
}
