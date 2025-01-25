package binarysearch;

import java.util.HashSet;
import java.util.PriorityQueue;

public class CountNumberOfKBigIndices {
    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 5, 2, 3};
        int k = 2;
        System.out.println(kBigIndices(nums, k));
    }
    public static int kBigIndices(int[] nums, int k) {
        int N = nums.length;
        boolean[] prefix = new boolean[N];
        int res = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; ++i) {
            if (pq.size() == k && pq.peek() < nums[i]) prefix[i] = true;

            pq.offer(nums[i]);
            if (pq.size() > k) pq.poll();
        }
        pq.clear();

        for (int i = N - 1; i > -1; --i) {
            if (pq.size() == k && pq.peek() < nums[i] && prefix[i]) res++;

            pq.offer(nums[i]);
            if (pq.size() > k) pq.poll();
        }

        return res;


//        int kBigIndices = 0;
//
//        for (int i = k; i < N; ++i) {
//            int cnt1 = leftCnt(0, i, nums);
//            int cnt2 = rightCnt(i, N-1, nums);
//
//            System.out.println(cnt1 +" " + cnt2);
//
//            if (cnt1 >= k && cnt2 >= k) {
//                kBigIndices++;
//            }
//        }
//        return kBigIndices;
    }
    public static int leftCnt(int i, int j, int[] nums) {

        int num = nums[j];
        HashSet<Integer> set = new HashSet<>();

        while (i < j) {
            int curr = nums[i];
            if (curr < num) {
                set.add(curr);
            }
            i++;
        }
        return set.size();
    }
    public static int rightCnt(int i, int j, int[] nums) {
        int num = nums[i];
        HashSet<Integer> set = new HashSet<>();

        while (i < j) {
            int curr = nums[j];
            if (curr < num) {
                set.add(curr);
            }
            --j;
        }
        return set.size();
    }
}
