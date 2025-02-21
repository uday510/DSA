package graph;

import java.util.*;


/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi]
 * and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.
 *
 *
 *
 * Example 1:
 *
 *
 * a --> b --> c
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * note: x is undefined => -1.0
 * Example 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 * Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20
 * equations[i].length == 2
 * 1 <= Ai.length, Bi.length <= 5
 * values.length == equations.length
 * 0.0 < values[i] <= 20.0
 * 1 <= queries.length <= 20
 * queries[i].length == 2
 * 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 */
public class CalcEquation {
    public static void main(String[] args) {
    }

    private static Map<String, List<String[]>> graph;
    private static Set<String> visited;
    private static double[] result;
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        buildGraph(equations, values, queries);

        for (int idx = 0; idx < queries.size(); ++idx) {
            List<String> query = queries.get(idx);
            String src = query.get(0);
            String dest = query.get(1);

           double cost = dfs(src, dest);
           result[idx] = cost;
        }

        return result;
    }
    private static double dfs(String src, String dest) {
        if (!graph.containsKey(src) || !graph.containsKey(dest)) {
            return -1.0;
        }

        if (src.equals(dest)) {
            return 1.0;
        }

        double cost = 0;
        for (var neighbor : graph.get(dest)) {
            String next = neighbor[0];
            if (!visited.add(next)) {
                continue;
            }
            double dist = Double.parseDouble(neighbor[1]);
            double value = dfs(next, dest);

            if (dist != -1) {
                return dist * value;
            }
        }

        return -1;
    }

    private static void buildGraph(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        result = new double[queries.size()];

        for (int idx = 0; idx < equations.size(); ++idx) {
            List<String> equation = equations.get(idx);
            String src = equation.get(0);
            String dest = equation.get(1);
            double dist = values[idx];

            graph.computeIfAbsent(src, k -> new ArrayList<>()).add(new String[]{dest, String.valueOf(dist)});
            graph.computeIfAbsent(dest, k -> new ArrayList<>()).add(new String[]{src, String.valueOf(1.0/dist)});
        }
    }
}
