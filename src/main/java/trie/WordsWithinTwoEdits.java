package trie;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEdits {

    public List<String> twoEditWords(String[] q, String[] d) {
        TrieNodeForTwoEdits root = new TrieNodeForTwoEdits();

        for (String s : d) insert(root, s);

        List<String> list = new ArrayList<>();

        for (String s : q) {

            if (dfs(root, 0, s, 0)) {
                list.add(s);
            }
        }

        return list;

    }

    private void insert(TrieNodeForTwoEdits root, String w) {

        TrieNodeForTwoEdits cur = root;

        for (int idx = 0; idx < w.length(); idx++) {

            int index = w.charAt(idx) - 'a';

            if (cur.child[index] == null) {
                cur.child[index] = new TrieNodeForTwoEdits();
            }

            cur = cur.child[index];
        }

        cur.isEnd = true;
    }

    private boolean dfs(TrieNodeForTwoEdits node, int idx, String w, int cur) {
        if (cur > 2 || node == null) return false;

        if (idx >= w.length()) return node.isEnd;

        int index = w.charAt(idx) - 'a';

        if (node.child[index] != null) {
            if (dfs(node.child[index], idx + 1, w, cur)) return true;
        }

        for (int i = 0; i < 26; i++) {
            if (i == index || node.child[i] == null) continue;

            if (dfs(node.child[i], idx + 1, w, cur + 1)) {
                return true;
            }

        }

        return false;
    }

}

class TrieNodeForTwoEdits {

    TrieNodeForTwoEdits[] child;
    boolean isEnd;

    TrieNodeForTwoEdits() {
        child = new TrieNodeForTwoEdits[26];
        isEnd = false;
    }

}


