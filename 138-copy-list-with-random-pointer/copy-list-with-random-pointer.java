/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        // Create copy of nodes in between 
        for(Node temp = head; temp != null;){
            Node newNode = new Node(temp.val);

            Node nextNode = temp.next;
            newNode.next = nextNode;
            temp.next = newNode;

            temp = nextNode;
        }

        // Connect random pointers for the copied nodes
        Node temp1 = head;
        while (temp1 != null) {
            if (temp1.random != null) {
                temp1.next.random = temp1.random.next;
            }
            temp1 = temp1.next.next; 
        }

        // Creating deep copy - Connect next nodes in orignal and copy ll
        Node original = head;
        Node copy = head.next;
        Node copyHead = copy;

        while (original != null) {
            original.next = original.next.next;  
            if (copy.next != null) {
                copy.next = copy.next.next;  
            }
            original = original.next;
            copy = copy.next;
        }

        return copyHead;
    }
}