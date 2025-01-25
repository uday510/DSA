/*
There are n items each belonging to zero or one of m groups where group[i] is the group that the i-th item belongs to and it's equal to -1 if the i-th item belongs to no group. The items and the groups are zero indexed. A group can have no item belonging to it.

Return a sorted list of the items such that:

The items that belong to the same group are next to each other in the sorted list.
There are some relations between these items where beforeItems[i] is a list containing all the items that should come before the i-th item in the sorted array (to the left of the i-th item).
Return any solution if there is more than one solution and return an empty list if there is no solution.

Input: n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
Output: [6,3,4,1,5,2,0,7]

 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortItemsByGroups {
    public static void main(String[] args) {
        int n = 8;
        int m = 2;
        int[] group = {-1,-1,1,0,0,1,0,-1};
        List<List<Integer>> beforeItems = List.of(List.of(), List.of(6), List.of(5), List.of(6), List.of(3, 6), List.of(), List.of(), List.of());

        int[] ans = sortItems(n, m, group, beforeItems);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
    public static int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // step 1: if item belongs to no group, assign it to a new group
        int id = m;

        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = id++;
            }
        }

        // sort items in each group

        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            groupMap.putIfAbsent(group[i], new ArrayList<>());
            groupMap.get(group[i]).add(i);
        }

        // step 2: build graph for items
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];

        for (int i = 0; i < beforeItems.size(); i++) {
            for (int j : beforeItems.get(i)) {
                if (group[i] == group[j]) {
                    graph.putIfAbsent(j, new ArrayList<>());
                    graph.get(j).add(i);
                    indegree[i]++;
                }
            }
        }

        // step 3: build graph for groups

        Map<Integer, List<Integer>> groupGraph = new HashMap<>();

        for (int i = 0; i < group.length; i++) {
            groupGraph.putIfAbsent(group[i], new ArrayList<>());
        }

        for (int i = 0; i < beforeItems.size(); i++) {
            for (int j : beforeItems.get(i)) {
                if (group[i] != group[j]) {
                    groupGraph.get(group[j]).add(group[i]);
                }
            }
        }

        // step 4: topological sort for groups

        List<Integer> groupOrder = topologicalSort(groupGraph, indegree, groupMap.size());

        if (groupOrder.size() == 0) {
            return new int[0];
        }

        // step 5: topological sort for items

        List<Integer> itemOrder = new ArrayList<>();

        for (int groupId : groupOrder) {
            List<Integer> items = groupMap.get(groupId);
            List<Integer> order = topologicalSort(graph, indegree, items.size());

            if (order.size() == 0) {
                return new int[0];
            }

            itemOrder.addAll(order);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = itemOrder.get(i);
        }

        return ans;

    }
    public static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree, int n) {
        List<Integer> order = new ArrayList<>();
        List<Integer> sources = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                sources.add(i);
            }
        }

        while (!sources.isEmpty()) {
            int cur = sources.remove(0);
            order.add(cur);

            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegree[next]--;

                    if (indegree[next] == 0) {
                        sources.add(next);
                    }
                }
            }
        }

        return order.size() == n ? order : new ArrayList<>();
    }
}
