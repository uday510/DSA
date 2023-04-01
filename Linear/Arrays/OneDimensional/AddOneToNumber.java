package Linear.Arrays.OneDimensional;

import java.util.Arrays;

public class AddOneToNumber {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 9, 9, 9, 9, 9};
        int[] ans = solve(arr);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(int[] arr) {
        int n = arr.length;

        if (arr[0] == 0) {
            int i = 0;
            while (i < n && arr[i] == 0) {
                i++;
            }
           return solve2(Arrays.copyOfRange(arr, i, n));
        } else {
            return solve2(arr);
        }
    }

    public static int[] solve2 (int[] arr) {

        int n = arr.length;

        for (int i = n - 1; i > -1; i--) {
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }
            arr[i] = 0;
        }

        int[] newNumbers = new int[n+1];
        newNumbers[0] = 1;
        return newNumbers;
    }
}
