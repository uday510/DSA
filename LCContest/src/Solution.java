import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 1, 2, 55, 14};

        System.out.println(solve(arr));
    }

     // Array : [1, 3, 4, 1, 2, 55, 14]
     //  21, 59
     //

    public static int solve(int[] arr) {
        int N = arr.length;
        // O(N) time | O(N) space
        int[] dp = new int[N];

        dp[0] = arr[0];
        dp[1] = arr[1];

        for (int i = 2; i < N; ++i) {
           dp[i] = Math.max(arr[i-1], dp[i-2] + arr[i]);
        }
        return Math.max(dp[N-1], dp[N-2]);
    }

    /*
    A -> Atomicity
    C -> Con
     */

    // CAP -->

    // K LINKED-LISTS

    // 1->2->3, 5->7->8->9,  2->3->4, 3->4->5, 4->5->6, 5->6->6->6,

    // N is the max size

    //result :  1->2->2->3->3->4->4->5

    // O(N) time } O(1)


    public ListNode merge(ListNode[] nodes) {

//        PriorityQueue<ListNode> pq = new PriorityQueue<>((prev, curr) -> prev.val - curr.val);
//        ListNode head = new ListNode(0);
//
        int K = nodes.length;
//
//        // O(K*(NlogN))  time
//        // O(N) max len of any linked-list
//        for (int i = 0; i < K;) {
//            ListNode currList = nodes[i];
//            while (currList != null) {
//                pq.offer(currList);
//                currList = currList.next;
//            }
//            K+=1;
//        }
//
//        while (!pq.isEmpty()) {
//            head.next = pq.poll();
//            head = head.next;
//        }
//        return head.next;


        ListNode head = new ListNode(0);
        head.next = nodes[0];
        ListNode currList = head.next;

        for (int i = 1; i < K;) {
//            currList.next =  merge(currList, nodes[i]);
            currList = currList.next;
            K+=1;
        }
        return currList.next;
    }

    // 1->2->3,  5->7->8->9,

    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
            next = null;
        }
        ListNode(ListNode next, int val) {
            this.next = next;
            this.val = val;
        }
    }
}