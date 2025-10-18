package graph.bfs;

import java.util.*;

public class MinimumGeneticMutation {

    public int minMutation(String stGene, String enGene, String[] bank) {
        if (stGene.equals(enGene)) return 0;

        Queue<String> queue = new ArrayDeque<>();
        Set<String> validGenes = new HashSet<>();
        Collections.addAll(validGenes, bank);

        if (!validGenes.contains(enGene)) return -1;
        validGenes.remove(stGene);

        queue.offer(stGene);

        char[] validChars = new char[] {'A', 'C', 'G', 'T'};
        int mts = 0;

        while (!queue.isEmpty()) {
            mts++;
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                String s = queue.poll();
                assert s != null;

                for (int j = 0; j < s.length(); j++) {
                    char[] chars = s.toCharArray();
                    char originalChar = chars[j];

                    for (char ch : validChars) {
                        chars[j] = ch;

                        String gene = new String(chars);
                        if (!validGenes.contains(gene)) continue;

                        if (gene.equals(enGene)) return mts;

                        validGenes.remove(gene);
                        queue.offer(gene);
                    }

                    chars[j] = originalChar;
                }
            }

        }


        return -1;
    }
}
