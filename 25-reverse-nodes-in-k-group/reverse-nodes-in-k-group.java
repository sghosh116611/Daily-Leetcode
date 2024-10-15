/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode start = head;
        ListNode end = head;

        while (true) {
            int count = 0;
            while (count < k && end != null) {
                end = end.next;
                count++;
            }

            if (count < k) {
                break;
            }
            ListNode nextGroupStart = end; 
            ListNode newPrev = reverseList(start, end);

            prevGroupEnd.next = newPrev;

            prevGroupEnd = start;
            start = nextGroupStart;
        }
        prevGroupEnd.next = start;

        return dummy.next;
    }

    private ListNode reverseList(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;

        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; 
    }
}