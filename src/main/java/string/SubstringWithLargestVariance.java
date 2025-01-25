package string;

public class SubstringWithLargestVariance {
    public static void main(String[] args) {

    }
    public int largestVariance(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) cnt[c - 'a'] += 1;

        int largestVariance = 0;
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < 26; ++j) {
                if (i == j || cnt[i] == 0 || cnt[j] == 0) continue;

                char major = (char) ('a' + i);
                char minor = (char) ('a' + j);

                char majorCount = 0;
                char minorCount = 0;

                int restMinor = cnt[j];


                for (char c : s.toCharArray()) {
                    if (c == major) {
                        majorCount++;
                    }

                    if (c == minor) {
                        minorCount++;
                        restMinor--;
                    }

                    if (minorCount > 0) {
                        largestVariance = Math.max(largestVariance, majorCount - minorCount);
                    }

                    if (majorCount < minorCount && restMinor > 0) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }
        return largestVariance;
    }
}
