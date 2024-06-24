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
        Stack<Integer> stack = new Stack<>();

        ListNode current1 = head, current2 = head;

        while(current1 != null){
            stack.push(current1.val);
            current1 = current1.next;
        }

        while(current2 != null){
            if(stack.pop() != current2.val)
                return false;
            current2 = current2.next;
        }
        return true;
    }
}