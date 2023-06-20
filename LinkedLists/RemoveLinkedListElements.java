/**
 * Given the head of a linked list
 * and an integer val,
 * remove all the nodes of the
 * linked list that has Node.val == val,
 * and return the new head.
 */

package LinkedLists;

public class RemoveLinkedListElements {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        ListNode tail = new ListNode(6, null);
        ListNode node5 = new ListNode(5, tail);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);

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
