package string;

public class EqualScoreSubstrings {

    public static boolean scoreBalance(String s) {
        int n = s.length();
        int[] pf = new int[n];
        pf[0] = s.charAt(0) + 1 - 97;

        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + (s.charAt(i) + 1 - 97);
        }

        for (int i = 0; i < n; i++) {
            int l = pf[i];
            int r = pf[n - 1] - l;
            if (l == r) {
                return true;
            }
        }

        return false;
    }


    static void main() {
        System.out.println(scoreBalance("lmm"));
    }
}
