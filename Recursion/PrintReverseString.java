/**
 * Problem Description
 * Write a recursive function that, given a string S, prints the characters of S in reverse order.
 *
 *
 *
 * Problem Constraints
 * 1 <= |s| <= 1000
 *
 *
 *
 * Input Format
 * First line of input contains a string S.
 *
 *
 *
 * Output Format
 * Print the character of the string S in reverse order.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  scaleracademy
 * Input 2:
 *
 *  cool
 *
 *
 * Example Output
 * Output 1:
 *
 *  ymedacarelacs
 * Output 2:
 *
 *  looc
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  Print the reverse of the string in a single line.
 */
package Recursion;

import java.util.Scanner;

public class PrintReverseString {
    public static void main(String[] args) {
//      String string = "ymedacarelacs";

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        solve(string, 0);

    }
    public static void solve(String string, int i) {
        if (i == string.length()) return ;
        solve(string, i + 1);
        System.out.print(string.charAt(i));
    }
}
