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
        
        ListNode p = head;
        ListNode q = head;

        while(p != null && p.next != null && q != null){
            p = p.next.next;
            q = q.next;

            if(p == q)
                return true;
        }

        return false;
    }
}