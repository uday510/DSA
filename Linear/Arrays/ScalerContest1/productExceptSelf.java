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
        final int MOD = (int) Math.pow(10, 9) + 7;
        int[] products = new int[array.length];

        int leftRunningProduct = 1;
        for(int i = 0; i < array.length; i++) {
            products[i] = leftRunningProduct;
            leftRunningProduct = (leftRunningProduct % MOD * array[i] % MOD) % MOD;
        }

        int rightRunningProduct = 1;
        for(int i = array.length - 1; i > - 1; i--) {
            products[i] = (products[i] * rightRunningProduct) % MOD;
            rightRunningProduct = (rightRunningProduct % MOD * array[i] % MOD) % MOD;
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
