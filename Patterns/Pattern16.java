package Patterns;

public class Pattern16 {
    public static void main(String[] args) {
        int i = 5;
        solve(i);
    }
    public static void solve(int num) {
        for(int i = 1; i <= num; i++) {
            int ascii = 64 + i;
            for(int j = 1; j <= i; j++) {
                System.out.print( (char) ascii + " ");
            }
            System.out.println();
        }

    }
}
