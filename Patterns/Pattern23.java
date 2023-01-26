package Patterns;

public class Pattern23 {
    public static void main(String[] args) {
        int i = 7;
        solve(i);
    }

    public static void solve(int num) {

        int n = num - 2;
        for (int i = 0; i < num; i++) {
            System.out.print("0 ");
        }
        System.out.println();
        int currentLine = n / 2 + 1;
        for (int i = 1; i <= currentLine; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("0 ");
            }
            for (int p = 1; p <= num - (i * 2); p++) {
                System.out.print("1 ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("0 ");
            }
            System.out.println();

        }
        int zeros = currentLine;
        for (int i = currentLine; i < num - 2; i++) {
            for (int j = 1; j < zeros; j++) {
                System.out.print("0 ");
            }
            for (int k = 1; k <= num - (zeros - 1) * 2; k++) {
                System.out.print("1 ");
            }
            for (int j = 1; j < zeros; j++) {
                System.out.print("0 ");
            }
            zeros--;
            System.out.println();
        }

        for (int i = 0; i < num; i++) {
            System.out.print("0 ");
        }

    }
}
