/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


 */
package twopointer;

public class FindTheIndexOfFirstOccurenceInString {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(findTheIndexOfFirstOccurenceInString(haystack, needle));
    }
    public static int findTheIndexOfFirstOccurenceInString(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int index = -1;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (index == -1) {
                    index = i;
                }
                i++;
                j++;
            } else {
                i++;
                j = 0;
                index = -1;
            }
        }
        if (j == needle.length()) {
            return index;
        }
        return -1;
    }
}
