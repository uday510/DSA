/**
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 */
package linkedlist;

public class RemoveDuplicatesFromSortedList2 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,
                new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));

        ListNode ans = solve(head);

        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public static ListNode solve(ListNode head) {
        // O(N) time | O(1) space
        ListNode tempNode = new ListNode(0, head);
        ListNode prevNode = tempNode;
        ListNode currNode = head;

        while (currNode != null) {
            // if it's a beginning of duplicates sublist
            // skip all duplicate
            if (currNode.next != null && currNode.val == currNode.next.val) {
                // move till the end of duplicates sublist
                while (currNode.next != null && currNode.val == currNode.next.val) {
                    currNode = currNode.next;
                }
                // skip all duplicates
                prevNode.next = currNode.next;
            } else {
                // otherwise, move prevNode
                prevNode = prevNode.next;
            }
            // move forward
            currNode = currNode.next;
        }
        return tempNode.next;
    }
}
