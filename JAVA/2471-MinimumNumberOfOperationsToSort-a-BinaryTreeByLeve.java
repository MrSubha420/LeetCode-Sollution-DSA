/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
   public int minimumOperations(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       int ops = 0;

       while (!q.isEmpty()) {
           int sz = q.size();
           List<Integer> levelValues = new ArrayList<>();

           // Level Order Traversal
           for (int i = 0; i < sz; i++) {
               TreeNode node = q.poll();

               if (node.left != null) q.add(node.left);
               if (node.right != null) q.add(node.right);

               levelValues.add(node.val);
           }

           // Finding minimum swaps needed to sort the current level
           ops += minSwapsToSort(levelValues);
       }

       return ops;
   }

   private int minSwapsToSort(List<Integer> levelValues) {
       int n = levelValues.size();
       List<int[]> arr = new ArrayList<>();
       
       for (int i = 0; i < n; i++) {
           arr.add(new int[]{levelValues.get(i), i});
       }

       // Sort by the values of the nodes
       arr.sort(Comparator.comparingInt(a -> a[0]));
       boolean[] visited = new boolean[n];
       int swaps = 0;

       for (int i = 0; i < n; i++) {
           if (visited[i] || arr.get(i)[1] == i) continue;

           int cycleSize = 0;
           int j = i;

           while (!visited[j]) {
               visited[j] = true;
               j = arr.get(j)[1];
               cycleSize++;
           }

           if (cycleSize > 0) {
               swaps += (cycleSize - 1);
           }
       }

       return swaps;
   }
}