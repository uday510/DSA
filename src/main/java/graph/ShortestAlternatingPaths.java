package graph;

import java.util.*;

public class ShortestAlternatingPaths {

    static final int RED = 0;
    static final int BLUE = 1;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] adjList = buildGraph(n, redEdges, blueEdges);
        return bfs(n, adjList);
    }

    private int[] bfs(int n, List<int[]>[] adjList) {
        int[][] visited = new int[n][2];
        int[] distance = new int[n];
        Queue<int[]> queue = new ArrayDeque<>();
        Arrays.fill(distance, -1);
        queue.offer(new int[]{0, 0, -1});
        visited[0][RED] = visited[0][BLUE] = 1;
        distance[0] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], steps = curr[1], prevColor = curr[2];

            for (int[] next : adjList[node]) {
                int neighbor = next[0], currColor = next[1];

                if (visited[neighbor][currColor] == 1 || prevColor == currColor) continue;

                queue.offer(new int[] {neighbor, 1 + steps, currColor});

                if (distance[neighbor] == -1) distance[neighbor] = 1 + steps;
                visited[neighbor][currColor] = 1;
            }
        }

        return distance;
    }

    private List<int[]>[] buildGraph(int n, int[][] red, int[][] blue) {
        @SuppressWarnings("unchecked")
        List<int[]>[] graph = (List<int[]>[]) new ArrayList[n];
        for (int i = 0; i < n; ++i) graph[i] = new ArrayList<>();

        for (int[] e : red) graph[e[0]].add(new int[]{e[1], RED});
        for (int[] e : blue) graph[e[0]].add(new int[]{e[1], BLUE});
        return graph;
    }
}
