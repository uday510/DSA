package ScalerContest.Contest3;

import java.util.HashSet;

public class PangramCheck {
    public static void main(String[] args) {
        String[] arr = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
//        String[] arr = {"bit", "scale"};

        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(String[] arr) {

        HashSet<Character> hs = new HashSet<>();

        for (String str : arr) {
            for (int j = 0; j < str.length(); j++) {
                if (!hs.contains(str.charAt(j))) {
                    hs.add(str.charAt(j));
                }
            }
        }
        System.out.println(hs);
        if (hs.size() == 26) return 1;
        return 0;
    }
}
