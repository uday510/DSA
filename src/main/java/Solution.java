import java.util.*;

public class Solution {

    Set<String> validNeighbors;
    public int ladderLength(String st, String en, List<String> wList) {
        validNeighbors = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        validNeighbors.addAll(wList);

        if (!validNeighbors.contains(en)) return -1;

        int level = 0;

        queue.offer(st);
        validNeighbors.remove(st);

        while (!queue.isEmpty()) {
            int n = queue.size();
            level++;
            for (int i = 0; i < n; i++) {
                String cur = queue.poll();

                List<String> neighbours = getNeighbors(cur);
                for (String nei : neighbours) {
                    if (nei.equals(en)) return level;

                    queue.offer(nei);
                }
            }
        }


        return level;
    }

    private List<String> getNeighbors(String s) {
        List<String> list = new ArrayList<>();

        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char originalChar = ch[i];

            for (char cur = 'a'; cur <= 'z'; cur++) {
                ch[i] = cur;

                String nei = new String(ch);

                if (!validNeighbors.contains(nei)) continue;

                validNeighbors.remove(nei);
                list.add(nei);
            }

            ch[i] = originalChar;
        }

        return list;
    }

}

