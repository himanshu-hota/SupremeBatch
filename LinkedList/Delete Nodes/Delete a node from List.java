// LeetCode variant

class Solution {
   
    public void deleteNode(ListNode node) {
        // Initialize current and previous nodes
        ListNode curr = node;
        ListNode prev = null;

        // Traverse the list until the end or the target node
        while (curr != null && curr.next != null) {
            // Copy the value of the next node to the current node
            curr.val = curr.next.val;
            // Move the pointers to the next node
            prev = curr;
            curr = curr.next;
        }

        // Remove the last node from the list
        if (prev != null)
            prev.next = null;
    }
}


// CodeStudio variant


public class Solution {

    // find total nodes in given linkedlist
    static int findLen(Node<Integer> head) {
        Node<Integer> temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

  
    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        // If the position is the head, simply return the next node
        if (pos == 0 && head != null)
            return head.next;

        // Find the length of the linked list
        int len = findLen(head);

        // If the position is greater than or equal to the length, no deletion needed
        if (pos >= len)
            return head;

        int i = 0;
        Node<Integer> prev = null;
        Node<Integer> curr = head;

        // Traverse to the node at the specified position
        while (i < pos && curr != null) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        // Delete the node at the specified position by adjusting pointers
        if (prev != null)
            prev.next = curr.next;

        return head;
    }
}



CodeStudio :- https://www.codingninjas.com/codestudio/problems/delete-node-in-ll_5881?leftPanelTab=0

LeetCode :- https://leetcode.com/problems/delete-node-in-a-linked-list/