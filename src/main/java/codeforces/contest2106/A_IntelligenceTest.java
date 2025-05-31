package codeforces.contest2106;

import java.util.Scanner;

public class A_IntelligenceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int count1 = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '1') count1++;
            }

            int totalOnes = count1 * (n - 2) + n;
            System.out.println(totalOnes);
        }
    }
}