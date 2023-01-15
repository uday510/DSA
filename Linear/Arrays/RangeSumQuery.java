import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array A of length N.
 * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
 * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
 * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 */
public class RangeSumQuery {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(List.of(0, 3)));
        B.add(new ArrayList<>(List.of(1, 2)));
        System.out.println(rangeSum(A, B));;
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        // O(n) time | O(n) space
        /**
         * 1. Find Prefix Sum. O(n) time | O(n) space
         * 2. Calculate prefix sum for every query and add in result. O(n) time
         * 3. Return result.
         */
        int[] prefixSum = new int[A.size()];
        ArrayList<Integer> result = new ArrayList<>();

        prefixSum[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + A.get(i);
        }

        System.out.println(Arrays.toString(prefixSum));

        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> query = B.get(i);
            System.out.println(query);
            int startIdx = query.get(0);
            int endIdx = query.get(1);
            if (startIdx == 0) result.add(prefixSum[endIdx]); // To get rid of ArrayIndexOutOfBound.
            else result.add(prefixSum[endIdx] - prefixSum[startIdx - 1]);
       }
        return result;
    }

    public static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        long[] prefixSum = new long[A.size()];
        ArrayList<Long>result = new ArrayList<>();

        prefixSum[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + A.get(i);
        }

        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> query = B.get(i);
            int startIdx = query.get(0);
            int endIdx = query.get(1);
            if (startIdx == 0) result.add(prefixSum[endIdx]);
            else result.add((prefixSum[endIdx] - prefixSum[startIdx - 1]));
        }
        return result;
    }
//    public static void solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
//        ArrayList<Integer> nums = new ArrayList<>();
//        ArrayList<Integer> firstList = B.get(0);
//        ArrayList<Integer> secondList = B.get(1);
//
//        int firstIdx = firstList.get(0) - 1;
//        int secondIdx = firstList.get(1) - 1;
//        System.out.println(firstIdx);
//        System.out.println(secondIdx);
//
//        int sum = 0;
//        for (int i = firstIdx; i <= secondIdx; i++) {
//                sum += A.get(i);
//        }
//        nums.add(sum);
//        System.out.println(nums);
//        firstIdx = secondList.get(0) - 1;
//        secondIdx = secondList.get(1) - 1;
//        sum = 0;
//        for (int i = firstIdx; i <= secondIdx; i++) {
//            sum += A.get(i);
//        }
//        nums.add(sum);
//        System.out.println(nums);
//    }
}