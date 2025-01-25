package string;

import java.util.Stack;

public class SmallestSubsequence {

    public static void main(String[] args) {
        String str = "cbacdcbc";

        String res = smallestSubsequence(str);

        System.out.println(res);
    }

    public static String smallestSubsequence(String s) {

        Stack<Character> stack = new Stack<>();

        int[] lastOccurace = new int[26];
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            lastOccurace[c -'a'] = i;
        }

        for (int i = 0;i < n; ++i) {

            char c = s.charAt(i);

            if (stack.contains(c)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && lastOccurace[stack.peek() -'a'] > i) {
                 stack.pop();
            }

            stack.push(c);

        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
