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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int numCourses = 4;
        int[] result = findOrder(numCourses, prerequisites);
        for (int j : result) {
            System.out.print(STR."\{j} ");
        }
    }

    @SuppressWarnings("unchecked")
    // O(V+E) time complexity | O(V+E) space complexity
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] inDegree = new int[numCourses];
        List<Integer>[] adjList = new ArrayList[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
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
            order[index++] = course;
            finishedCourses++;

            for (int neighborCourse : adjList[course]) {
                if (--inDegree[neighborCourse] == 0) {
                    queue.add(neighborCourse);
                }
            }
        }

        return finishedCourses == numCourses ? order : new int[]{};
    }
}
