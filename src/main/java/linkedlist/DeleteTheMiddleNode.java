/**
 * You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
 *
 * The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
 *
 * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 */
package linkedlist;

public class DeleteTheMiddleNode {

    public static void main(String[] args) {
        ListNode tail = new ListNode(6, null);
        ListNode node5 = new ListNode(5, tail);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

        ListNode ans = solve(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;

        }
    }
    public static ListNode solve(ListNode head) {
        // O(N) time | O(1) space
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = slow;

        while (fast != null && fast.next != null) {
            slowPrev = slow;
            slow = slow.next;

            fast = fast.next.next;
        }

        slowPrev.next = slowPrev.next.next;

        return head;
    }
}
