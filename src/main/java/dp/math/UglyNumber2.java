package dp.math;

// https://leetcode.com/problems/ugly-number-ii/?envType=problem-list-v2&envId=50w545lj
public class UglyNumber2 {

    public int nthUglyNumber(int n) {
        int[] uglies = new int[n];
        uglies[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            int n2 = uglies[i2] * 2, n3 = uglies[i3] * 3, n5 = uglies[i5] * 5;
            int nextUgly = Math.min(n2, Math.min(n3, n5));

            uglies[i] = nextUgly;

            if (nextUgly == n2) i2++;
            if (nextUgly == n3) i3++;
            if (nextUgly == n5) i5++;
        }

        return uglies[n - 1];
    }

}
