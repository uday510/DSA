package tree;

import java.util.ArrayList;

public class LCAOfBinaryTree3 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
    public static void main(String[] args) {
    }
    public static Node solve(Node p, Node q) {
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();

        getValues(p, list1);
        getValues(q, list2);


       int i = 0, j = 0;
       Node ans = null;

       while (i < list1.size() && j < list2.size()) {
           if (list1.get(i).val == list2.get(j).val) {
               ans = list2.get(j);
           }
           i++;
           j++;
       }

        return ans;
    }
    public static void getValues(Node node, ArrayList<Node> list) {
        if (node == null) return;

        list.add(node);
        getValues(node.left, list);
        getValues(node.right, list);
    }
}
