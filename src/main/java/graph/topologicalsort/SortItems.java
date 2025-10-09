package graph.topologicalsort;

import java.util.*;

// https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/?envType=study-plan-v2&envId=graph-theory
public class SortItems {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int numGroups = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = numGroups++;
            }
        }

        List<Integer>[] itemsAdjList = new ArrayList[n];
        int[] itemsIndegree = new int[n];
        for (int i = 0; i < n; i++) itemsAdjList[i] = new ArrayList<>();

        List<Integer>[] groupsAdjList = new ArrayList[numGroups];
        int[] groupsIndegree = new int[numGroups];
        for (int i = 0; i < numGroups; i++) groupsAdjList[i] = new ArrayList<>();

        for (int v = 0; v < n; v++) {
            for (int u : beforeItems.get(v)) {
                itemsAdjList[u].add(v);
                itemsIndegree[v]++;

                if (group[u] != group[v]) {
                    groupsAdjList[group[u]].add(group[v]);
                    groupsIndegree[group[v]]++;
                }
            }
        }

        List<Integer> items = topo(itemsAdjList, itemsIndegree);
        if (items.isEmpty()) return new int[]{};

        List<Integer> groups = topo(groupsAdjList, groupsIndegree);
        if (groups.isEmpty()) return new int[] {};

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int item : items) {
            map.computeIfAbsent(group[item], _ -> new ArrayList<>()).add(item);
        }

        List<Integer> list = new ArrayList<>();
        for (int g : groups) {
            if (map.containsKey(g)) list.addAll(map.get(g));
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);

        return res;
    }

    private List<Integer> topo(List<Integer>[] adjList, int[] indegree) {
        int n = indegree.length;
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited.add(u);

            for (int v : adjList[u]) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited.size() == n ? visited : new ArrayList<>();
    }
}
