import java.util.*;

class Solution {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(
                List.of("1","2","prev","prev","prev"));

        System.out.println(lastVisitedIntegers(words));
    }
    public static List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < words.size(); ++i) {
            String word = words.get(i);

            if (!Objects.equals(word, "prev")) {
                nums.add(Integer.parseInt(word));
                k = 0;
            } else {
                if (i > 0 && Objects.equals(words.get(i-1), "prev")) {
                    k++;
                }
                if (k >= nums.size()) {
                    res.add(-1);
                } else {
                    res.add(nums.get(nums.size() - k - 1));
                }
            }
        }
        return res;
    }
}