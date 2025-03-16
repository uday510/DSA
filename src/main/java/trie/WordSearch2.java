package trie;


import java.util.ArrayList;
import java.util.List;

class TrieNode {
    String word;
    TrieNode[] children = new TrieNode[26];
}
public class WordSearch2 {

    TrieNode root;
    boolean[][] visited;
    int numRows;
    int numCols;
    List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        initialize(board);
        addWordsToTrie(words);

        for (int row = 0; row < numRows; ++row) {
            for (int col = 0; col < numCols; ++col) {
                dfs(row, col, board, root);
            }
        }

        return result;
    }

    private void dfs(int row, int col, char[][] board, TrieNode node) {
        if (!valid(row, col)) return;

        int index = board[row][col] - 'a';
        node = node.children[index];
        if (node == null) return;

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        visited[row][col] = true;
        dfs(row + 1, col, board, node);
        dfs(row - 1, col, board, node);
        dfs(row, col + 1, board, node);
        dfs(row, col - 1, board, node);
        visited[row][col] = false;
    }
    private boolean valid(int R, int C) {
        return !(R < 0 || R >= numRows || C < 0 || C >= numCols || visited[R][C]);
    }
    private void initialize(char[][] board) {
        root = new TrieNode();
        numRows = board.length;
        numCols = board[0].length;
        visited = new boolean[numRows][numCols];
        result = new ArrayList<>();
    }
    private void addWordsToTrie(String[] words) {
        for (String str : words) {
            addWordToTrie(str, root);
        }
    }
    private void addWordToTrie(String word, TrieNode node) {
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }
}
