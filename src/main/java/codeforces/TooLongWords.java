package codeforces;

import java.io.*;
import java.util.StringTokenizer;

// https://codeforces.com/problemset/problem/71/A
public class TooLongWords {
    public static void main(String[] args) {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int testcases = scanner.nextInt();

        while (testcases-- > 0) {
            String str = scanner.next();
            out.println(solve(str));
        }
        out.flush();
        out.close();
    }

    private static String solve(String str) {
        if (str.length() <= 10) return str;

        return str.charAt(0) + "" + (str.length() - 2) + "" + str.charAt(str.length() - 1);
    }
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String str = br.readLine();
                    if (str == null) return "";
                    st = new StringTokenizer(str);
                } catch (IOException e) {
                    return "";
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            String value = next();
            return value.isEmpty() ? 0 : Integer.parseInt(value);
        }
    }
}
