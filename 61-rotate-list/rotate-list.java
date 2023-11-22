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
       
        int count = 0;
        ListNode p =head;
        while(p != null){
            count++;
            p = p.next;
        }
        if(count == 0)
            return null;
        k %= count;
        ListNode fast = head;
        ListNode slow = head;
        while(k-- > 0){
            fast = fast.next;
        }

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;

    }
}