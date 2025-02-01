package bitmanipulation;


public class InterestingArray {
    public static void main(String[] args) {

        int[] array = {9, 14, 27, 81, 197, 0, 1};
        String ans = solve(array);
        System.out.println(ans);
    }

    public static String solve(int[] array) {
        // O(N) time | O(1) space
        int oddCount = 0;

        for (var num : array)
            if (num % 2 != 0)
                oddCount += 1;

        return oddCount % 2 != 0 ? "No" : "Yes";
    }

}
