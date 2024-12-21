class Solution {
   public int romanToInt(String s) {
       HashMap<Character, Integer> map = new HashMap<>() {{
           put('I', 1); put('V', 5); put('X', 10); 
           put('L', 50); put('C', 100); put('D', 500); put('M', 1000);
       }};
       int total = 0, prevValue = 0;
       for (int i = s.length() - 1; i >= 0; i--) {
           int currValue = map.get(s.charAt(i));
           total += (currValue < prevValue) ? -currValue : currValue;
           prevValue = currValue;
       }
       return total;
   }
}