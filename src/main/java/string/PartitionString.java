package string;

public class PartitionString {
    public static void main(String[] args) {

    }
    public static int partitionString(String s) {

        boolean[] seen = new boolean[26];
        int min = 1;

        for (char c : s.toCharArray()) {
            if (seen[c - 'a']) {
                seen = new boolean[26];
                min++;
            }
            seen[c - 'a'] = true;
        }
        return min;
    }
}
