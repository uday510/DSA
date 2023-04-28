package ScalerContest;

public class LongestSpecialSubstring {
    public static void main(String[] args) {
        String a = "rishabhkejariwal";
        int[] b = {
                    0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0,
                    0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0
                  };
        int c = 2;

        int ans = solve(a, b, c);
        System.out.println(ans);
    }
    public static int solve(String a, int[] b, int c) {
        // O(N) time | O(1) space

        int left = -1, right = -1, ans = 0;
        int count = c;

        int i = 0, j = 0;

        while (j < a.length()) {
            char currChar = a.charAt(j);
            int num = currChar - 97;

            if (b[num] == 1) {
                count--;
            }

            while (count < 0) {
                currChar = a.charAt(i);
                num = currChar - 97;
                if (b[num] == 1) {
                    count++;
                }
                i++;
            }
            if (j - i + 1 > ans) {
                ans = j - i + 1;
                left = i;
                right = j;
            }
            j++;
        }
        return right - left + 1;

    }
}
