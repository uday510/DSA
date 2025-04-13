package graph;

import java.util.List;

public class CanVisitAllRooms {

    List<List<Integer>> adjList;
    int[] vis;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        adjList = rooms;
        int n = rooms.size();
        vis = new int[n];

        dfs(0);

        for (int v : vis) if (v == 0) return false;

        return true;
    }

    private void dfs(int node) {
        if (vis[node] == 1) return;

        vis[node] = 1;

        for (int nei : adjList.get(node))  dfs(nei);
    }
}
