import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0; // Variable to store the maximum length
        int p = 0;   // Start index of the current window
        HashMap<Character, Integer> charIndexMap = new HashMap<>(); // Tracks the last index of each character

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character is already in the map and within the current window
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= p) {
                // Move the start of the window to the right of the last occurrence
                p = charIndexMap.get(currentChar) + 1;
            }

            // Update the maximum length
            ans = Math.max(ans, i - p + 1);

            // Update the character's latest index
            charIndexMap.put(currentChar, i);
        }

        return ans;
    }
}
