import java.util.*;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] result = new int[queries.length];
        Arrays.fill(result, -1); // Initialize result with -1

        // List of deferred queries for each building
        List<List<int[]>> qs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            qs.add(new ArrayList<>());
        }

        // Populate the deferred query list or directly solve simple queries
        for (int index = 0; index < queries.length; index++) {
            int alice = queries[index][0];
            int bob = queries[index][1];

            // Ensure `alice` is the smaller index for consistency
            if (alice > bob) {
                int temp = alice;
                alice = bob;
                bob = temp;
            }

            // Directly solvable queries
            if (alice == bob || heights[alice] < heights[bob]) {
                result[index] = bob;
            } else {
                // Defer the query for processing later
                qs.get(bob).add(new int[]{heights[alice], index});
            }
        }

        // Min-heap to process deferred queries efficiently
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Iterate through each building
        for (int index = 0; index < n; index++) {
            int height = heights[index];

            // Add deferred queries related to this building
            for (int[] q : qs.get(index)) {
                minHeap.add(q);
            }

            // Process the heap for this building
            while (!minHeap.isEmpty() && minHeap.peek()[0] < height) {
                // Remove satisfied queries
                int[] query = minHeap.poll();
                int queryIndex = query[1];
                // Update result with the current building
                result[queryIndex] = index;
            }
        }

        return result;
    }
}