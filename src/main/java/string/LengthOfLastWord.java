package string;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int p = s.length() - 1;

        while (p > -1 && s.charAt(p) == ' ') {
            --p;
        }

        int length = 0;
        while (p > -1 && s.charAt(p) != ' ') {
            --p;
            ++length;
        }

        return length;
    }
}
