package twopointer;

public class ReversePrefix {

    public String reversePrefix(String word, char ch) {
      int prefixEndIndex = word.indexOf(ch);

        if(prefixEndIndex == -1) {
            return word;
        }

        char[] wordArray = word.toCharArray();

        int startIndex = 0;
        int endIndex = prefixEndIndex;

        while (endIndex > startIndex) {
            char temp = wordArray[startIndex];
            wordArray[startIndex] = wordArray[endIndex];
            wordArray[endIndex] = temp;

            ++startIndex;
            --endIndex;
        }

        return new String(wordArray);
    }
}
