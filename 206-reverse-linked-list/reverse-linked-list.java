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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, p1 = null, p2 = head;

        while(p2 != null){
            p1 = p2;
            p2 = p1.next;
            p1.next = prev;
            prev = p1;
        }
        return prev;
    }
}