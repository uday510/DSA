package backtracking;

import java.util.*;

public class PermutationSequence {
    static int count = 0;
    static String res = "";
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
    public static String getPermutation(int n, int k) {

        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            nums.add(i);
        }

        backtrack(nums, new ArrayDeque<>(), n, k);
        return res;
    }
    public static boolean backtrack(List<Integer> nums, Deque<Integer> temp, int n, int k) {
        if(temp.size() == n) {
            ++count;
            if(count == k) {
                StringBuilder sb = new StringBuilder();
                for (Integer integer : temp) {
                    sb.append(integer);
                }
                res = sb.toString();
                return true;
            }
        }

        for(int i = 0; i < nums.size(); i++) {
            if(temp.contains(nums.get(i))) {
                continue;
            }
            temp.add(nums.get(i));
            if (backtrack(nums, temp, n, k)) {
                return true;
            }
            temp.pollLast();
        }
        return false;
    }
}
