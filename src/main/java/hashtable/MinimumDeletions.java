/*
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.



Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).


Constraints:

1 <= s.length <= 105
s contains only lowercase English letters.
 */
package hashtable;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletions {

    public static void main(String[] args) {
        String s = "bbcebab";

        System.out.println(minDeletions(s));
    }

    public static int minDeletions(String s) {
        int res = 0;
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 97] += 1;
        }

        boolean[] valid = new boolean[26];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; ++i) {

            int val = arr[i] ;
            while (set.contains(val) && val > 0) {
                val--;
                res++;
            }
            set.add(val);
        }
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (char c : s.toCharArray()) {
//
//            map.putIfAbsent(c, 0);
//            map.put(c, map.get(c) + 1);
//        }
//
//        Set<Integer> set = new HashSet<>();
//
//        for (Map.Entry<Character, Integer> keyset : map.entrySet()) {
//
//            int val = keyset.getValue();
//            int cnt = 0;
//            while (set.contains(val) && val > 0) {
//                cnt++;
//                val--;
//            }
//            res += cnt;
//            set.add(val);
//        }

        return res;
    }
}
