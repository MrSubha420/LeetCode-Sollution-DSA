class Solution {
   public int reverse(int x) {
       int result = 0; // Reversed number

       while (x != 0) {
           int digit = x % 10; // Extract the last digit
           x = x / 10;         // Remove the last digit

           // Check for overflow or underflow before multiplying by 10
           if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
               return 0; // Overflow
           }
           if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
               return 0; // Underflow
           }

           result = result * 10 + digit; // Append the digit
       }

       return result;
   }
}
