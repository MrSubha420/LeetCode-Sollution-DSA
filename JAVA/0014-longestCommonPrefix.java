class Solution {
   public String longestCommonPrefix(String[] strs) {
       if (strs == null || strs.length == 0) {
           return "";
       }

       String prefix = strs[0];  // Assume the first string as the initial prefix
       for (int i = 1; i < strs.length; i++) {
           // Reduce the prefix until it matches the current string
           while (strs[i].indexOf(prefix) != 0) {
               prefix = prefix.substring(0, prefix.length() - 1);  // Trim one character at a time
               if (prefix.isEmpty()) {
                   return "";  // No common prefix
               }
           }
       }
       return prefix;
   }
}
