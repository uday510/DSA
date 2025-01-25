package trie;
import java.util.*;

class TypeHead {
    // Pair stores the input string and total frequency
    static class Pair implements Comparable<Pair>{
        long frequency;
        String string;

        Pair(long frequency,String string){
            this.frequency=frequency;
            this.string=string;
        }
        // Comparison based on frequency and lexicographically on strings
        @Override
        public int compareTo(Pair pair){
            if(this.frequency<pair.frequency){
                return -1;
            }
            else if(this.frequency>pair.frequency){
                return 1;
            }
            else{
                if(this.string.compareTo(pair.string)<0)
                    return -1;
                else if(this.string.compareTo(pair.string)>0)
                    return 1;
                return 0;
            }
        }
    }

    //Trie for storing the search
    static class TrieNode{
        int isEndOfWord;
        HashMap<String, Long> map; //Stores the frequency
        LinkedList<Pair> list;     // Stores the strings in ascending order of frequency and lexicographical order
        TrieNode[] child;
        TrieNode(){
            isEndOfWord=-1;
            child= new TrieNode[26];
            for(int i=0;i<26;i++){
                child[i]=null;
            }
            map=new HashMap<>();
            list=new LinkedList<>();
        }
    }

    TrieNode root=new TrieNode();  // Creating a common root node

    void insert(String inputString,int frequency){
        TrieNode temp=root;
        for(int i=0;i<inputString.length();i++){
            char ch=inputString.charAt(i);
            int index=ch-'a';
            if(temp.child[index]==null){
                temp.child[index]=new TrieNode();
            }
            temp=temp.child[index];
            int j=0;

//If inputString is present, the increase frequency in map and remove string with older
// frequency from the list and add string with new frequency in sorted manner in list
            if(temp.map.containsKey(inputString)){
                temp.map.put(inputString, temp.map.get(inputString) + Long.valueOf(frequency));
                j=0;
                while(j<temp.list.size() && !temp.list.get(j).string.equals(inputString)){
                    j++;
                }
                temp.list.remove(j);
            }
            else{
                temp.map.put(inputString, Long.valueOf(frequency));
            }
            long newFrequency = temp.map.get(inputString);
            Pair pair =new Pair(newFrequency, inputString);
            j=0;
            while((j<temp.list.size()) && (pair.compareTo(temp.list.get(j)) == 1)){
                j++;
            }
            temp.list.add(j,pair);
        }
        temp.isEndOfWord=1;
    }
    // finding strict prefixes else returning blank strings
    String[] find(String queryPrefix,int x){
        String[] outputStrings = new String[x];
        TrieNode temp = root;
        int index = 0;
        for(int i=0; i < queryPrefix.length(); i++){
            char ch = queryPrefix.charAt(i);
            index = ch-'a';

//if prefix is not present in trie, return list with blank strings
            if(temp.child[index] == null){
                for(int j=0;j<x;j++){
                    outputStrings[j] = "";
                }
                return outputStrings;
            }
            else{
                temp = temp.child[index];
            }
        }

// If strict prefix is not present in trie, returning list with blank strings
        if(temp==null){
            for(int j=0; j<x; j++){
                outputStrings[j] = "";
            }
            return outputStrings;
        }
        int k=0;
        int listSize = temp.list.size()-1;
        while(k<x && listSize>=0){
            outputStrings[k]=temp.list.get(listSize).string;
            listSize--;
            k++;
        }

//Adding blank string if found strings are less than x
        while(k<x){
            outputStrings[k] = "";
            k++;
        }
        Arrays.sort(outputStrings);   //finally sending the sorted output
        return outputStrings;
    }



    public void incrementSearchTermFrequency(String search_term, int increment){

        insert(search_term,increment);
    }
    public String[] findTopXSuggestion(String queryPrefix, int X) {
        return find(queryPrefix,X);

    }
};