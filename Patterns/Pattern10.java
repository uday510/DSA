package Patterns;

public class Pattern10 {
    public static void main(String[] args) {
        int i = 10;
        solve(i);
    }
    public static void solve(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                if(j == i)
                    System.out.print("*");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        for(int i = n - 1; i > -1; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

