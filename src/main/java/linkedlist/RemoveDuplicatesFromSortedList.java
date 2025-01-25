package linkedlist;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
         ListNode linkedList = new ListNode(10, new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(30, new ListNode(30, new ListNode(40, new ListNode(50))))))));


        ListNode head = solve(linkedList);

        while (head != null) {
            if (head.next == null)
                System.out.print(head.val);
            else System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public static ListNode solve(ListNode head) {
        // O(N) time | O(1) space
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode nextDistinctNode = currentNode.next;
            while (nextDistinctNode != null && currentNode.val == nextDistinctNode.val) {
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
        return head;
    }
}
