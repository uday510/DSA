package Patterns;

public class Pattern21 {
    //https://practice.geeksforgeeks.org/problems/square-pattern-1662287714/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=pattern_21
    public static void main(String[] args) {
        int i = 4;
        solve(i);
    }
    public static void solve(int n) {

        int i, j;

        // This is upper half of pattern
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= (2 * n); j++) {

                // Left part of pattern
                if (i < j)
                    System.out.print(" ");
                else
                    System.out.print("*");

                // Right part of pattern
                if (i <= ((2 * n) - j))
                    System.out.print(" ");
                else
                    System.out.print("*");
            }

            System.out.println("");
        }

        // This is lower half of pattern
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= (2 * n); j++) {

                // Left part of pattern
                if (i > (n - j + 1))
                    System.out.print(" ");
                else
                    System.out.print("*");

                // Right part of pattern
                if ((i + n) > j)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }

            System.out.println("");
        }
    }
}
