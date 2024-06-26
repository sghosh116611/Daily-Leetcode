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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode c1 = head;
        int count = 0;

        while(c1 != null){
            count++;
            c1 = c1.next;
        }

        System.out.println(count);
        k %= count;
        
        if(k == 0)
            return head;
        
        ListNode p = head, q = head;
        
        while(k != 0){
            q = q.next;
            k--;
        }

        while(q.next != null){
            p = p.next;
            q = q.next;
        }

        ListNode newHead = p.next;
        q.next = head;
        p.next = null;
        head = newHead;

        return head;
    }
}