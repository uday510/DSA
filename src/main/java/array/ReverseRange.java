package array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array A of N integers. Also given are two integers B and C.
 * Reverse the array A in the given range [B, C]
 */
public class ReverseRange {
    public static void main(String[] args) {
        ArrayList<Integer> array =  new ArrayList<>(
                Arrays.asList(1, 2, 3, 4));
        int startIdx = 2;
        int endIdx = 3;
        solve(array, startIdx, endIdx);
        array.forEach(System.out::println);
    }
    public static void solve(ArrayList<Integer> A, int B, int C) {
        // O(n) time | O(1) space
        int startIdx = B;
        int endIdx = C;

        while (startIdx < endIdx) {
            swap(startIdx, endIdx, A);
            startIdx++;
            endIdx--;
        }
    }
    public static void swap(int i, int j, ArrayList<Integer> A) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
