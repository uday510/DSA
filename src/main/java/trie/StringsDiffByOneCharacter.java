package trie;

public class StringsDiffByOneCharacter {

    // https://leetcode.com/problems/strings-differ-by-one-character/

    static class TrieNode {
        TrieNode[] nxt = new TrieNode[26];
        boolean eow = false;
    }

    TrieNode root;
    public boolean differByOne(String[] dict) {
        root = new TrieNode();

        for (String w : dict) {
            if (search(w, root, 0, false)) {
                return true;
            }
            insert(w);
        }

        return false;
    }

    private boolean search(String w, TrieNode cur, int i, boolean mismatched) {
        if (cur == null) return false;

        if (i == w.length()) return cur.eow && mismatched;

        int ch = w.charAt(i) - 'a';

        if (cur.nxt[ch] != null && search(w, cur.nxt[ch], i + 1, mismatched)) {
            return true;
        }

        if (mismatched) return false;

        for (int j = 0; j < 26; j++) {
            if (j != ch && cur.nxt[j] != null) {
                if (search(w, cur.nxt[j], i + 1, true)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void insert(String w) {
        TrieNode cur = root;

        for (int i = 0; i < w.length(); i++) {
            int ch = w.charAt(i) - 'a';
            if (cur.nxt[ch] == null) cur.nxt[ch] = new TrieNode();
            cur = cur.nxt[ch];
        }

        cur.eow = true;
    }

}
