/**
 * Dijkstra's Algorithm
 *
 * You're given an integer start and a list edges of pairs of integers.
 *
 * The list is what's called an adjacency list, and it represents a graph. The number of vertices in the graph is equal to the length of edges, where each index i in edges contains vertex i's outbound edges, in no particular order. Each individual edge is represented by an pair of two numbers, [destination, distance], where the destination is a positive integer denoting the destination vertex and the distance is a positive integer representing the length of the edge (the distance from vertex i to vertex destination). Note that these edges are directed, meaning that you can only travel from a particular vertex to its destination—not the other way around (unless the destination vertex itself has an outbound edge to the original vertex).
 *
 * Write a function that computes the lengths of the shortest paths between start and all of the other vertices in the graph using Dijkstra's algorithm and returns them in an array. Each index i in the output array should represent the length of the shortest path between start and vertex i. If no path is found from start to vertex i, then output[i] should be -1.
 *
 * Note that the graph represented by edges won't contain any self-loops (vertices that have an outbound edge to themselves) and will only have positively weighted edges (i.e., no negative distances).
 *
 * If you're unfamiliar with Dijkstra's algorithm, we recommend watching the Conceptual Overview section of this question's video explanation before starting to code.
 * Sample Input
 *
 * start = 0
 * edges = [
 *   [[1, 7]],
 *   [[2, 6], [3, 20], [4, 3]],
 *   [[3, 14]],
 *   [[4, 2]],
 *   [],
 *   [],
 * ]
 *
 * Sample Output
 *
 * [0, 7, 13, 27, 10, -1]
 */
package graph.dijkstra;

import java.util.Arrays;
import java.util.Set;

public class DijkstraUsingArray {
    public static void main(String[] args) {
        int start = 0;
        int[][][] edges = {
            {{1, 7}},
            {{2, 6}, {3, 20}, {4, 3}},
            {{3, 14}},
            {{4, 2}},
            {},
            {}
        };
        int[] result = dijkstrasAlgorithmUsingArray(start, edges);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    public static int[] dijkstrasAlgorithmUsingArray(int start, int[][][] edges) {
        // O(v^2 + e) time | O(v) space where v is the number of vertices and e is the number of edges
        int numberOfVertices = edges.length; // number of vertices

        int[] minDistances = new int[numberOfVertices]; // min distance from start to each vertex
        Arrays.fill(minDistances, Integer.MAX_VALUE); // initialize minDistances to infinity
        minDistances[start] = 0;// distance from start to start is 0

        Set<Integer> visited = new java.util.HashSet<>(); // visited vertices

        while (visited.size() != numberOfVertices) {
            int[] getVertexData = getVertexWithMinDistance(minDistances, visited);
            int currentVertex = getVertexData[0];
            int currentMinDistance = getVertexData[1];

            if (currentMinDistance == Integer.MAX_VALUE) { // if current min distance is infinity
                break; // break
            }

            visited.add(currentVertex); // add current vertex to visited

            for (int[] edge : edges[currentVertex]) {
                int destination = edge[0];
                int distanceToDestination = edge[1];

                if (visited.contains(destination)) { // if destination is visited, continue
                    continue;
                }

                int newPathDistance = currentMinDistance + distanceToDestination; // new path distance
                int currentDestinationDistance = minDistances[destination]; // current distance from start to destination
                if (newPathDistance < currentDestinationDistance) {
                    minDistances[destination] = newPathDistance;
                }
            }
        }

        int[] finalDistance = new int[minDistances.length];
        for (int i = 0; i < minDistances.length; ++i) {
            int distance = minDistances[i];
            if (distance == Integer.MAX_VALUE) {
                finalDistance[i] = -1;
            } else {
                finalDistance[i] = distance;
            }
        }

        return finalDistance;
    }
    public static int[] getVertexWithMinDistance(int[] distances, Set<Integer> visited) {
        int minDistance = Integer.MAX_VALUE; // min distance from start to vertex
        int vertex = -1; // vertex with min distance

        for (int vertexIdx = 0; vertexIdx < distances.length; ++vertexIdx) { // for each vertex
            int currentDistance = distances[vertexIdx]; // get distance from start to vertex

            if (visited.contains(vertexIdx)) { // if vertex is visited, continue
                continue;
            }

            if (currentDistance <= minDistance) { // if current distance is less than min distance
                vertex = vertexIdx; // update vertex
                minDistance = currentDistance;  // update min distance
            }
        }

        return new int[] {vertex, minDistance}; // return vertex and min distance
    }

}
