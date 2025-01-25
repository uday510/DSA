/**
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced
 *  binary search tree.
 *
 *  Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5],
 * which represents the shown height balanced BST.
 */
package binarysearchtree;

public class ConvertSortedListToBST {
    private ListNode head;
    public class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public void main(String[] args) {

    }
    public TreeNode solve(ListNode head) {
        /**
         * Algorithm
         *
         * Let's quickly look at a pseudo-code to make the algorithm simple to understand.
         *
         * ➔ function formBst(start, end)
         * ➔      mid = (start + end) / 2
         * ➔      formBst(start, mid - 1)
         * ➔
         * ➔      TreeNode(head.val)
         * ➔      head = head.next
         * ➔
         * ➔      formBst(mid + 1, end)
         * ➔
         * Iterate over the linked list to find out it's length. We will make use of two different pointer variables here to mark the beginning and the end of the list. Let's call them start and end with their initial values being 0 and length - 1 respectively.
         * Remember, we have to simulate the inorder traversal here. We can find out the middle element by using (start + end) / 2. Note that we don't really find out the middle node of the linked list. We just have a variable telling us the index of the middle element. We simply need this to make recursive calls on the two halves.
         * Recurse on the left half by using start, mid - 1 as the starting and ending points.
         * The invariance that we maintain in this algorithm is that whenever we are done building the left half of the BST, the head pointer in the linked list will point to the root node or the middle node (which becomes the root). So, we simply use the current value pointed to by head as the root node and progress the head node by once i.e. head = head.next
         * We recurse on the right hand side using mid + 1, end as the starting and ending points.
         */


        // get the size of the linked list first
        int size = findSize(head);

        this.head = head;

        return convertListToBST(0, size - 1);
    }
    TreeNode convertListToBST(int left, int right) {
        // invalid case
        if (left > right) return null;

        int mid = (left + right) / 2;

        //First step of simulate inorder traversal.
        // Recursively from the left half
        TreeNode leftChild = convertListToBST(left, mid - 1);

        //Once left half is traversed, process the current node
        TreeNode node = new TreeNode(head.val);
        node.left = leftChild;

        //Maintain the invariance mentioned in the algorithm
        this.head = this.head.next;

        // Recurse on the right hand side and form BST out of them
        node.right = convertListToBST(mid + 1, right);
        return node;
    }
    int findSize(ListNode head) {
        ListNode curr = head;
        int len = 0;

        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

}
