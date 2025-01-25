/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""


Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
 */

package string;

import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {

        String s = "aaab";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        int[] map = new int[26];

        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<> ( (a, b) -> b.count - a.count);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; ++i) {
            if (map[i] > 0) {
                pq.offer(new Pair((char) (i + 'a'), map[i]));
            }
        }

        while (!pq.isEmpty()) {

            Pair first = pq.poll();

            if (sb.isEmpty() || first.c != sb.charAt(sb.length() - 1)) {
                sb.append(first.c);
                if (--first.count > 0) {
                    pq.offer(first);
                }
            } else {
                Pair second = pq.poll();

                if (second == null) return "";

                sb.append(second.c);

                if (--second.count > 0) {
                    pq.offer(second);
                }
                pq.offer(first);
            }
        }

        return sb.toString();
    }
    static class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
//    public static String reorganizeString(String s) {
//
//        /*
//        Generate all the permutations of the string and check if any of them is valid.
//        if valid return the string else return ""
//         */
//        List<String> perms = new ArrayList<>();
//
//        generatePermutations(s, 0, s.length(), perms);
//
//        for (String perm : perms) {
//            if (isValid(perm)) {
//                return perm;
//            }
//        }
//        return "";
//    }
//    public static void generatePermutations(String s, int idx, int N, List<String> perms) {
//
//        if (idx == N) {
//            perms.add(s);
//            return;
//        }
//
//        for (int i = idx; i < N; ++i) {
//
//            s = swap(s, idx, i);
//            generatePermutations(s, idx + 1, N, perms);
//            s = swap(s, idx, i);
//        }
//    }
//    public static String swap(String s, int i, int j) {
//
//        char[] chars = s.toCharArray();
//
//        char temp = chars[i];
//        chars[i] = chars[j];
//        chars[j] = temp;
//
//        return String.valueOf(chars);
//    }
//    public static boolean isValid(String s) {
//
//        for (int i = 1; i < s.length(); ++i) {
//            if (s.charAt(i) == s.charAt(i - 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
