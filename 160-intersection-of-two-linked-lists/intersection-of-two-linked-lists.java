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
        int l1 = 0, l2 = 0;

        for(ListNode temp = headA; temp != null; temp = temp.next){
            l1++;
        }

        for(ListNode temp = headB; temp != null; temp = temp.next){
            l2++;
        }

        System.out.println(l1 + " " + l2);
        ListNode tempA = headA;
        ListNode tempB = headB;

        if(l1 > l2){
            for(int i = 1; i <= l1 - l2 && tempA != null; tempA = tempA.next, i++);
        }else{
            for(int i = 1; i <= l2 - l1 && tempB != null; tempB = tempB.next, i++);
        }

        System.out.println(tempA.val + " " + tempB.val);

        while(tempA != null && tempB != null){
            if(tempA == tempB)
                return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }
}