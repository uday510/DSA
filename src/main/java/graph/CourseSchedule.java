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

    @SuppressWarnings("unchecked")
    // O(V+E) time complexity | O(V+E) space complexity
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
       ArrayDeque<Integer> queue = new ArrayDeque<>();
       int[] inDegree = new int[numCourses];
       List<Integer>[] adjList = new ArrayList[numCourses];
       int finishedCourses = 0;

       for (int idx = 0; idx < numCourses; idx++) {
           adjList[idx] = new ArrayList<>();
       }

       for (int[] prerequisite : prerequisites) {
           adjList[prerequisite[1]].add(prerequisite[0]);
           inDegree[prerequisite[0]]++;
       }

       for (int idx = 0; idx < numCourses; ++idx) {
           if (inDegree[idx] == 0) {
               queue.offerLast(idx);
           }
       }

       while (!queue.isEmpty()) {
           int course = queue.pollFirst();
           finishedCourses++;

           for (int neighborCourse : adjList[course]) {
                if (--inDegree[neighborCourse] == 0) {
                     queue.add(neighborCourse);
                }
           }
       }

       return finishedCourses == numCourses;
    }
}
