/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
package backtracking;

import java.util.ArrayList;
import java.util.HashMap;

public class Permutations2 {
    public static void main(String[] args) {
//        char[] nums = {'a', 'a', 'b'};

          int[] nums = {1, 1, 2};

        ArrayList<ArrayList<Integer>> res = solve(nums);
        System.out.println(res);
    }
    public static ArrayList<ArrayList<Integer>> solve(int[] nums) {
        // O(N!) time | O(N) space
        HashMap<Integer, Integer> hm = new HashMap();

        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        int[] perm = new int[nums.length];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();


        getPermutations(0, hm, perm, list);

        return list;
    }
    public static void getPermutations(int idx, HashMap<Integer, Integer> hm, int[] perm, ArrayList<ArrayList<Integer>> perms) {

        if (idx == perm.length) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int num : perm) temp.add(num);
            perms.add(temp);
            return;
        }

        for (int i = 0; i <= 10; ++i) {
            if (hm.containsKey(i) && hm.get(i) > 0) {
                hm.put(i, hm.get(i) - 1);
                perm[idx] = i;
                getPermutations(idx+1, hm, perm, perms);
                hm.put(i, hm.get(i) + 1);
            }
        }
    }

//    public static ArrayList<ArrayList<Character>> solve(char[] nums) {
//
//        int[] freqArray = new int[26];
//
//        ArrayList<ArrayList<Character>> perms = new ArrayList<>();
//        char[] perm = new char[nums.length];
//
//        for (int i = 0; i < nums.length; ++i) {
//            int val = nums[i];
//            freqArray[val - 'a'] += 1;
//        }
//
//        getPermutations(freqArray, 0, perm, perms);
//
//        return perms;
//    }
//    public static void getPermutations(int[] freqArray, int idx, char[] perm, ArrayList<ArrayList<Character>> perms) {
//
//        if (idx == perm.length) {
//            ArrayList<Character> temp = new ArrayList<>();
//            for (char c : perm) temp.add(c);
//            perms.add(temp);
//            return;
//        }
//        for (int i = 0; i < 26; ++i) {
//            if (freqArray[i] > 0) {
//                freqArray[i] -= 1;
//                perm[idx] = (char) (i + 'a');
//                getPermutations(freqArray, idx+1, perm, perms);
//                freqArray[i] +=1;
//            }
//        }
//    }
}
