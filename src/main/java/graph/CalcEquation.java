package graph;

import java.util.*;


/**
 * You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
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
    static Map<String, List<String>> graph;
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();

        buildGraph(equations, values);

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String a = query.get(0);
            String b = query.get(1);
            res[i] = dfs(a, b, new HashSet<>());
        }
        return res;
    }
    private static double dfs(String a, String b, Set<String> visited) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return -1;
        }
        if (a.equals(b)) {
            return 1;
        }
        visited.add(a);
        List<String> neighbors = graph.get(a);
        for (int i = 0; i < neighbors.size(); i += 2) {
            String neighbor = neighbors.get(i);
            if (visited.contains(neighbor)) {
                continue;
            }
            double val = Double.parseDouble(neighbors.get(i + 1));
            double res = dfs(neighbor, b, visited);
            if (res != -1) {
                return val * res;
            }
        }
        return -1;
    }
    private static void buildGraph(List<List<String>> eqs, double[] vs) {
        for (int i = 0; i < eqs.size(); i++) {
            List<String> eq = eqs.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            double v = vs[i];

           graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
           graph.get(a).add(String.valueOf(v));

           graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
           graph.get(b).add(String.valueOf(1 / v));
        }
    }
}
