package ScalerContest.Contest3;
import java.util.*;

public class CountVowels {
    public static void main(String[] args) {
        String str = "interviewbit";
        int[][] b = { {0, 5}, {4, 5} };

        int[] ans = solve(str, b);
        System.out.println(Arrays.toString(ans));
    }
    public static int[] solve(String str, int[][] b) {
        int[] arr = new int[str.length()];
        int prev = 0;
        ArrayList<Integer> list = new ArrayList<>();
        char c = str.charAt(0);

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                arr[i] = prev + 1;
                prev = arr[i];
            } else {
                arr[i] = prev;
            }
        }

        for (int[] k : b) {
            int m = k[0];
            int n = k[1];
            if (k[0] == 0) {
                list.add(arr[n]);
            } else {
                list.add(arr[n] - arr[m - 1]);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
