package BinarySearch;

public class FullBlowFlowers {
    public static void main(String[] args) {

    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];
        int i = 0;

        for (int arriveTime : people) {
            int cnt = 0;
            for (int[] time : flowers) {
                int start = time[0];
                int end = time[1];

                if (arriveTime > start && arriveTime < end) {
                    cnt++;
                }
            }
            res[i++] = cnt;
        }
        return res;
    }
}
