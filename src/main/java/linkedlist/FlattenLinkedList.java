/**
 * Problem Description
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
 *
 * Pointer to next node in the main list (right pointer)
 * Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
 * You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.
 *
 *
 * Problem Constraints
 * 1 <= Total nodes in the list <= 100000
 *
 * 1 <= Value of node <= 109
 *
 *
 *
 * Input Format
 * The only argument given is head pointer of the doubly linked list.
 *
 *
 *
 * Output Format
 * Return the head pointer of the Flattened list.
 *
 *
 *
 * Example Input
 * Input 1:
 *    3 -> 4 -> 20 -> 20 ->30
 *    |    |    |     |    |
 *    7   11   22    20   31
 *    |              |    |
 *    7              28   39
 *    |              |
 *    8              39
 * Input 2:
 *
 *    2 -> 4
 *    |    |
 *    7    11
 *    |
 *    7
 *
 *
 * Example Output
 * Output 1:
 *
 *  3 -> 4 -> 7 -> 7 -> 8 -> 11 -> 20 -> 20 -> 20 -> 22 -> 28 -> 30 -> 31 -> 39 -> 39
 * Output 2:
 *
 *  2 -> 4 -> 7 -> 7 -> 11
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  The return linked list is the flatten sorted list.
 */
package linkedlist;


public class FlattenLinkedList {
    public static class ListNode {
        int val;
        ListNode right;
        ListNode down;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode right, ListNode down) { this.val = val; this.right = right; this.down = down; }
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(30, null, null);
        ListNode node3 = new ListNode(20, tail, null);
        ListNode node2 = new ListNode(20, node3, null);
        ListNode node1 = new ListNode(6, node2, null);
        ListNode head = new ListNode(3, node1, null);

        head.down =  new ListNode(5, null, null);
        head.down.down = new ListNode(8,null, null);
        head.down.down.down =  new ListNode(8, null, null);

        node1.down = new ListNode(11, null, null);

        node2.down = new ListNode(22, null, null);
        node2.down.down = new ListNode(28, null, null);
        node2.down.down.down = new ListNode(39, null,null);

        node3.down = new ListNode(20, null, null);
        node3.down.down = new ListNode(39, null, null);

        tail.down = new ListNode(31, null, null);
        ListNode ans = solve(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.down;
        }
    }
    public static ListNode solve(ListNode head) {

        if (head == null || head.right == null) return head;
        ListNode currNode = head.right;
        ListNode prevNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.right;
            ListNode sortedHead = merge(prevNode, currNode);
            prevNode = sortedHead;
            sortedHead.right = currNode.right;
            currNode = nextNode;
        }
        return head;
    }
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0, null, null);
        ListNode tail = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.down = l1;
                l1 = l1.down;
            } else {
                tail.down = l2;
                l2 = l2.down;
            }
            tail = tail.down;
        }

        tail.down = l1 == null ? l2: l1;
        return head.down;
    }
}
