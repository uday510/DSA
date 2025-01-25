package linkedlist;

/**
Problem Description
You are given the head of a linked list A and an integer B, check if there is any node which contains this value B.

Return 1 if such a node is present else return 0.



Problem Constraints
1 <= size of linked list <= 105
1 <= value of nodes <= 109
1 <= B <= 109



Input Format
The first argument A is the head of a linked list.

The second arguement B is an integer.



Output Format
Return 1 if such a node is present otherwise return 0.


Example Input
Input 1:
A = 1 -> 2 -> 3
B = 4
Input 2:
A = 4 -> 3 -> 2 -> 1
B = 4


Example Output
Output 1:
0
Output 2:
1


Example Explanation
For Input 1:
None of the nodes have a value 4.
For Input 2:
The first node has a value 4.
*/

public class SearchInALinkedList {


    public static void main(String[] args) {

        ListNode head = new ListNode(10, new ListNode(20, new ListNode(30, new ListNode(40, new ListNode(50, new ListNode(60))))));

        solve(head, 60);
    }
    public static int solve(ListNode node, int b) {
        ListNode temp = node;

        while (temp != null) {
            if (node.val == b) return 1;
            temp = temp.next;
        }
        return 0;
    }

}
