package graph;
import java.util.*;

public class ParallelCourses {
    public static void main(String[] args) {
        int n  = 3;
        int[][] relations = { {1,2}, {2,3}, {3,1} };
    }
    public static int minimumSemesters(int n, int[][] relations) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n + 1];

        for (int i = 1; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : relations) {
            int from = r[0];
            int to = r[1];
            graph.get(from).add(to);
            indegree[to]++;
        }

        List<Integer> queue = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            if (indegree[i] == 0) queue.add(i);
        }

        int coursesStudied = 0;
        int step = 0;


        while (!queue.isEmpty()) {
            ++step;

            List<Integer> newQueue = new ArrayList<>();
            for (int node : queue) {
                coursesStudied++;
                for (int adj : graph.get(node)) {
                    --indegree[adj];
                    if (indegree[adj] == 0) newQueue.add(adj);
                }
            }
            queue = newQueue;
        }

        return step == n ? coursesStudied : -1;
    }
}
