package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/determine-if-a-cell-is-reachable-at-a-given-time/
public class ReachableAtTime {

    public static void main(String[] args) {
        Edge[] e = new Edge[10];

        Arrays.sort(e, (o1, o2) -> o1.e - o2.e);
    }
    static class Edge {
        int e;
        int v;

        public Edge(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }
    private static final int[][] directions = new int[][] {
            {-1, 0}, // up
            {1, 0}, // down
            {0, -1}, // left
            {0, 1}, // right
            {-1, -1}, // up-left
            {-1, 1}, // up-right
            {1, -1}, // down-left
            {1, 1} // down-right
    };

}
