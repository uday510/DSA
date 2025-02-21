package graph;

import java.util.*;

/**
 * In Graph theory, the primary use cases of the “breadth-first search” (“BFS”) algorithm are:
 *
 * Traversing all vertices in the “graph”;
 * Finding the shortest path between two vertices in a graph where all edges have equal and positive weights.
 */

public class BreadFirstSearch {

    public boolean validPath(int n, int[][] edges, int start, int end) {
        // O(V + E) time complexity | O(V) space complexity where V is the number of vertices and E is the number of edges
        // Create adjacency list to represent graph
        List<Integer>[] adjList = new ArrayList[n];

        // Initialize adjacency list
        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]); // for undirected graph add both
            adjList[edge[1]].add(edge[0]); // for directed graph don't add this line
        }

        // Create a queue to store the nodes
        Queue<Integer> queue = new LinkedList<>();
        // Add the start node to the queue
        queue.add(start);
        // Create a boolean array to mark the nodes as seen
        boolean[] seen = new boolean[n];
        // fill the seen array with false
        Arrays.fill(seen, false);
        // Mark the start node as seen
        seen[start] = true;

        while (!queue.isEmpty()) {
            // Get the current node from the queue
            int currNode = queue.poll();
            // Check if the current node is the destination node
            if (currNode == end) {
                return true;
            }

            // Add all the neighbors of the node to the queue
            for (int neighbor : adjList[currNode]) {
                // check if the neighbor is already seen
                if (seen[neighbor]) continue;
                // Mark the neighbor as seen
                seen[neighbor] = true;
                // Add the neighbor to the queue
                queue.add(neighbor);
            }
        }

        return false;
    }
}
