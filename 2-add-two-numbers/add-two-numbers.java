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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int quo = 0;
        ListNode res = new ListNode();
        ListNode temp = res;
        int carry = 0;

        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(rem);
            temp.next = newNode;
            temp = temp.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sum = l1.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(rem);
            temp.next = newNode;
            temp = temp.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = l2.val + carry;
            int rem = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(rem);
            temp.next = newNode;
            temp = temp.next;
            l2 = l2.next;
        }

        if(carry == 1){
            
            ListNode newNode = new ListNode(carry);
            temp.next = newNode;
        }
        return res.next;
    }
}