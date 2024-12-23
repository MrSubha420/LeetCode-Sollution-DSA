// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
       Arrays.sort(nums); // Sort the array
       List<List<Integer>> result = new ArrayList<>();
       int n = nums.length;

       for (int i = 0; i < n - 2; i++) {
           // Skip duplicate values for the first element
           if (i > 0 && nums[i] == nums[i - 1]) continue;

           int left = i + 1, right = n - 1;

           while (left < right) {
               int sum = nums[i] + nums[left] + nums[right];
               
               if (sum == 0) {
                   result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                   left++;
                   right--;

                   // Skip duplicates for the second and third elements
                   while (left < right && nums[left] == nums[left - 1]) left++;
                   while (left < right && nums[right] == nums[right + 1]) right--;

               } else if (sum < 0) {
                   left++; // Increase sum by moving `left` pointer
               } else {
                   right--; // Decrease sum by moving `right` pointer
               }
           }
       }

       return result;
   }
}
