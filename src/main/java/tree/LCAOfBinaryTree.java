package tree;

public class LCAOfBinaryTree {
        public static void main(String[] args) {

            TreeNode node7 = new TreeNode(30, null, null);
            TreeNode node6 = new TreeNode(10, null, null);
            TreeNode node5 = new TreeNode(20, node6, node7);

            TreeNode node3 = new TreeNode(6, null, null);
            TreeNode node2 = new TreeNode(4, null, null);
            TreeNode node1 = new TreeNode(8, node2, node3);

            TreeNode root = new TreeNode(10, null, null);

            root.left = node1;
            root.right = node5;


            int p = 4;
            int q = 6;

            TreeNode ans = solve(root, p, q);

            if (ans == null) System.out.println(ans);
            else System.out.println(ans.val);
        }
        public static TreeNode solve(TreeNode root, int p, int q) {
            if (root == null || root.val == p || root.val == q) {
                return root;
            }

            TreeNode left = solve(root.left, p, q);
            TreeNode right = solve(root.right, p, q);

            // result
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                // both left and right are not null, we found LCA
                return root;
            }
        }
        /**
         * public static int solve(TreeNode root, int p, int q) {
         *             // O(N) time | O(N) space
         *             if (root == null) return 0;
         *
         *             ArrayList<Integer> list1 = new ArrayList<>();
         *             ArrayList<Integer> list2 = new ArrayList<>();
         *
         *             helper(root, p, list1);
         *             helper(root, q, list2);
         *
         *             System.out.println(list1);
         *             System.out.println(list2);
         *
         *             int i = 0, j = 0;
         *             int val = 0;
         *
         *             while (i < list1.size() && j < list2.size()) {
         *
         *                 if (list1.get(i) == list2.get(j)) {
         *                     while (list1.get(i) == list2.get(j)) {
         *                         val = list1.get(i);
         *                         i++;
         *                         j++;
         *                     }
         *                     break;
         *                 }
         *                 i++;
         *                 j++;
         *             }
         *             return val;
         *
         *         }
         *         public static boolean helper(TreeNode root, int k, ArrayList<Integer> arr) {
         *             if (root == null) return false;
         *
         *             // add curr val to list
         *             arr.add(root.val);
         *             if (root.val == k) return true;
         *
         *             if ( helper(root.left, k, arr) || helper(root.right, k, arr) )
         *                 return true;
         *
         *             // remove curr val and return false, as we don't need this value
         *             arr.remove(arr.size() - 1);
         *             return false;
         *         }
         */
}
