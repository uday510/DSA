package google;

import java.util.*;

public class Main {

    static void main(String[] args) {

        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {4, 5}};
        int n = 5;

        solve(edges, n);
    }


    private static void solve(int[][] edges, int n) {

        List<Integer>[] adj = new ArrayList[n + 1];
        List<Integer>[] radj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            radj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            radj[v].add(u);
        }

        List<Integer> topo = getTopo(edges, adj, n);
        if (topo.size() < n) {
            return;
        }

        System.out.println(topo);

        int[] down = new int[n + 1];
        for (int i = topo.size() - 1; i > -1; i--) {
            int u = topo.get(i);
            for (int v : adj[u]) {
                down[u] = Math.max(down[u], 1 + down[v]);
            }
        }

        int[] up = new int[n + 1];
        for (int u : topo) {
            for (int v : radj[u]) {
                up[u] = Math.max(up[u], 1 + up[v]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(up[i] + down[i] + 1);
        }

        System.out.println(res);

    }

    private static List<Integer> getTopo(int[][] edges,
                                         List<Integer>[] adj,
                                         int n) {

        List<Integer> topo = new ArrayList<>();
        int[] indegree = new int[n + 1];

        for (int[] edge : edges) {
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);

            for (int v : adj[u]) {
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }

            }
        }

        return topo;
    }
}

/**
 * you are given maximum initial energy k (in hundreds) and n Len array A denoting wind speed on n days, he is stuck on a boat ,
 * each day he decides to travel he will move ahead A[i] Dist and his energy decreases by 1 and if he decides to stay put his energy increases by 1.
 * What is the maximum distance he can travel without dropping his energy to negative after n days.
 */


/**
 *
 * Imagine you are a playing a game for two players. You are given a sequence of numbers for this game.
 * On each turn, every player can decide to pick either one or two values from the front of this sequence.
 * Each value which a player picks is added to the overall score of the respective player.
 *
 * The endscore for both players is computed by the following formula: score of player - score of other player
 *
 * Your task is to compute the max score of the first player, assuming the first player starts picking.
 */


/**
 *
 *
 * Imagine you are responsible for leading a car rental company. You are given a collection of reservation times with the following structure:
 *
 * struct reservation{
 * 	int id;
 * 	int pickup_time;
 * 	int return_time;
 * }
 *
 * Your task is to assing as less cars as possible to the collection of reservations.
 * Furthermore, you are tasked with returning the set of time intervals each respective car was used.
 *
 * Example Input:
 * Reservations: [[1,4],[2,5],[3,7],[6,9]]
 *
 * Example Output:
 * car1 -> [{1,4},{6,9}]
 * car2 -> [{2,5}]
 * car3 -> [{3,7}]
 */

/**
 *
 * You're given a list of elements. Each element has a unique id and 3 properties.
 * Two elements are considered as duplicates if they share any
 * of the 3 properties. Please write a function that takes the input and returns all the duplicates.
 *
 * Example Input:
 * E1: id1, p1, p2, p3
 * E2: id2, p1, p4, p5
 * E3: id3, p6, p7, p8
 *
 * Example Output: {{id1, id2}, {id3}}
 */

/**
 * Given a hotel which has 10 floors [0-9] and each floor has 26 rooms [A-Z]. You are given a sequence of rooms, where + suggests room is booked, - room is freed. You have to find which room is booked maximum number of times.
 * You may assume that the list describe a correct sequence of bookings in chronological order; that is, only free rooms can be booked and only booked rooms can be freeed. All rooms are initially free. Note that this does not mean that all rooms have to be free at the end. In case, 2 rooms have been booked the same number of times, return the lexographically smaller room.
 *
 * You may assume:
 *
 *
 * N (length of input) is an integer within the range [1, 600]
 * each element of array A is a string consisting of three characters: "+" or "-"; a digit "0"-"9"; and uppercase English letter "A" - "Z"
 * the sequence is correct. That is every booked room was previously free and every freed room was previously booked.
 * Example:
 *
 *
 * Input: ["+1A", "+3E", "-1A", "+4F", "+1A", "-3E"]
 * Output: "1A"
 */