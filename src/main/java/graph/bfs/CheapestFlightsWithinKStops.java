package graph.bfs;

import java.util.*;

public class CheapestFlightsWithinKStops {

    private static final int UNREACHABLE = (int) 1e9;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] adjList = new ArrayList[n];

        for (int idx = 0; idx < n; ++idx) {
            adjList[idx] = new ArrayList<>();
        }

        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], dest = flight[2];
            adjList[from].add(new int[] {to, dest});
        }

        int[] dists = new int[n];
        Arrays.fill(dists, UNREACHABLE);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {src, 0, 0});

       while (!queue.isEmpty()) {
           int[] curr = queue.poll();
           int node = curr[0], cost = curr[1], stops = curr[2];

           if (stops > k) continue;

           for (int[] neighbor : adjList[node]) {
               int nextNode = neighbor[0], price = neighbor[1];
               int newCost = cost + price;

               if (newCost > dists[nextNode]) continue;

               dists[nextNode] = newCost;
               queue.offer(new int[] {nextNode, newCost, stops + 1});
           }
       }

        return dists[dst] == UNREACHABLE ? -1 : dists[dst];
    }
}
