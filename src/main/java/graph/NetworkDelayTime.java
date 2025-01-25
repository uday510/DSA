/**
 * You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 *
 * We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 *
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * Output: 2
 */
package graph;

import java.util.*;
public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>(); // graph : src -> dest, weight
        int INFINITY = Integer.MAX_VALUE; // infinity value
        int[] dist = new int[n+1]; // distance from src to dest

        Arrays.fill(dist, INFINITY); // initialize dist array

        for (int[] time : times) { // build graph
            int src = time[0];
            int dest = time[1];
            int weight = time[2];

            if (!graph.containsKey(src)) { // if src is not in graph, add src to graph
                graph.put(src, new ArrayList<>());
            }

            graph.get(src).add(new int[]{dest, weight}); // add dest and weight to src
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight); // min heap

        pq.offer(new Edge(k, 0));
        dist[k] = 0;

        while(!pq.isEmpty()) { // dijkstra algorithm
            Edge curr = pq.poll();
            int dest = curr.dest;
            int weight = curr.weight;

            if (weight > dist[dest]) continue;

            dist[dest] = weight;

            if (!graph.containsKey(dest)) continue;

            for (int[] next : graph.get(dest)) {
                int nextDest = next[0];
                int nextWeight = next[1];

                if (dist[nextDest] != INFINITY) continue;

                pq.offer(new Edge(nextDest, nextWeight + weight));
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == INFINITY) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
    static class Edge {
        int dest;
        int weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
