/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;

        ListNode newP1 = headA;
        ListNode newP2 = headB;

        int c1 = 0, c2 = 0;

        while(p1.next != null){
            p1 = p1.next;
            c1++;
        }

        while(p2.next != null){
            p2 = p2.next;
            c2++;
        }

        if(c1 > c2){
            int diff = c1 - c2;
            while(diff-- > 0){
                newP1 = newP1.next;
            }
        }else{
            int diff = c2 - c1;
            while(diff-- > 0){
                newP2 = newP2.next;
            }
        }

        while(newP1 != null && newP2 != null){
            if(newP1 == newP2)
                return newP1;
            newP1 = newP1.next;
            newP2 = newP2.next;
        }

        return null;
    }
}