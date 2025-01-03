class Solution {
   public int maxArea(int[] height) {
       int left = 0, right = height.length - 1;
       int ans = 0;
       while (left < right) {
           if (height[left] < height[right]) {
               ans = Math.max(ans, height[left] * (right - left));
               left += 1;
           } else {
               ans = Math.max(ans, height[right] * (right - left));
               right -= 1;
           }
       }
       return ans;
   }
}