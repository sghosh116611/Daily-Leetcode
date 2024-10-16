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
        int n = 0;
        for(ListNode temp = head; temp != null; temp = temp.next)
            n++;

        k %= n;

        for(int i = 1; i <= k; i++){
            ListNode temp = head;
            while(temp.next != null && temp.next.next != null){
                temp = temp.next;
            }
            ListNode last = temp.next;
            temp.next = null;

            last.next = head;
            head = last;
        }

        return head;
    }
}