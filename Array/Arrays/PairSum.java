package Array.Arrays;

public class PairSum {
    public static void main(String[] args) {
        int[] array = {-3, 0, 1, 3, 6, 8, 11, 14, 18, 25};
        int k = 17;
        int ans = solve(array, k);
        System.out.println(ans);
    }
    public static int solve(int[] array, int k) {

        // -- BRUTE FORCE
        int pairsCount = 0;

//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j < array.length; j++) {
//                if (array[i] + array[j] == k) {
//                    pairsCount++;
//                }
//            }
//        }

        // Hash Set

//        Set<Integer> set = new HashSet<>();
//
//        for (int num : array) {
//            int potentialMatch = k - num;
//            if (set.contains(potentialMatch)) {
//                pairsCount++;
//            }
//            set.add(num);
//        }

        // --- Two Pinter ---
        return pairsCount;
    }
}
