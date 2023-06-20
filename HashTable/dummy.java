package HashTable;

import java.util.Arrays;

public class dummy {
    public static void main(String[] args) {
        int a = 3, b = 2;
        int res = solve(a, b);
        System.out.println(res);
    }
    public static int solve(int a, int b) {
        int[] arr = new int[a + b];
        int res = 0;

        for (int i = 0; i < a; i++) {
            arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length;i++) {
            int num = arr[i];
            if (num == 1) {
                res  += num*(int) Math.pow(2, arr.length - 1- i);
            }
        }
        return res;
    }

}
