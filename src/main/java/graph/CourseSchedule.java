/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
package graph;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,2},{2,3}};
        int numCourses = 3;
        System.out.println(canFinish(numCourses, prerequisites));
    }
    static private Map<Integer, List<Integer>> graph;
    static private Queue<Integer> queue;
    static private int[] indegree;
    static int visited = 0;
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // O(V+E) time complexity | O(V+E) space complexity

        initialize(numCourses);
        buildGraph(prerequisites);
        addNodesWithNoPreRequisites();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            removeNodeFromGraph(node);
        }

        return visited == numCourses;
    }
    private static void removeNodeFromGraph(int node) {
        visited++;
        for (int neighbour : graph.getOrDefault(node, new ArrayList<>())) {
           indegree[neighbour]--;
           if (indegree[neighbour] == 0) {
               queue.offer(neighbour);
           }
        }
    }
    private static void addNodesWithNoPreRequisites() {
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
    }
    private static void buildGraph(int[][] prerequisites) {
        for (int[] prerequisite : prerequisites) {
            graph.computeIfAbsent(prerequisite[1], x -> new ArrayList<>()).add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
    }
    private static void initialize(int numCourses) {
        graph = new HashMap<>();
        queue = new LinkedList<>();
        indegree = new int[numCourses];
    }
}
