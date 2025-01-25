package greedy;

public class dummy {
    public static void main(String[] args) {

        String s1 = "bbfp";
        String s2 = "fbbp";

        System.out.println(canBeEqual(s1, s2));

    }
    public static boolean canBeEqual(String s1, String s2) {
        char[] ch = s2.toCharArray();

        for (int i = 0; i < 4; ++i) {

            if (ch[i] == s1.charAt(i)) { continue; }

            if (i + 2 < 4 && ch[i + 2] == s1.charAt(i)) {
                char c = ch[i + 2];
                ch[i + 2] = ch[i];
                ch[i] = c;
            } else {
                return false;
            }
        }
        return true;
    }

}
