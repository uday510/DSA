package binarysearch.math;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        long l = 1;
        long r = num >> 1;

        while (l < r) {
            long m = (l + r) >> 1;
            long val = m * m;

            if (val < num) l = m + 1;
            else r = m;
        }

        return l * l == num;
    }

}
