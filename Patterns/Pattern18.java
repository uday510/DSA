package Patterns;

public class Pattern18 {
    public static void main(String[] args) {
        int i = 4;
        solve(i);
    }

    public static void solve(int num) {

        for(int i = 1; i <= num; i++) {
            int ascii = 69;
            ascii -= i;
            for(int j = 1; j <= i; j++) {
                ascii += 1;
                System.out.print( (char) ascii + " ");
            }
            System.out.println();
        }
    }
}
