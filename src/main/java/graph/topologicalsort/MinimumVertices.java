package graph.topologicalsort;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/?envType=study-plan-v2&envId=graph-theory
public class MinimumVertices {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];

        for (var e : edges) {
            int v = e.getLast();
            indegree[v]++;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) list.add(i);
        }

        return list;
    }
}
