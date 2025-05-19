package graph.bfs;

import java.util.*;

public class CheapestFlightsWithinKStops {

    private static final int UNREACHABLE = (int) 1e9;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; ++i) adjList[i] = new ArrayList<>();

        for (int[] flight : flights) {
            adjList[flight[0]].add(new int[] {flight[1], flight[2]});
        }

        int[] distanceFromSource = new int[n];
        Arrays.fill(distanceFromSource, UNREACHABLE);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0});
        distanceFromSource[src] = 0;

        int stops = 0;

        while (stops <= k) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                int[] curr = queue.poll();
                int node = curr[0], dist = curr[1];

                for (int[] next : adjList[node]) {
                    int neiNode = next[0], neiDist = next[1];
                    int newDist = dist + neiDist;

                    if (newDist < distanceFromSource[neiNode]) {
                        queue.offer(new int[] {neiNode, newDist});
                        distanceFromSource[neiNode] = newDist;
                    }
                }
            }
            stops++;
        }

        return distanceFromSource[dst] ==  UNREACHABLE ? -1: distanceFromSource[dst];
    }
}
