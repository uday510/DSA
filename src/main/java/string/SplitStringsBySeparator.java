package string;

import java.util.ArrayList;
import java.util.List;

public class SplitStringsBySeparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of
                ( "one.two.three",
                  "four.five",
                  "six" ));

        List<String> res = splitWordsBySeparator(list, '.');

        for (String str : res) {
            System.out.println(str);
        }
    }
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {

        List<String> res = new ArrayList<>();

        for (String word : words) {
           int startIdx = 0;
           int endIdx = word.indexOf(separator);

           while (endIdx >= 0) {
               String substring = word.substring(startIdx, endIdx);
               if (!substring.isEmpty()) {
                   res.add(substring);
               }
               startIdx = endIdx + 1;
               endIdx = word.indexOf(separator, startIdx);
           }

           String lastsubstring = word.substring(startIdx);

           if (!lastsubstring.isEmpty()) {
               res.add(lastsubstring);
           }
        }

        return res;
    }
}
