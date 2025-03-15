package string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        int[] cnt;
        for (String s : strs) {
            cnt = new int[26];

            for (char c : s.toCharArray()) cnt[c-'a']++;

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; ++i) {
                sb.append("#");
                sb.append(cnt[i]);
            }

            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}


