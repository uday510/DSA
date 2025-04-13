package graph;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededToInformAllEmployees {

    List<Integer>[] adjList;
    int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        adjList = new ArrayList[n];
        this.informTime = informTime;

        for (int i = 0; i < n; ++i) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            if (manager[i] != -1) {
                adjList[manager[i]].add(i);
            }
        }

        return dfs(headID);
    }

    private int dfs(int node) {
        int maxTime = 0;

        for (int nei : adjList[node]) {
            maxTime = Math.max(maxTime, dfs(nei));
        }

        return maxTime + informTime[node];
    }

}
