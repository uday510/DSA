package graph;

import java.util.*;

public class AllPathsFromSourceToTargetBFS {
    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
        System.out.println(allPathsSourceTarget(graph));
    }
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // O(2^V * V) time | O(V) space where V is the number of vertices in the graph
        /**
         * There are 2^V possible paths in the graph,
         * and each path can have at most V vertices,
         * we need O(V) time to build each path,
         */
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return paths;
        }
        // queue stores the path
        Queue<List<Integer>> queue = new LinkedList<>();
        // add the first node to the queue
        List<Integer> path = new ArrayList<>();
        path.add(0);
        queue.offer(path);

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int lastNode = currentPath.get(currentPath.size() - 1);
            for (int nextNode : graph[lastNode]) {
                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(nextNode);
                if (nextNode == graph.length - 1) {
                    // reach the last node of the graph and add the path to the result
                    paths.add(newPath);
                } else {
                    // add the path to the queue for further exploration
                    queue.offer(newPath);
                }
            }
        }
        return paths;
    }
}
