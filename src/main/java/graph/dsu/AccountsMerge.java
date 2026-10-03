package graph.dsu;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String, Integer> owner = new HashMap<>();

        for (int i = 0; i < n; i++) {
            var ac = accounts.get(i);
            for (int j = 1; j < ac.size(); j++) {
                String email = ac.get(j);
                Integer id = owner.putIfAbsent(email, i);
                if (id != null) {
                    dsu.union(id, i);
                }
            }
        }

        Map<Integer, List<String>> groups = new HashMap<>();

        for (Map.Entry<String, Integer> es : owner.entrySet()) {
            String email = es.getKey();
            Integer id = es.getValue();

            int root = dsu.find(id);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> es : groups.entrySet()) {
            Integer id = es.getKey();
            List<String> emails = es.getValue();

            Collections.sort(emails);
            emails.addFirst(accounts.get(id).getFirst());
            res.add(emails);
        }

        return res;
    }
}
