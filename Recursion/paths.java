package Recursion;

public class paths {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(validPaths(0, 0, n));
    }

    public static int validPaths (int i, int j, int n) {
        if (i == n-1 && j == n-1) { return 1; }

        if (i >= n || j >= n) { return 0; }
        
        return validPaths(i, j+1, n) + validPaths(i+1, j, n);

    }
}
