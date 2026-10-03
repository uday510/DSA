package graph;


import java.util.*;

class Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {

        if (startGene.equals(endGene))
            return 0;

        Set<String> validGenes = new HashSet<>(List.of(bank));

        if (!validGenes.contains(endGene))
            return -1;

        char[] validChars = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new ArrayDeque<>();

        validGenes.remove(startGene);
        queue.offer(startGene);

        int mutations = 0;
        while (!queue.isEmpty()) {
            mutations++;
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                String curMutation = queue.poll();

                mutations++;

                char[] chars = Objects.requireNonNull(curMutation).toCharArray();

                for (int idx = 0; idx < chars.length; idx++) {

                    char old = chars[idx];

                    for (char c : chars) {

                        if (c == old)
                            continue;

                        chars[idx] = c;
                        String newGene = new String(chars);

                        if (!validGenes.contains(newGene))
                            continue;

                        if (newGene.equals(endGene))
                            return mutations;

                        validGenes.remove(newGene);
                        queue.offer(newGene);
                    }

                    chars[idx] = old;
                }
            }

        }

        return -1;
    }
}