package LinkedIn;

import java.util.*;

public class Graph_Valid_Tree {
    /**
     * idea: first, edge number < node number
     *      second, bfs visit the graph is fully connected
     */

    // time O(n)
    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;
        // build a graph
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        //bfs
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.offer(0);
        seen.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adjacencyList.get(node)) {
                if (seen.contains(neighbour)) continue;
                seen.add(neighbour);
                queue.offer(neighbour);
            }
        }

        return seen.size() == n;
    }

}
