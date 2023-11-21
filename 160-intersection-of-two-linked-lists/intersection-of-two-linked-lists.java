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
        int c1 = 0, c2 = 0;
        ListNode p = headA;
        ListNode q = headB;

        ListNode intersection = null;

        while(p != null){
            c1++;
            p = p.next;
        }

        while(q != null){
            c2++;
            q = q.next;
        }

        if(c1 > c2){
            intersection = findIntersection(headA,headB,c1-c2);
        }else{
            intersection = findIntersection(headB,headA,c2-c1);
        }

        return intersection;
    }

    private ListNode findIntersection(ListNode headA, ListNode headB, int diff){
        ListNode p = headA, q = headB;

        while(diff != 0 && p != null){
            p = p.next;
            diff--;
        }

        while(p != null && q != null){
            if(p == q)
                return p;
            p = p.next;
            q = q.next;
        }

        return null;
    }
}