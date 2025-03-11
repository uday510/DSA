package amzn.oa;

import java.util.ArrayList;
import java.util.List;

public class NumberOfItems {

        public List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
            int n = s.length();
            int[] leftPipe = new int[n];
            int[] rightPipe = new int[n];
            int[] prefixSum = new int[n];

            int lastPipe = -1;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '|') lastPipe = i;
                leftPipe[i] = lastPipe;
            }

            // Precompute right-most '|' index for each position
            lastPipe = -1;
            for (int i = n - 1; i >= 0; i--) {
                if (s.charAt(i) == '|') lastPipe = i;
                rightPipe[i] = lastPipe;
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '*') count++;
                prefixSum[i] = count;
            }

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < startIndices.size(); i++) {
                int left = rightPipe[startIndices.get(i) - 1];
                int right = leftPipe[endIndices.get(i) - 1];

                if (left != -1 && right != -1 && left < right) {
                    result.add(prefixSum[right] - (left > 0 ? prefixSum[left - 1] : 0));
                } else {
                    result.add(0);
                }
            }

            return result;
        }
}
