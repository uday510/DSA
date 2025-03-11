package amzn.oa;

import java.util.HashMap;
import java.util.Map;

public class LongestSelfContainedSubstring {

    public static void main(String[] args) {

        String s = "abba";
        System.out.println(maxSubstringLength(s));

    }

    public static int maxSubstringLength(String s) {
        int[] arr = new int[26];
        for(char c: s.toCharArray()) arr[c-'a']++;

        int maxLen = -1;
        for(int k = 1; k <= 26; k++){
            int validCnt = 0;
            Map<Character,Integer> map = new HashMap<>();
            int L = 0, R = 0;
            for(; R < s.length(); R++){
                char curr = s.charAt(R);
                map.put(curr, map.containsKey(curr) ? map.get(curr)+1 : 1);
                while(map.size() > k){
                    char last = s.charAt(L++);
                    map.put(last, map.get(last)-1);
                    if(map.get(last) == arr[last-'a']-1) validCnt--;
                    if(map.get(last) == 0) map.remove(last);
                }
                if(map.get(curr) == arr[curr-'a']) validCnt++;
                if(map.size() == validCnt && (R-L+1 < s.length())) maxLen = Math.max(maxLen, R-L+1);
            }
        }

        return maxLen;
    }
}
