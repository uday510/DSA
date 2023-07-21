package Array;

import java.util.Arrays;

public class dummy {
    public static void main(String[] args) {
        int[] arr = {4, 1, 8, 6, 2, 5, 3};

        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] array) {
        for (int i = 0; i < array.length; i++) {

            // keep swapping until array[i] = array[i+1]
            while ( array[i] <= array.length && array[i] != i+1) {
                int val = array[i];
                if (array[i] == array[val-1]) break;
                swap(i,val-1, array);
                System.out.println(Arrays.toString(array));
            }
        }

        // iterate and find val where array[i] != array[i+1]

        for (int i = 0; i < array.length; i++) {
            if(array[i] != i + 1) return i + 1;
        }
        return array.length + 1;
    }
    public static void swap(int i, int j,int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
