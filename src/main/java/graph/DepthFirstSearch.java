package graph;

import java.util.*;

public class DepthFirstSearch {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // O(V+E) time complexity | O(V) space complexity where V is the number of vertices and E is the number of edges
        //Store all the edges according to node in graph
        Map<Integer, List<Integer>> graph = new HashMap<>(); // this is also called adjacency list

        // Initialize the graph
        for (int i = 0; i < n; ++i) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]); // for undirected graph add both
            graph.get(edge[1]).add(edge[0]); // for directed graph don't add this line
        }

        //Create a stack to store the nodes
        boolean[] seen = new boolean[n];
        // stack or deque both will work
//        Deque<Integer> stack = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int currNode = stack.pop();
            if (currNode == destination) {
                return true;
            }

            if (seen[currNode]) {
                continue;
            }
            seen[currNode] = true; // Mark the node as seen

            // Add all the neighbors of the node to the stack
            for (int neighbor : graph.get(currNode)) {
                stack.push(neighbor);
            }
        }
        return false;
    }
    public boolean validPathRecursive(int n, int[][] edges, int source, int destination) {
        // O(V+E) time complexity | O(V) space complexity where V is the number of vertices and E is the number of edges
        Map<Integer, List<Integer>> graph = new HashMap<>();
        boolean[] seen = new boolean[n];

        for (int i = 0; i < n; ++i) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]); // for undirected graph add both
            graph.get(edge[1]).add(edge[0]); // for directed graph don't add this line
        }
        return dfs(graph, seen, source, destination);
    }
    public boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination) {
        if (currNode == destination) {
            return true;
        }
        if (!seen[currNode]) {
            seen[currNode] = true;
            for (int neighbor : graph.get(currNode)) {
                if (dfs(graph, seen, neighbor, destination)) {
                    return true;
                }
            }
        }
        return false;
    }
}
