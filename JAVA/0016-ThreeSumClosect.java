class Solution {
   public int threeSumClosest(int[] nums, int target) {
       Arrays.sort(nums);
       int length = nums.length;
       int ans = target;
       int diff = Integer.MAX_VALUE;
       for (int i = 0; i < length - 2; i++) {
           int p1 = i + 1, p2 = length - 1;
           while (p1 < p2) {
               int t = nums[i] + nums[p1] + nums[p2];
               if (t == target)
                   return target;
               if (Math.abs(t - target) < diff) {
                   diff = Math.abs(t - target);
                   ans = t;
               }
               if (t < target)
                   p1++;
               else
                   p2--;
           }
       }
       return ans;
   }
}

