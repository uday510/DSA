package biweekly.contest138;

public class StringHash {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;

        System.out.println(stringHash(s, k));
    }
    public static String stringHash(String s, int k) {
        int n = s.length();
        int times = n / k;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < times; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += s.charAt(i * k + j) - 'a';
            }
            sb.append((char)('a' + sum % 26));
        }

        return sb.toString();
    }
}
