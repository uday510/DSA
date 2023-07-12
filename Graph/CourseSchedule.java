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
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{0,1}};
        int numCourses = 2;
        System.out.println(canFinish(numCourses, prerequisites));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // O(V+E) time complexity | O(V+E) space complexity
        int[] indegree = new int[numCourses]; // indegree of each node
        List<List<Integer>> adj = new ArrayList<>(numCourses); // adjacency list

        for (int i = 0; i < numCourses; ++i) {
            adj.add(new ArrayList<>()); // initialize adjacency list
        }

        for (int[] prerequisite : prerequisites) {
          adj.get(prerequisite[1]).add(prerequisite[0]); // add edge to adjacency list
            ++indegree[prerequisite[0]]; // increment indegree of the node
        }

        Queue<Integer> queue = new LinkedList<>();
        // Push all nodes with indegree 0 to queue
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int nodesVisited = 0; // count of nodes visited
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            ++nodesVisited;
            for (int neighbour : adj.get(currNode)) {
                --indegree[neighbour]; // decrement indegree of neighbour
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour); // add neighbour to queue if indegree is 0
                }
            }
        }
        return nodesVisited == numCourses; // return true if all nodes are visited
    }
}
