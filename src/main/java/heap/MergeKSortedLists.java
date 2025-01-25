package heap;

class ListNode {

    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = 	next; }
}
public class MergeKSortedLists {
    public static void main(String[] args) {

    }
    public static ListNode solve(ListNode[] lists) {

        // Using Merge Algorithm : O(NLogK) time | O(1) space where K is
        // Number of Lists, N is the Number of Nodes

        int nodes = lists.length;
        int interval = 1;

        while (interval < nodes) {
            for (int i = 0; i < nodes - interval; i += interval*2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return nodes > 0  ? lists[0]: null;


        // Brute Force : O(NLogN) time | O(N) space
//        List<Integer> nodes = new ArrayList<>();
//        ListNode head = new ListNode(0);
//        ListNode point = new ListNode(0);
//
//        for (ListNode l : lists) {
//            while (l != null) {
//                nodes.add(l.val);
//                l = l.next;
//            }
//        }
//
//        Collections.sort(nodes);
//
//        for (int node : nodes) {
//            point.next = new ListNode(node);
//            point = point.next;
//        }
//        return head.next;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}
