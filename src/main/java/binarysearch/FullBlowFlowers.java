package binarysearch;

import java.util.*;

public class FullBlowFlowers {
    public static void main(String[] args) {
        int[][] flowers = {{1, 6}, {3, 7}, {9, 12}, {4, 13}};
        int[] poeple = {2, 3, 7, 11};

        int[] res = fullBloomFlowers(flowers, poeple);
        System.out.println(Arrays.toString(res));
    }
    public static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] res = new int[people.length];

        List<Integer> s = new ArrayList<>();
        List<Integer> e = new ArrayList<>();

        for (int[] flower : flowers) {
            s.add(flower[0]);
            e.add(flower[1]);
        }

        Collections.sort(s);
        Collections.sort(e);

        //TODO s:    [1 3 4 9]
        //TODO e:    [6 7 9 13]
        //TODO p:    [2 3 7 11]

        System.out.println(bs(s, 2));

        for (int i = 0; i < people.length; ++i) {
            int p = people[i];

            res[i] = bs(s, p+1)- bs(e, p);
        }
        return res;
    }

    public static int bs(List<Integer> array, int target) {
        int left = 0, right = array.size();

        while (left < right) {
            int mid = (left + right) >> 1;

            if (array.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
