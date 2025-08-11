package binarysearch.math;

public class Sqrt {

    public int mySqrt(int x) {
        if (x == 1) return 1;
        long l = 1;
        long r = x;

        while (l < r) {
            long m = (l + r) >> 1;
            long val = (m * m);

            if (val == x) return (int) m;

            if (val < x) l = m + 1;
            else r = m;
        }

        return (int) l - 1;
    }

}
