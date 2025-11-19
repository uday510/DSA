package bfs;

import javax.swing.*;
import java.util.*;

public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;
        dict.add(beginWord);


        Map<String, List<String>> adjList = new HashMap<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        boolean found = false;
        dict.remove(beginWord);

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> visitedThisLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                assert cur != null;
                char[] curArr = cur.toCharArray();

                for (int pos = 0; pos < cur.length(); pos++) {
                    char original = curArr[pos];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;
                        curArr[pos] = c;
                        String nxt = new String(curArr);
                        if (!dict.contains(nxt)) continue;

                        adjList.computeIfAbsent(nxt, k -> new ArrayList<>()).add(cur);

                        if (!visitedThisLevel.contains(nxt)) {
                            visitedThisLevel.add(nxt);
                            queue.offer(nxt);
                        }

                        if (nxt.equals(endWord)) {
                            found = true;
                        }
                    }
                    curArr[pos] = original;
                }
            }

            dict.removeAll(visitedThisLevel);
        }


        if (!found) return res;

        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, beginWord, adjList, path, res);
        return res;
    }

    private void dfs(String u, String st, Map<String, List<String>> adjList, List<String> path, List<List<String>> res) {

        if (u.equals(st)) {
            List<String> newPath = new ArrayList<>(path);
            Collections.reverse(newPath);
            res.add(newPath);
            return;
        }


        for (String v : adjList.get(u)) {
            path.addLast(v);
            dfs(v, st, adjList, path, res);
            path.removeLast();
        }
    }

}