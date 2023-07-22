package Recursion;

public class SwapsNodesInPairs extends ListNode {

    SwapsNodesInPairs(int x) {
        super(x);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode result = swapPairs(head);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;

        return next;
    }
}
