/**
 * Problem Description
 * Given an integer A, you have to find the Ath Perfect Number.
 *
 * A Perfect Number has the following properties:
 *
 * It comprises only 1 and 2.
 * The number of digits in a Perfect number is even.
 * It is a palindrome number.
 * For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 *
 *
 *
 * Problem Constraints
 * 1 <= A <= 100000
 *
 *
 *
 * Input Format
 * The only argument given is an integer A.
 *
 *
 *
 * Output Format
 * Return a string that denotes the Ath Perfect Number.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = 2
 * Input 2:
 *
 *  A = 3
 *
 *
 * Example Output
 * Output 1:
 *
 *  22
 * Output 2:
 *
 *  1111
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Return the 2nd Perfect number.
 * Explanation 2:
 *
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Return the 3rd Perfect number.
 */
package queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {
    public static void main(String[] args) {
        int a = 4;

        String ans = solve(a);
        System.out.println(ans);
    }
    public static String solve(int a) {
        // O(a) time | O(a) space
        if (a == 1) {
            return "11";
        } else if (a == 2) {
            return "22";
        }
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        int currIdx = 2;
        String ans;
        StringBuilder sb;
        while (true) {
            sb = new StringBuilder(queue.peek());
            queue.remove(); // remove first from queue
            sb.append("1"); // add 1 to it.
            queue.add(sb.toString()); // add to queue
            currIdx++;
            if (currIdx == a) {
                ans = sb.toString();
                break;
            }
            sb.deleteCharAt(sb.length() - 1); // remove last char append "b"
            sb.append("2");
            currIdx++;
            if (currIdx == a) {
                ans = sb.toString();
                break;
            }
            queue.add(sb.toString());
        }

        // ans has the first half of our final answer
        sb = new StringBuilder(ans);
        return ans + sb.reverse();

    }
}
