/**
 * Given the head of a linked list
 * and an integer val,
 * remove all the nodes of the
 * linked list that has Node.val == val,
 * and return the new head.
 */

package linkedlist;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));

        ListNode ans = solve(head, 6);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public static ListNode solve(ListNode head, int val) {
        // O(N) time | O(1) space
        ListNode tempNode = new ListNode();
        tempNode.next = head;

        ListNode prevNode = tempNode;
        ListNode currNode = head;

        while (currNode != null) {
            if (currNode.val == val) {
                prevNode.next = currNode.next;
            } else {
//                prevNode = prevNode.next;
                prevNode = currNode;
            }
            currNode = currNode.next;
        }
        return tempNode.next;
    }
}
