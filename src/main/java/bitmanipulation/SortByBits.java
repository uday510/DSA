package bitmanipulation;

import java.util.Arrays;

public class SortByBits {

    public static void main(String[] args) {
        int[] arr = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};

        System.out.println(Arrays.toString(sortByBits(arr)));
    }

    public static int[] sortByBits(int[] arr) {
        int N = arr.length;
        Integer[] tmp = new Integer[N];
        for (int i = 0; i < N; ++i) tmp[i] = arr[i];

        Arrays.sort(tmp, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);

            return (bitCountA == bitCountB ?
                    a - b : bitCountA - bitCountB);
        });

        return Arrays.stream(tmp).mapToInt(Integer::intValue).toArray();
    }
}
