package string;

public class HighFrequency {
    public static void main(String[] args) {
        int N = 4;
        String S = "dwlq";

        String res = solve(N, S);
        System.out.println(res);
    }
    public static String solve(int N, String S) {
        // code here
        
        int[] arr = new int[26];

        for (char c : S.toCharArray()) {
            arr[c - 'a'] += 1;
        }

        String s = "";
        int max = 0;

       for (int i = 0; i < 26; ++i) {
           if (arr[i] > max) {
               max = arr[i];
               char c = (char) ('a' + i);
               s = String.valueOf(c);
           }
       }
        return s;
    }
}
