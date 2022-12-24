package Patterns;

public class Pattern21 {
    public static void main(String[] args) {
        int i = 5;
        solve(i);
    }
    public static void solve(int n) {
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == 1 || j == 1 || i == n || j == n) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
