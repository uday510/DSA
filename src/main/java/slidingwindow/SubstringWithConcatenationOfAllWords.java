package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int window = words[0].length();
        var res = new ArrayList<Integer>();
        int m = words.length;

        var wordCntMap = new HashMap<String, Integer>();
        for (String w : words) wordCntMap.put(w, wordCntMap.getOrDefault(w, 0) + 1);

        for (int i = 0; i < window; i++) {
            int l = i, r = i;
            var curWordCntMap = new HashMap<String, Integer>();
            int curCnt = 0;

            while (r + window <= n) {
                String curStr = s.substring(r, r + window);
                r += window;

                if (!wordCntMap.containsKey(curStr)) {
                    curCnt = 0;
                    curWordCntMap.clear();
                    l = r;
                } else {
                    curWordCntMap.put(curStr, curWordCntMap.getOrDefault(curStr, 0) + 1);
                    ++curCnt;

                    while (curWordCntMap.get(curStr) > wordCntMap.get(curStr)) {
                        String lStr = s.substring(l, l + window);

                        curWordCntMap.put(lStr, curWordCntMap.get(lStr) - 1);
                        l += window;
                        --curCnt;
                    }

                    if (curCnt == m) res.add(l);
                }

            }
        }

        return res;
    }

}
