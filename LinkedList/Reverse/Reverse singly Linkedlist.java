 

class Solution {
  
    public ListNode reverseList(ListNode head) {
        // Check if the list is empty or contains only one node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null; // Points to the previous node during reversal
        ListNode curr = head; // Points to the current node being processed

        while (curr != null) {
            ListNode next = curr.next; // Save the reference to the next node
            curr.next = prev; // Reverse the link of the current node
            prev = curr; // Move to the next node in the reversed list
            curr = next; // Move to the next node in the original list
        }

        // The previous node after the traversal is the new head of the reversed list
        return prev;
    }
}


// recursive 

public ListNode reverse(ListNode prev, ListNode curr){
        if(curr == null) return prev;

        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = reverse(prev, next);

        return curr;
}

LeetCode : https://leetcode.com/problems/reverse-linked-list/

CodeStudio : https://www.codingninjas.com/studio/problems/reverse-linked-list_920513?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf