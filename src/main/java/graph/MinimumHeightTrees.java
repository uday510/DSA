package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MinimumHeightTrees {


    public static void main(String[] args) {

    }
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        /* TODO: A tree is an undirected graph in which any two vertices are connected
            by exactly one path. In other words, any connected graph without simple cycles is a tree.
         */
        if (n == 1) return Collections.singletonList(0);

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; ++i) graph.add(new ArrayList<>());

        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leafNodes = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (graph.get(i).size() == 1) leafNodes.add(i);


        while (n > 2) {
            n -= leafNodes.size();
            List<Integer> newLeafNodes = new ArrayList<>();
            for (int i : leafNodes) {
                int neighbor = graph.get(i).get(0); // Assuming leafNodes.size() == 1
                graph.get(neighbor).remove(Integer.valueOf(i)); // Remove the leaf node from its neighbor's adjacency list
                if (graph.get(neighbor).size() == 1) {
                    newLeafNodes.add(neighbor); // If the neighbor becomes a new leaf node, add it to the newLeafNodes list
                }
            }
            leafNodes = newLeafNodes;
        }
        return leafNodes;

    }
}
