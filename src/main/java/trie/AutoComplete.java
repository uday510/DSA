/**
 * Problem Description
 * There is a dictionary A of N words, and ith word has a unique weight Wi.
 *
 * Another string array B of size M contains the prefixes. For every prefix B[i], output atmost 5 words from the dictionary A that start with the same prefix.
 *
 * Output the words in decreasing order of their weight.
 *
 * NOTE: If there is no word that starts with the given prefix output -1.
 *
 *
 *
 * Problem Constraints
 * 1 <= T <= 5
 *
 * 1 <= N <= 20000
 * 1 <= M <= 10000
 *
 * 1 <= Wi <= 106
 *
 * 1 <= length of any string either in A or B <= 30
 *
 *
 *
 * Input Format
 * First line is an integer T denoting the number of test cases.
 * For each test case,
 *
 * First line denotes two space seperated integer N and M.
 * Second line denotes N space seperated strings denoting the words in dictionary.
 * Third line denotes N space seperated integers denoting the weight of each word in the dictionary.
 * Fourth line denotes M space seperated integers denoting the prefixes.
 *
 *
 * Output Format
 * For every prefix B[i], print the space seperated output on a new line.
 *
 * NOTE: After every output there should be a space.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  1
 *  6 3
 *  abcd aecd abaa abef acdcc acbcc
 *  2 1 3 4 6 5
 *  ab abc a
 * Input 2:
 *
 *  1
 *  5 3
 *  aaaa aacd abaa abaa aadcc
 *  3 4 1 2 6 
 *  aa aba abc
 *
 *
 * Example Output
 * Output 1:
 *
 *  abef abaa abcd 
 *  abcd 
 *  acdcc acbcc abef abaa abcd 
 * Output 2:
 *
 *  aadcc aacd aaaa 
 *  abaa abaa 
 *  -1 
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  For the prefix "ab" 3 words in the dictionary have same prefix: ("abcd" : 2, "abaa" : 3, "abef" : 4). Ouput them in decreasing order of weight.
 *  For the prefix "abc" only 1 word in the dictionary have same prefix: ("abcd" : 2).
 *  For the prefix "a" all 6 words in the dictionary have same prefix: ("abcd" : 2, "aecd" : 1, "abaa" : 3, "abef" : 4, "acdcc" : 6, "acbcc" : 5).
 *  Since we can output atmost 5 words. Output top 5 weighted words in decreasing order of weight.
 * Explanation 2:
 *
 *  For the prefix "aa" 3 words in the dictionary have same prefix: ("aaaa" : 3, "aacd" : 4, "aadcc" : 6). Ouput them in decreasing order of weight.
 *  For the prefix "aba" 2 words in the dictionary have same prefix: ("abaa" : 1, "abaa" : 2).
 *  For the prefix "abc" there is no word in the dictionary which have same prefix. So print -1.
 */
package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AutoComplete {
    /**
     * TEST CASE:
     *  1
     *  6 3
     *  abcd aecd abaa abef acdcc acbcc
     *  2 1 3 4 6 5
     *  ab abc a
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt(); // no.of words
            int m = scanner.nextInt(); // no.of prefixes
            String[] words = new String[n]; // store words
            int[] weights = new int[n]; // store weights
            String[] prefixes = new String[m]; // store prefixes
            for (int j = 0; j < n; j++) { words[j] = scanner.next(); } // scan and store words
//            System.out.println("words " + Arrays.toString(words));
            for (int j = 0; j < n; j++) { weights[j] = scanner.nextInt(); } // scan and store weights
//            System.out.println("Weights " +  Arrays.toString(weights));
            for (int j = 0; j < m; j++) { prefixes[j] = scanner.next(); } // scan and store prefixes
//            System.out.println("prefixes " +  Arrays.toString(prefixes));
            Pair[] pairs = new Pair[n]; // create a pair of words
            for (int j = 0; j < n; j++) { pairs[j] = new Pair(words[j], weights[j]); } // store each word and it's weight in pair
//            System.out.println(Arrays.toString(pairs));
            Arrays.sort(pairs, (a, b) -> b.weight - a.weight); // sort in decreasing order according to their weights
            Node root = new Node(); // create a root node
            for (int j = 0; j < pairs.length; j++) { addWord(root, pairs[j].word, j);}
            for (String prefix : prefixes) { search(root, prefix, pairs); }
        }
    }
    public static void addWord(Node root, String data, int index) {
        Node currNode = root;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            int currCharIdx = c - 'a'; // gives index
            if (currNode.children[currCharIdx] == null) {
                currNode.children[currCharIdx] = new Node(); // create new node
            }
            currNode = currNode.children[currCharIdx];
            if (currNode.idx.size() < 5) currNode.idx.add(index);
        }
        currNode.eow = true;
    }
    public static void search(Node root, String prefix, Pair[] words) {
       Node currNode = root;
       for (int i = 0; i < prefix.length(); i++) {
           int idx = prefix.charAt(i) - 'a';
           if (currNode.children[idx] == null) {
               System.out.println("-1 ");
               return;
           } currNode = currNode.children[idx];
       }
       for (int i : currNode.idx) System.out.print(words[i].word + " ");
       System.out.println();
    }
    static class Node {
        Node[] children;
        ArrayList<Integer> idx;
        boolean eow;

        Node() {
            children = new Node[26];
            idx = new ArrayList<>();
            eow = false;
        }
    }
    static class Pair {
        String word;
        int weight;

        Pair(String word, int weight) {
            this.word = word;
            this.weight = weight;
        }
    }
}


/*
cities:
    id: Number
    name; string

airport:
    id: Number
    name: string
    city_id: number

flight:
    id: Number
    name: string
    source_airport: number
    desitnation_airport: number


    SELECT * FROM
        flight
        WHERE
           desitnation_airport = (
        SELECT id FROM
            airport
            WHERE name = 'kochi'
            );
 */


