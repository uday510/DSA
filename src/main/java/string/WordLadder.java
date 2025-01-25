package string;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        queue.add(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; ++i) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) return level;
                List<String> neighbors = neighbors(currWord);
                for (String nei : neighbors) {
                    if (words.contains(nei)) {
                        words.remove(nei);
                        queue.add(nei);
                    }
                }
            }
        }
        return 0;
    }
    public List<String> neighbors(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chars.length; ++i) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; ++c) {
                chars[i] = c;
                String nei = new String(chars);
                res.add(nei);
            }
            chars[i] = temp;
        }
        return res;
    }
}
