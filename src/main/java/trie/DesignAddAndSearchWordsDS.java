/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 25
 * word in addWord consists of lowercase English letters.
 * word in search consist of '.' or lowercase English letters.
 * There will be at most 2 dots in word for search queries.
 * At most 104 calls will be made to addWord and search.
 */
package trie;

public class DesignAddAndSearchWordsDS {
    static Node root;
    static TrieClass wordDictionary;
    public static void main(String[] args) {
        root = new Node('$');
        wordDictionary = new TrieClass();
        wordDictionary.addWord(root, "bad");
        wordDictionary.addWord(root,"dad");
        wordDictionary.addWord(root, "mad");
//        System.out.println(wordDictionary.search(root, "pad"));
//        System.out.println(wordDictionary.search(root, "bad"));
        System.out.println( wordDictionary.search(root,".ad"));
        System.out.println(wordDictionary.search(root,"b.."));
    }
}
class Trie {
    public void addWord(Node root, String data) {
        Node currNode = root;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            int idx = c - 'a'; // gives index
            if (currNode.children[idx] == null) {
                currNode.children[idx] = new Node(c);
            }
            currNode = currNode.children[idx];
            currNode.freq++;
        }
        currNode.eow = true;
    }
    public boolean search(Node root, String data) {
        /**
         * 1. starting with .
         * 2. ending with ..
         *
         *
         *
         */
        Node currNode = root;
        int freq = 0;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c == '.') continue;
            int idx = c - 'a';
            if (currNode.children[idx] == null) {
                return false;
            }
            freq = currNode.freq;
            currNode = currNode.children[idx];
        }
        return freq > 0;
    }
}
class Node {
    char data;
    Node[] children;
    boolean eow;
    int freq;
    Node(char data) {
        this.data = data;
        children = new Node[26];
        eow = false;
        freq = 0;
    }
}

class TrieClass {
    public void addWord(Node root, String data) {
        Node currNode = root;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            int idx = c - 'a'; // gives index
            if (currNode.children[idx] == null) {
                currNode.children[idx] = new Node(c);
            }
            currNode = currNode.children[idx];
            currNode.freq++;
        }
        currNode.eow = true;
    }
    public boolean search(Node root, String data) {
        return searching(data, 0, root);
    }
    public boolean searching(String data, int idx, Node currNode) {
        if (currNode == null) { return false; }

        if (idx == data.length()) { return currNode.eow; }

        char c = data.charAt(idx);

        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (searching(data, idx+1, currNode.children[i])) {
                    return true;
                }
            }
            return false;
        }
        return searching(data, idx+1, currNode.children[c - 'a']);
    }
}
