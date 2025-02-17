package codeforces;

import java.io.*;

public class SpeedTest {
    public static void main(String[] args) throws IOException {
        long start, end;

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
//            System.out.println(i);
        }
        end = System.currentTimeMillis();
        System.out.println("System.out.println() Time: " + (end - start) + "ms");

        // Using PrintWriter
        start = System.currentTimeMillis();
        PrintWriter out = new PrintWriter(System.out);
        for (int i = 0; i < 1_000_000; i++) {
            out.println(i);
        }
        out.flush();
        end = System.currentTimeMillis();
        System.out.println("PrintWriter Time: " + (end - start) + "ms");
    }
}
