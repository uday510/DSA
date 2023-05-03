//package Linear.Linked-lists;
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode () {}
        ListNode (int val) { this.val = val;}
        ListNode (int val, ListNode next) { this.val = val;this.next = next; }
    }
    public static void main(String[] args) {

        ListNode node4 = new ListNode(50, null);
        ListNode node3 = new ListNode(40, node4);
        ListNode node2 = new ListNode(30, node3);
        ListNode node1 = new ListNode(20, node2);
        ListNode head = new ListNode(10, node1);

        ListNode ans = solve(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public static ListNode solve(ListNode head) {
        // O(N) time | O(1) space

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}