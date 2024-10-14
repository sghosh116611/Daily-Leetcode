/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode p1 = head, p2 = head;
        while(p2.next != null && p2.next.next != null){
            p2 = p2.next.next;
            p1 = p1.next;
            if(p2 == p1)
                return true;
        }
        return false;
    }
}