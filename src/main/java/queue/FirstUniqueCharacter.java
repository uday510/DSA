/**
 * Problem Description
 * Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
 * B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.
 *
 *
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 *
 *
 * Input Format
 * The only argument given is string A.
 *
 *
 *
 * Output Format
 * Return a string B after processing the stream of lowercase alphabets A.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "abadbc"
 * Input 2:
 *
 *  A = "abcabc"
 *
 *
 * Example Output
 * Output 1:
 *
 * "aabbdd"
 * Output 2:
 *
 * "aaabc#"
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "aba"    -   first non repeating character 'b'
 * "abad"   -   first non repeating character 'b'
 * "abadb"  -   first non repeating character 'd'
 * "abadbc" -   first non repeating character 'd'
 * Explanation 2:
 *
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "abc"    -   first non repeating character 'a'
 * "abca"   -   first non repeating character 'b'
 * "abcab"  -   first non repeating character 'c'
 * "abcabc" -   no non repeating character so '#'
 */

package queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String str = "abadbc";

        String ans = solve(str);
        System.out.println(ans);
    }
    public static String solve(String str) {
        // O(N) time | O(N) space
        Queue <Character> queue = new LinkedList<>();
        //hash map stores the character of each character
        HashMap<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);

            if (hm.get(c) != null) {
                hm.put(c, 2);
            } else {
                // if c is not present then only add to queue
                queue.add(c);
                hm.put(c, 1);
            }
            // remove from queue if the character repeats
            while (!queue.isEmpty() && hm.get(queue.peek()) > 1) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                sb.append(queue.peek());
            } else {
                sb.append('#');
            }
        }
        return sb.toString();
    }
}
