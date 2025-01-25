package string;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        int n = word1.length();
        int m = word2.length();

        StringBuilder sb = new StringBuilder();

        while (i < n && j < m) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }


        while (i < n) {
            sb.append(word1.charAt(i++));
        }

        while (j < m) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }

}
