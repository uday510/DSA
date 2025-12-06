import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 *
 * You are given n courses labeled from 1 to n and a list of prerequisite relations between them.
 * Each course also takes a certain number of months to complete.
 * You’re allowed to:
 * Start any course at any time, provided its prerequisites are completed.
 * Take multiple courses concurrently (no concurrency limits).
 * Return the minimum number of months required to complete all courses.
 *
 *

 n = 3
 relations = [[1, 3], [2, 3]]
 time = [3, 2, 5]

 1 -> 3
 2 -> 3

 3 + 5

 3 -> 0

 indegree: [1: 0, 2: 0, 3: 0]

 minMonths: 3 + 5

 queue: []

 n = 7
 relations = [
 [1,3], [2,3],
 [3,4], [3,5],
 [4,6], [5,6],
 [6,7]
 ]

 time = [2, 3, 4, 6, 5, 8, 7]

2:  1 -> [3]
3:  2 -> [3]
4: 3 -> [4, 5]
6: 4 -> [6]
5:5 -> [6]
8: 6 -> [7]
7: 7 -> []

 indegree: 1: 0, 2: 0, 3 : 0, 4: 0, 5: 0, 6: 0, 7: 0

 queue: 7

 ans = 3 + 4 + 6 + 8 + 7 = 28

 */


public class Main {

    static void main() {

        int[][] prerequisites = new int[][]{{1, 3}, {2, 3}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {6, 7}};
        int[] months = new int[] {2, 3, 4, 6, 5, 8, 7};

        int minimumMoths = minimumNumberOfMonths(prerequisites, months);

        System.out.println("minimumMoths : " + minimumMoths);

    }

    private static int minimumNumberOfMonths(int[][] prerequisites, int[] months) {
        int n = months.length;
        List<Integer>[] adjList = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        int minMonths = 0;

        for (int i = 1; i <= n; i++) adjList[i] = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0], v = prerequisite[1];
            adjList[u].add(v);
            ++indegree[v];
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            int maxMonth = -1;

            for (int i = 0; i < size; i++) {
                assert !queue.isEmpty();
                int u = queue.poll();
                maxMonth = Math.max(months[u - 1], maxMonth);

                for (int v : adjList[u]) {
                    if (--indegree[v] == 0) {
                        queue.offer(v);
                    }
                }
            }

            minMonths += maxMonth == -1 ? 0 : maxMonth;
        }


        return minMonths;
    }
}


