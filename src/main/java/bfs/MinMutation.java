package bfs;

import java.util.*;

public class MinMutation {
    public static void main(String[] args) {

    }
    public static int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }

        if (bank.length == 0) {
            return -1;
        }

        Set<String> bankSet = createBankSet(bank);
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);

        int minMutation = 0;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            ++minMutation;

            for (int i = 0; i < levelSize; ++i) {
                String gene = queue.poll();

                for (int j = 0; j < gene.length(); ++j) {

                    for (char c : new char[]{'A', 'C', 'G', 'T'}) {

                        StringBuilder sb = new StringBuilder(gene);

                        sb.setCharAt(j, c);

                        String currentGene = sb.toString();

                        if (currentGene.equals(endGene) && bankSet.contains(currentGene)) {
                            return minMutation;
                        }

                        if (visited.contains(currentGene)) {
                            continue;
                        }

                        visited.add(currentGene);

                        if (bankSet.contains(currentGene)) {
                            queue.offer(currentGene);
                        }
                    }
                }
            }
        }
        return -1;
    }
    private static Set<String> createBankSet(String[] bank) {

        return new HashSet<>(Arrays.asList(bank));
    }
}
