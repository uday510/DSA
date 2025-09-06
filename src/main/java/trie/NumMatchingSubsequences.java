package trie;

import java.util.ArrayList;

public class NumMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<Node>[] heads = new ArrayList[26];
        int res = 0;

        for (int i = 0; i < 26; i++)
            heads[i] = new ArrayList<Node>();

        for (String w : words)
            heads[w.charAt(0) - 'a'].add(new Node(w, 0));

        for (char c : s.toCharArray()) {
            ArrayList<Node> old = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node : old) {
                node.idx++;

                if (node.idx == node.word.length()) res++;
                else heads[node.word.charAt(node.idx) - 'a'].add(node);
            }
        }
        return res;
    }

    private class Node {
        String word;
        int idx;

        Node (String w, int i) {
            word = w;
            idx = i;
        }
    }



//    char[] chars;
//    public int numMatchingSubseq(String s, String[] words) {
//        chars = s.toCharArray();
//
//        int cnt = 0;
//        for (String w : words) {
//            if (seq(w)) cnt++;
//        }
//
//        return cnt;
//    }
//
//    private boolean seq(String w) {
//        int i = 0;
//        char[] ch = w.toCharArray();
//        int n = w.length();
//
//        for (char c : chars) {
//            if (i < n && c == ch[i]) i++;
//        }
//
//        return i == n;
//    }

}
