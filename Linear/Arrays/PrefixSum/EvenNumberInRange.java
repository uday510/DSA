import java.util.ArrayList;
import java.util.Arrays;

public class EvenNumberInRange {
    /**
     * You are given an array A of length N and Q queries given by the 2D array B of size Q*2. Each query consists of two integers B[i][0] and B[i][1].
     * For every query, the task is to find the count of even numbers in the range A[B[i][0]…B[i][1]].
     *
     * INPUT:
     * A = [1, 2, 3, 4, 5]
     * B = [   [0,2]
     *         [1,4]   ]
     *
     * OUTPUT: [1, 2]
     *
     * EXPLANATION:
     * The subarray for the first query is [1, 2, 3] which contains 1 even number.
     * The subarray for the second query is [2, 3, 4, 5] which contains 2 even numbers.
     */
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 8, 3, 9));
        ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
        queries.add(new ArrayList<>(Arrays.asList(0, 3)));
        queries.add(new ArrayList<>(Arrays.asList(2, 4)));
        System.out.println(solve(A, queries));
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> array, ArrayList<ArrayList<Integer>> B) {

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> evenPrefixSum = new ArrayList<>();

        /**
         * 1. EvenPrefixSum
         * 2. Check for condition.
         */
        evenPrefixSum.add(0);
        if (array.get(0) % 2 == 0) evenPrefixSum.set(0, evenPrefixSum.get(0) + 1);

        for (int i = 1; i < array.size(); i++) {
            evenPrefixSum.add(i, evenPrefixSum.get(i - 1));
            int num = array.get(i);
            if (num % 2 == 0) evenPrefixSum.set(i, evenPrefixSum.get(i - 1) + 1);
        }

        for (ArrayList<Integer> query : B) {
            int startIdx = query.get(0);
            int endIdx = query.get(1);
            if (startIdx == 0) result.add(evenPrefixSum.get(endIdx));
            else result.add(evenPrefixSum.get(endIdx) - evenPrefixSum.get(startIdx - 1));
        }
       return result;
    }
}
