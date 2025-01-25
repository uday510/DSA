package string;

public class WonderfulStrings {
    public static void main(String[] args) {
        String str = "aabb";

        System.out.println(wonderfulSubstrings(str));
    }
    public static long wonderfulSubstrings(String word) {
        long totalWonderfulSubstrings = 0;
        int len = word.length();

        int[] count = new int[128];


        for (char c : word.toCharArray()) {
            count[c]++;
        }

        for (int i = 0; i < len; i++) {
            int[] temp = count.clone();
            for (int j = i; j < len; j++) {
                int oddCount = 0;
                for (int k = 0; k < 128; k++) {
                    if (temp[k] % 2 != 0) {
                        oddCount++;
                    }
                }
                if (oddCount <= 1) {
                    totalWonderfulSubstrings++;
                }
                temp[word.charAt(j)]--;
            }
        }

        return totalWonderfulSubstrings;
    }

}
