package slidingwindow;

import java.util.Arrays;
import java.util.Map;

public class MinSwapsToGrpAll1s {

    public static void main(String[] args) {
        int[] data = {1,0,0,1,1,1};
        System.out.println(minSwaps(data));
    }
    public static int minSwaps(int[] data) {
        //TODO: TLE
//        int minSwaps = Integer.MAX_VALUE;
//        int N = data.length;
//
//        int ones = (int) Arrays.stream(data).filter(d -> d == 1).count();
//
//        for (int i = 0; i < N-ones+1; ++i) {
//            int cnt = 0;
//            for (int j = i; j < i + ones; ++j) {
//                if (data[j] == 0) cnt++;
//            }
//            minSwaps = Math.min(minSwaps, cnt);
//            System.out.println(i + " " + minSwaps + " " + (i + ones));
//        }
//
//        return minSwaps;

        int N = data.length;
        int windowSize = (int) Arrays.stream(data).filter(d -> d == 1).count();

        int currOnesInWindow = 0;
        int maxOnesInWindow = 0;

        for (int i = 0; i < N; ++i) {
            currOnesInWindow += data[i];
            if (i >= windowSize) {
                currOnesInWindow -= data[i-windowSize];
            }
            maxOnesInWindow = Math.max(maxOnesInWindow, currOnesInWindow);
        }

        return windowSize - maxOnesInWindow;
    }
}
