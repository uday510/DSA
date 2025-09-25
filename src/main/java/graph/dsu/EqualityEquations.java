package graph.dsu;


// https://leetcode.com/problems/satisfiability-of-equality-equations/?envType=study-plan-v2&envId=graph-theory
public class EqualityEquations {

    public boolean equationsPossible(String[] eqs) {
        UnionFind uf = new UnionFind(26);

        for (String eq : eqs) {
            int i = eq.charAt(0) - 'a', j = eq.charAt(3) - 'a';

            if (isEqual(eq.charAt(1), eq.charAt(2))) {
                uf.union(i, j);
            }
        }

        for (String eq : eqs) {
            int i = eq.charAt(0) - 'a', j = eq.charAt(3) - 'a';

            if (!isEqual(eq.charAt(1), eq.charAt(2))) {
                if (uf.connected(i, j)) return false;
            }
        }

        return true;
    }

    private boolean isEqual(char c1, char c2) {
        return c1 == '=' && c2 == '=';
    }

}
