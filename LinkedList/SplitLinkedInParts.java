/*
Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.
 */
package LinkedList;

public class SplitLinkedInParts {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        int k = 3; // Number of parts

        ListNode[] result = splitListToParts(head, k);

        // Print the split linked lists
        for (ListNode partHead : result) {
            ListNode current = partHead;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
    public static ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode currNode = head;

        while (currNode != null) {
            ++n;
            currNode = currNode.next;
        }

        ListNode[] res = new ListNode[k];

        int partSize = n / k;
        int extraNodes = n % k;
        currNode = head;


        for (int i = 0; i < k && currNode != null; ++i) {
            res[i] = currNode;

            int len = partSize + (extraNodes > 0 ? 1 : 0);
            extraNodes--;

            for (int j = 1; j < len; ++j) {
                currNode = currNode.next;
            }

            ListNode nextNode = currNode.next;
            currNode.next = null;
            currNode = nextNode;
        }
        return res;
    }
}
