package codeforces;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Watermelon {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int n = sc.nextInt();

        out.println(solve(n));

        out.flush();
        out.close();
    }

    private static String solve(int weight) {
        return weight <= 2 || weight % 2 != 0 ? "NO" : "YES";
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

        long nextLong() {
            String value = next();
            return value.isEmpty() ? 0L : Long.parseLong(value);
        }

        double nextDouble() {
            String value = next();
            return value.isEmpty() ? 0.0 : Double.parseDouble(value);
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return "";
            }
        }
    }
}

