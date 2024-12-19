public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] previous = new boolean[n + 1];
        boolean[] current = new boolean[n + 1];
        previous[0] = true;

        // Initialize the case where the pattern starts with '*'
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                previous[j] = previous[j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            current[0] = false; // The first column will always be false for i > 0
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // If the pattern character before '*' matches the string
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        current[j] = previous[j] || current[j - 2];
                    } else {
                        current[j] = current[j - 2];
                    }
                } else if (p.charAt(j - 1) == '.') {
                    current[j] = previous[j - 1];
                } else {
                    current[j] = previous[j - 1] && (s.charAt(i - 1) == p.charAt(j - 1));
                }
            }
            // Move the current row to previous for the next iteration
            System.arraycopy(current, 0, previous, 0, n + 1);
        }

        return current[n];
    }
}
