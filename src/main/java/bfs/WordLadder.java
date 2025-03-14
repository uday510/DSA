package bfs;

// https://leetcode.com/problems/word-ladder

import java.util.*;


/**
 *
 * 1. Only one letter can be changed at a time.
 * 2. Each transformed word must exist in the word list.
 */

/**
 * Time complexity: O(N*M^2)
 * Space Complexity: O(N*M)
 * N is number of words, M is the length of each word
 */

public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList =  Arrays.asList("hot","dot","dog","lot","log","cog");

        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new ArrayDeque<>();
        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord)) return 0;

        queue.offer(beginWord);
        words.remove(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int idx = 0; idx < size; ++idx) {
                String word = queue.poll();
                assert word != null;
                if (word.equals(endWord)) {
                    return level;
                }

                List<String> neighbors = getNeighbors(word, words);
                for (String neighbor : neighbors) {
                    queue.offer(neighbor);
                }
            }
        }

        return 0;
    }

    private static List<String> getNeighbors(String word, Set<String> words) {
        List<String> neighbors = new ArrayList<>();

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];

           for (char j = 'a'; j <= 'z'; j++) {
               if (original == j) continue;
               chars[i] = j;
               String newWord = new String(chars);
               if (words.contains(newWord)) {
                   neighbors.add(newWord);
                   words.remove(newWord);
               }
           }

           chars[i] = original;
        }

        return neighbors;
    }
}
