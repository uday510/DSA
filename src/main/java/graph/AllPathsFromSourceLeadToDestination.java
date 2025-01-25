/**
 * Given the edges of a directed graph where edges[i] = [ai, bi] indicates there is an edge between nodes ai and bi, and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually, end at destination, that is:
 *
 * At least one path exists from the source node to the destination node
 * If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
 * The number of possible paths from source to destination is a finite number.
 * Return true if and only if all roads from source lead to destination.
 *
 * Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
 * Output: false
 * Explanation: It is possible to reach and get stuck on both node 1 and node 2.
 */
package graph;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceLeadToDestination {
    // We don't use the state WHITE as such anywhere, Instead, the "null" values in the states array are interpreted as WHITE.

    enum Color { GRAY, BLACK };
    public static void main(String[] ags) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        int source = 0;
        int destination = 3;
        int n = 4;
        System.out.println(leadsToDestination(n, edges, source, destination));
    }
    public static boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // O(V + E) time complexity | O(E) space complexity
        List<Integer>[] graph = buildDigraph(n, edges);
        return leadsToDestination(graph, source, destination, new Color[n]);
    }
    public static boolean leadsToDestination(List<Integer>[] graph, int node, int destination, Color[] states) {

        // if the state is GRAY, this is a backward edge and hence, it creates a cycle.
        if (states[node] != null) {
            return states[node] == Color.BLACK;
        }

        // if this is a leaf node, it should be equal to the destination.
        if (graph[node].isEmpty()) {
            return node == destination;
        }
        // Now, we are processing this node. So, we mark it as GRAY
        states[node] = Color.GRAY;

        for (int next : graph[node]) {
            if (!leadsToDestination(graph, next, destination, states)) {
                return false;
            }
        }
        // Recursion ends here. We are done processing this node. So, we mark it as BLACK
        states[node] = Color.BLACK;
        return true;
    }
    public static List<Integer>[] buildDigraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        return graph;
    }
}
