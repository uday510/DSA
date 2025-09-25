package graph.dfs;

import java.util.*;

public class AccountsMerge {

    Map<String, List<String>> adj;
    Set<String> vis;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
            adj = new HashMap<>();
            vis = new HashSet<>();

        for (List<String> act : accounts) {
            String u = act.get(1);

            for (int j = 2; j < act.size(); ++j) {
                String v = act.get(j);

                adj.computeIfAbsent(u, _ -> new ArrayList<>()).add(v);
                adj.computeIfAbsent(v, _ -> new ArrayList<>()).add(u);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (List<String> act : accounts) {
            String name = act.get(0), u = act.get(1);

            if (vis.contains(u)) continue;

            List<String> cur = new ArrayList<>();
            cur.add(name);

            dfs(u, cur);

            Collections.sort(cur.subList(1, cur.size()));

            res.add(cur);
        }


        return res;
    }

    private void dfs(String u, List<String> cur) {
        vis.add(u);
        cur.add(u);

        for (String v : adj.getOrDefault(u, new ArrayList<>())) {
            if (vis.contains(v)) continue;

            dfs(v, cur);
        }
    }

}
