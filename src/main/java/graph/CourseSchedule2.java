/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 */

package graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses = 4;
        int[] result = findOrder(numCourses, prerequisites);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Kahn's algorithm for topological sort
        // Time complexity: O(V + E) | Space complexity: O(V + E)
        int[] result = new int[numCourses]; // result array
        int[] indegree = new int[numCourses]; // indegree array
        int index = -1; // index for result array

        List<List<Integer>> graph = new ArrayList<>(); // graph

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) { // build graph and indegree array
            int from = p[1];
            int to = p[0];
            graph.get(from).add(to); // add to graph
            ++indegree[to]; // increment indegree
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) { // add all nodes with indegree 0 to queue
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int currNode = queue.poll();

            result[++index] = currNode; // add to result array

            for (int edge : graph.get(currNode)) {
                --indegree[edge]; // decrement indegree

                if (indegree[edge] == 0) { // if indegree is 0 add to queue
                    queue.add(edge);
                }
            }
        }

        // if all nodes are not visited return empty array, because cycle found
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] != 0) {
                return new int[0];
            }
        }
        return result;
    }
}
