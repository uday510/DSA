package Recursion;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello";
//        reverse(str, 0);
//        reverseWord(str);
    }
    public static void reverse(String str, int index) {
        if (str == null || index >= str.length()) {
            return;
        }
        reverse(str, index + 1);
        System.out.print(str.charAt(index) + " ");
    }
    public static void reverseWord(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
