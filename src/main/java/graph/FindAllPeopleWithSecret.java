package graph;

import java.util.*;

import static graph.RandomInputGenerator.getRandomNumberInRange;

/**
 * You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.
 *
 * Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
 *
 * The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.
 *
 * Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
 * Output: [0,1,2,3,5]
 * Explanation:
 * At time 0, person 0 shares the secret with person 1.
 * At time 5, person 1 shares the secret with person 2.
 * At time 8, person 2 shares the secret with person 3.
 * At time 10, person 1 shares the secret with person 5.​​​​
 * Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
 * Example 2:
 *
 * Input: n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
 * Output: [0,1,3]
 * Explanation:
 * At time 0, person 0 shares the secret with person 3.
 * At time 2, neither person 1 nor person 2 know the secret.
 * At time 3, person 3 shares the secret with person 0 and person 1.
 * Thus, people 0, 1, and 3 know the secret after all the meetings.
 * Example 3:
 *
 * Input: n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
 * Output: [0,1,2,3,4]
 * Explanation:
 * At time 0, person 0 shares the secret with person 1.
 * At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
 * Note that person 2 can share the secret at the same time as receiving it.
 * At time 2, person 3 shares the secret with person 4.
 * Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.
 *
 */
// https://leetcode.com/problems/find-all-people-with-secret/descriptio
public class FindAllPeopleWithSecret {

    public static void main(String[] args) {
        int n = getRandomNumberInRange(2, 100); // Number of persons
        int maxMeetingTime = (int) (Math.pow(10, 5)); // Maximum meeting time
        int maxStartTime = n - 1; // Maximum start time

        List<int[]> meetings = RandomInputGenerator.generateRandomMeetings(n, maxMeetingTime);
        int firstPerson = getRandomNumberInRange(1, n - 1);

//        System.out.println("Input: n = " + n + ", meetings = " + meetings + ", firstPerson = " + firstPerson);

        int[][] arr = new int[meetings.size()][3];
        for (int i = 0; i < meetings.size(); i++) {
            arr[i] = meetings.get(i);
            System.out.println(Arrays.toString(arr[i]));
        }

        while (true) {

            List<Integer> res1 = findAllPeopleWithSecret(n, arr, firstPerson);
            List<Integer> res2 = new Solution().findAllPeople(n, arr, firstPerson);


            Collections.sort(res1);
            Collections.sort(res2);


            if (!res1.equals(res2)) {
                System.out.println( + n);
                System.out.println(firstPerson);

//                System.out.println("meetings = ");
                for (int[] meeting : arr) {
                    System.out.println(Arrays.toString(meeting));
                }
                break;
            }
            System.out.println("match");

        }
    }


    public static List<Integer> findAllPeopleWithSecret(int n, int[][] meetings, int firstPerson) {

        Arrays.sort(meetings, (a, b) -> a[2] == b[2] ? a[0] - b[0] : a[2] - b[2]);
        List<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(firstPerson);

        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(firstPerson);

        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int time = meeting[2];

            if (set.contains(x) && !set.contains(y)) {
                res.add(y);
                set.add(y);
            } else if (set.contains(y) && !set.contains(x)) {
                res.add(x);
                set.add(x);
            }
        }

        return res;
    }

    static class Solution {
        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            // Sort meetings in increasing order of time
            Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

            // Group Meetings in increasing order of time
            Map<Integer, List<int[]>> sameTimeMeetings = new TreeMap<>();
            for (int[] meeting : meetings) {
                int x = meeting[0], y = meeting[1], t = meeting[2];
                sameTimeMeetings.computeIfAbsent(t, k -> new ArrayList<>()).add(new int[]{x, y});
            }

            // Boolean Array to mark if a person knows the secret or not
            boolean[] knowsSecret = new boolean[n];
            knowsSecret[0] = true;
            knowsSecret[firstPerson] = true;

            // Process in increasing order of time
            for (int t : sameTimeMeetings.keySet()) {
                // For each person, save all the people whom he/she meets at time t
                Map<Integer, List<Integer>> meet = new HashMap<>();
                for (int[] meeting : sameTimeMeetings.get(t)) {
                    int x = meeting[0], y = meeting[1];
                    meet.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                    meet.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
                }

                // Start traversal from those who already know the secret at time t
                // Set to avoid redundancy
                Set<Integer> start = new HashSet<>();
                for (int[] meeting : sameTimeMeetings.get(t)) {
                    int x = meeting[0], y = meeting[1];
                    if (knowsSecret[x]) {
                        start.add(x);
                    }
                    if (knowsSecret[y]) {
                        start.add(y);
                    }
                }

                // Do BFS
                Queue<Integer> q = new LinkedList<>(start);
                while (!q.isEmpty()) {
                    int person = q.poll();
                    for (int nextPerson : meet.getOrDefault(person, new ArrayList<>())) {
                        if (!knowsSecret[nextPerson]) {
                            knowsSecret[nextPerson] = true;
                            q.offer(nextPerson);
                        }
                    }
                }
            }

            // List of people who know the secret
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (knowsSecret[i]) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

}
