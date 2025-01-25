package bitmanipulation;

public class FindTheDifference {
    static char diff = 0;
    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        findDifference(s);
        findDifference(t);

        System.out.println(diff);
    }
    private static void findDifference(String str) {

        for (char ch : str.toCharArray()) {
            diff ^= ch;
        }

    }
}
