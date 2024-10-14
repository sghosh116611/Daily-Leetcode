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
    public boolean isPalindrome(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode temp = head;

        while(temp != null){
            ListNode node = new ListNode(temp.val);
            node.next = newHead.next;

            newHead.next = node;

            temp = temp.next;
        }

        newHead = newHead.next;

        System.out.println(newHead.val);

        ListNode p1 = head, p2 = newHead;
        while(p1 != null && p2 != null){
            if(p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}