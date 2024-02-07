package LeetCodeContest;

import Sort.HeapSort.MaxHeap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
    int[] nums = {1, 2, 3, 2, 5};

        System.out.println(solve("a1b2c3d4"));
    }
    public static String solve(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int num = 0;

            int j = i;
           if ( !(c >= 'a' && c <= 'z'))
               System.out.println(c);
        }
        return sb.toString();
    }
}
