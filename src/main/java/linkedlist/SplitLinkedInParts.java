/*
Given the head of a singly linked list and an integer k, split the linked list into k consecutive linked list parts.

The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.

The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.

Return an array of the k parts.
 */
package linkedlist;

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
       ListNode[] result = new ListNode[k];
       int n = getLength(head);
       int width = n / k, rem = n % k;

       ListNode current = head;

         for (int i = 0; i < k; i++) {
              ListNode dummy = new ListNode(0), write = dummy;
              for (int j = 0; j < width + (i < rem ? 1 : 0); j++) {
                    write = write.next = new ListNode(current.val);
                    current = current.next;
              }
              result[i] = dummy.next;
         }
         return result;
    }
    private static int getLength(ListNode head) {
        int currentLength = 0;
        ListNode currentNode = head;

        while (currentNode != null) {
            ++currentLength;
            currentNode = currentNode.next;
        }
        return currentLength;
    }
}
