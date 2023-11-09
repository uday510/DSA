package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HomogenousSubstrings {
    public static void main(String[] args) {
        String s = "abbccaa";

        System.out.println(countHomogenous(s));
    }
    public static int countHomogenous(String s) {
        int N = s.length();
        int i = 0,j=0;
        int res = 0;

        for (; j < N; ++j) {
            while (i < N && s.charAt(i) == s.charAt(j)) {
                res += j - i + 1;
                ++i;
            }
        }
        return res;
    }
}
