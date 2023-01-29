package ScalerContest1;

import java.util.Arrays;

public class productExceptSelf {

    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2};
        System.out.println(Arrays.toString(productExceptSelf(array)));

    }
    public static int[] productExceptSelf(int[] array) {
        // O(n) time | O(n) space
//        (A * B) mod C = (A mod C * B mod C) mod C
        int len =  array.length;
        int[] products = new int[len];

        final long MOD = (long) Math.pow(10, 9) + 7;
        long leftProduct = 1;
        for (int i = 0; i < len; i++) {
            long currentNum = array[i];
            products[i] = (int) leftProduct;
            leftProduct = ((leftProduct % MOD) * (currentNum % MOD)) % MOD;
        }

        long rightProduct = 1;
        for (int i = len - 1; i > -1; i--) {
            long currentNum = array[i];
            products[i] = (int) (((products[i] % MOD ) * (rightProduct % MOD)) % MOD);
            rightProduct = ((rightProduct % MOD) * (currentNum % MOD)) % MOD;
        }
        return products;
    }
    public int[] arrayOfProductsBruteForce(int[] array) {
        // O(n^2) time | O(n) space
        int[] products = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            int runningProduct = 1;
            for(int j = 0; j < array.length; j++)
                if(i != j) runningProduct *= array[j];
            products[i] = runningProduct;
        }
        return products;
    }
}
