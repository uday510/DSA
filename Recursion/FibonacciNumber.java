package Recursion;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(5));
    }
    public static int fib(int n) {
        // O(2 ^ n) time | O(n) space where n is the input number
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
