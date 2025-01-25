/*
There are n teams numbered from 0 to n - 1 in a tournament; each team is also a node in a DAG.

You are given the integer n and a 0-indexed 2D integer array edges of length m representing the DAG, where edges[i] = [ui, vi] indicates that there is a directed edge from team ui to team vi in the graph.

A directed edge from a to b in the graph means that team a is stronger than team b and team b is weaker than team a.

Team a will be the champion of the tournament if there is no team b that is stronger than team a.

Return the team that will be the champion of the tournament if there is a unique champion, otherwise, return -1.

Notes

A cycle is a series of nodes a1, a2, ..., an, an+1 such that node a1 is the same node as node an+1, the nodes a1, a2, ..., an are distinct, and there is a directed edge from the node ai to node ai+1 for every i in the range [1, n].
A DAG is a directed graph that does not have any cycle.

 */
package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FindChampion2 {


    public int findChampion(int n, int[][] edges) {
        int[] inDegrees = new int[n];

        ArrayList<Integer>[] outgoingEdges = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            outgoingEdges[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            inDegrees[v]++;
            outgoingEdges[u].add(v);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        if (queue.size() != 1) {
            return -1;
        }

        return queue.peek();
    }
}
