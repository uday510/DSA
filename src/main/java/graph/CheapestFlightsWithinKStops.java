/**
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 *
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */
package graph;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // O(k * m) time complexity, where m is the number of flights
        // Bellman Ford Algorithm
        if (src == dst) return 0;

        int[] previous = new int[n]; // previous[i] is the minimum cost from src to i with at most k stops
        int[] current = new int[n]; // current[i] is the minimum cost from src to i with at most k + 1 stops

        for (int i = 0; i < n; ++i) { // initialize
            previous[i] = current[i] = Integer.MAX_VALUE;
        }

        previous[src] = 0; // initialize the cost from src to src is 0

        // for k = 1, we have 2 edges at most, so i < k + 2
        for (int i = 1; i < k + 2; ++i) {
            current[src] = 0;
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];

                if (previous[from] != Integer.MAX_VALUE) { // if we can reach from src
                    current[to] = Math.min(current[to], previous[from] + price);
                }
            }
            // copy current to previous
            previous = current.clone();
        }
        return current[dst] == Integer.MAX_VALUE ? -1 : current[dst]; // if we can't reach dst, return -1
    }
}

/**
 * Input:
 * 	n = 4,
 * 	flights = [
 * 				[0, 1, 100],
 * 				[1, 2, 100],
 * 				[2, 0, 100],
 * 				[1, 3, 600],
 * 				[2, 3, 200]
 * 				],
 * 	src = 0,
 * 	dst = 3,
 * 	k = 1
 *
 *
 * Output: 700
 *
 *
 *
 *
 * => from src to dest there are 2 stops (i.e src and dest)
 * => we can reach from src to dest with at most 1 stop
 *
 *
 * Bellman Ford Algorithm
 *
 *  1. Initialize the minimum cost from src to i with at most k stops
 *  2. For k = 1, we have 2 edges at most, so i < k + 2
 *  3. current[i] is the minimum cost from src to i with at most k + 1 stops
 *
 *  initialize previous and current array with Integer.MAX_VALUE
 *  previous[src] = 0
 *  current[src] = 0
 *
 *  for k = 1, we have 2 edges at most, so i < k + 2
 *
 * current = [Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
 * previous = [Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
 *
 *  previous[src] = 0 because we can reach from src to src with 0 cost
 *
 *
 * i = 1
 *        -->
 *          before  : previous = [0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
 *                  current = [Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
 *
 *          after   : previous = [0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
 *          current = [0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
 *
 * i = 2
 *         before  : previous = [0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
 *         current = [0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
 *
 *         after   : previous = [0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
 *         current = [0, 100, 100, Integer.MAX_VALUE]
 *
 *
 * i = 3
 *
 *        before  : previous = [0, 100, 100, Integer.MAX_VALUE]
 *        current = [0, 100, 100, Integer.MAX_VALUE]
 *
 *        after   : previous = [0, 100, 100, Integer.MAX_VALUE]
 *        current = [0, 100, 100, 600]
 *
 *
 *
 *
 *
 *
 *
 */
