package trie;

public class MaximumXorSubarray {
    public static void main(String[] args) {

    }
    public static int[] solve(int[] A) {
        TrieNode root = new TrieNode();
        int maxNum = A[0];

        int[] pf = new int[A.length + 1];
        pf[0] = 0;

        for (int i = 0; i < A.length; i++) {
            pf[i+1] = pf[i] ^ A[i];
        }

        for (int i = 0; i < pf.length; i++) {
            int num = pf[i];
            TrieNode currNode = root;
            for (int j = 31; j > -1; j--) {
                if ((num & 1 << j) == 0) {
                    if (currNode.children[0] == null) {
                        currNode.children[0] = new TrieNode();
                    }
                    currNode = currNode.children[0];
                } else {
                    if (currNode.children[1] == null) {
                        currNode.children[1] = new TrieNode();
                    }
                    currNode = currNode.children[1];
                }
            }
            if(currNode.end == -1) {
                currNode.end = i;
            }
        }

        int max = 0, start = -1, end = -1;
        for (int i = 0; i < pf.length; i++) {
            int num = pf[i];

            int xor = 0;
            TrieNode currNode = root;

            for (int j = 31; j > -1; j--) {
                if ((num & (1 << j)) == 0) {
                    if (currNode.children[1] != null) {
                        // set jth bit in xor value
                        xor = (xor | (1 << j));
                        currNode = currNode.children[1];
                    } else {
                        currNode = currNode.children[0];
                    }
                } else {
                    if (currNode.children[0] != null) {
                        // set jth bit in xor value
                        xor = (xor | (1 << j));
                        currNode = currNode.children[0];
                    } else {
                        currNode = currNode.children[1];
                    }
                }
            }
            if (xor > max) {
                max = xor;
                start = i + 1;
                end = currNode.end;
            } else if(xor == max && currNode.end > i) {
                int prev = end - start + 1;
                int curr = currNode.end - i;
                if(curr < prev) {
                    start = i + 1;
                    end = currNode.end;
                }
            }
        }
        return new int[]{start, end};
    }
    static class TrieNode {
        TrieNode[] children;
        int end = -1;
        TrieNode() { this.children = new TrieNode[2]; }
    }
}
