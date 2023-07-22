package Recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(0, 5));
    }
    public static int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }
}
