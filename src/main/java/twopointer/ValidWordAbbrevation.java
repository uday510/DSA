package twopointer;

public class ValidWordAbbrevation {
    public static void main(String[] args) {
        String word = "internationalization";
        String abbr = "i5a11on";

        System.out.println(validWordAbbreviation(word, abbr));
    }
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            } else if (Character.isAlphabetic(abbr.charAt(j)) || abbr.charAt(j) == '0') {
                return false;
            } else {
                int tmp = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    tmp = tmp * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += tmp;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
