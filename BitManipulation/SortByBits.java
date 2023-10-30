package BitManipulation;

import java.util.Arrays;

public class SortByBits {

    public static void main(String[] args) {
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};

        System.out.println(Arrays.toString(sortByBits(arr)));
    }
    public static int[] sortByBits(int[] arr) {

        int N = arr.length;
        Integer[] tmp = new Integer[N];
        for (int i = 0; i < N; ++i) tmp[i] = arr[i];
        Arrays.sort(tmp, (a, b) -> Integer.compare(countBits(a), countBits(b)));

        for (int i = 0; i < N; ++i) arr[i] = tmp[i];
        return arr;

    }
    public static int countBits(int num) {
        int cnt = 0;

        while (num > 0) {
            if ( (num & 1) == 1) ++cnt;
            num >>= 1;
        }
        return cnt;
    }
}
