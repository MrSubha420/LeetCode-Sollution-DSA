import java.util.*;

public class Solution {

    // Method to calculate the diameter and radius of a tree
    private int[] calculateDiameterAndRadius(int[][] edges, int n) {
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // First BFS to find the farthest node
        int[] farthestFromStart = bfs(0, graph, n);
        // Second BFS from the farthest node to calculate diameter
        int[] farthestFromFarthest = bfs(farthestFromStart[0], graph, n);

        int diameter = farthestFromFarthest[1];
        int radius = (diameter + 1) / 2; // Radius is half the diameter (rounded up)
        return new int[]{diameter, radius};
    }

    // BFS to find the farthest node and its distance
    private int[] bfs(int start, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(start);
        visited[start] = true;

        int farthestNode = start, distance = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                farthestNode = node;
                for (int neighbor : graph.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
        return new int[]{farthestNode, distance};
    }

    // Method to calculate the minimum diameter after merging two trees
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n1 = edges1.length + 1;
        int n2 = edges2.length + 1;

        // Calculate diameters and radii of the two trees
        int[] tree1Data = calculateDiameterAndRadius(edges1, n1);
        int[] tree2Data = calculateDiameterAndRadius(edges2, n2);

        int d1 = tree1Data[0]; // Diameter of tree 1
        int r1 = tree1Data[1]; // Radius of tree 1
        int d2 = tree2Data[0]; // Diameter of tree 2
        int r2 = tree2Data[1]; // Radius of tree 2

        // Calculate combined diameter
        int combinedDiameter = r1 + r2 + 1;
        return Math.max(Math.max(d1, d2), combinedDiameter);
    }
}
