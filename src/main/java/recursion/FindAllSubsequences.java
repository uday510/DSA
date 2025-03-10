package recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsequences {
    static int longest;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int result = lenLongestFibSubseq(arr);
        System.out.println(result);
    }

    public static int lenLongestFibSubseq(int[] arr) {
        longest = 0;
        dfs(arr, 0, new ArrayList<>());

        return longest;
    }

    private static void dfs(int[] arr, int index, List<Integer> list) {
        if (index >= arr.length) {
            findFibonacciSequence(list);
            return;
        }

        list.add(arr[index]);
        dfs(arr, index + 1, list);
        list.removeLast();
        dfs(arr, index + 1, list);
    }

    private static void findFibonacciSequence(List<Integer> arr) {
        if (arr.size() < 3) return;

        for (int idx = 2; idx < arr.size(); ++idx) {
            int curr = arr.get(idx - 1) + arr.get(idx - 2);
            if (curr != arr.get(idx)) return;
        }

        longest = Math.max(longest, arr.size());
    }
}
