package linkedlist;

/**
 * Problem Description
 * You are given A which is the head of a linked list. Print the linked list in space separated manner.
 *
 * Note : The last node value must also be succeeded by a space and after printing the entire list you should print a new line
 *
 *
 *
 * Problem Constraints
 * 1 <= size of linked list <= 105
 *
 * 1 <= value of nodes <= 109
 *
 *
 *
 * Input Format
 * The first argument A is the head of a linked list.
 *
 *
 * Output Format
 * You dont need to return anything
 *
 *
 * Example Input
 * Input 1:
 * A = 1 -> 2 -> 3
 * Input 2:
 * A = 4 -> 3 -> 2 -> 1
 *
 *
 * Example Output
 * Output 1:
 * 1 2 3
 * Output 2:
 * 4 3 2 1
 *
 *
 * Example Explanation
 * For Input 1:
 * We print the given linked list
 * For Input 2:
 * We print the given linked list
 */

public class PrintLinkedList {


    public static void main(String[] args) {

        ListNode head = new ListNode(10);
        ListNode node1 = new ListNode(20);
        ListNode node2 = new ListNode(30);
        ListNode node3 = new ListNode(40);
        ListNode node4 = new ListNode(50);
        ListNode node5 = new ListNode(60);
        ListNode node6 = new ListNode(70);
        ListNode node7 = new ListNode(80);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        solve(head);
    }

    public static void solve(ListNode node) {
        
        ListNode temp = node;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

}
