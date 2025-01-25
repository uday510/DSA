package string;

import java.util.Stack;

public class Solution {
    public int solution(int[] R) {
        Stack<Pair> stack = new Stack<>();
        int maxIndicator = 0;

        for (int depth : R) {
            if (depth == 0) {
                while (!stack.isEmpty()) {
                    Pair top = stack.pop();
                    maxIndicator = Math.max(maxIndicator, top.depth * top.count);
                    if (top.depth == 0) {
                        break;
                    }
                }
                stack.push(new Pair(0, 0));
            } else {
                int count = 1;
                while (!stack.isEmpty() && stack.peek().depth >= depth) {
                    count += stack.pop().count;
                }
                stack.push(new Pair(depth, count));
            }
        }

        while (!stack.isEmpty()) {
            Pair top = stack.pop();
            maxIndicator = Math.max(maxIndicator, top.depth * top.count);
        }

        return maxIndicator;
    }

    class Pair {
        int depth;
        int count;

        public Pair(int depth, int count) {
            this.depth = depth;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{0, 2, 1, 1, 0, 4, 1}));  // Output: 8
        System.out.println(solution.solution(new int[]{1, 4, 1, 0, 5, 2, 3, 0, 8}));  // Output: 15
        System.out.println(solution.solution(new int[]{9, 8, 7, 0, 0, 0, 2, 3, 6, 4}));  // Output: 27
        System.out.println(solution.solution(new int[]{19, 8, 7, 0, 0, 0, 2, 3, 6, 4}));  // Output: 27
        System.out.println(solution.solution(new int[]{0, 0, 0}));  // Output: 0
    }
}
