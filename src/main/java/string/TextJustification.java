package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth));
    }
    private static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> currWords = new ArrayList<>();
        int currLenWithoutSpaces = 0;

        for (String word : words) {
            // If the current line is full, justify the current line
            if (currLenWithoutSpaces + word.length() + currWords.size() > maxWidth) {
                int totalSpaces = maxWidth - currLenWithoutSpaces;
                int gaps = currWords.size() - 1;
                if (gaps == 0) {
                    ans.add(currWords.getFirst() + " ".repeat(totalSpaces));
                } else {
                    int spacesBetweenWords = totalSpaces / gaps;
                    int extraSpaces = totalSpaces % gaps;

                    StringBuilder line = new StringBuilder();
                    for (int i = 0; i < currWords.size(); ++i) {
                        line.append(currWords.get(i));
                        if (i < gaps) {
                            line.append(" ".repeat(spacesBetweenWords));
                            // Add extra space to the leftmost gaps
                            if (i < extraSpaces) {
                                line.append(" ");
                            }
                        }
                    }
                    ans.add(line.toString());
                }
                currWords.clear();
                currLenWithoutSpaces = 0;
            }
            // If the current line is not full, add the word to the current line
            currWords.add(word);
            currLenWithoutSpaces += word.length();
        }

        StringBuilder lastLine = new StringBuilder(String.join(" ", currWords));
        while (lastLine.length() < maxWidth) {
            lastLine.append(" ");
        }

        ans.add(lastLine.toString());
        return ans;
    }
}
