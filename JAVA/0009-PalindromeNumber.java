class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Numbers ending in 0 are not palindromes unless the number is 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        // Reverse the number
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // A number is a palindrome if it is equal to its reverse
        return original == reversed;
    }
}
