// Method 1 

class Solution {
    // Method to delete the middle node of a linked list
    public ListNode deleteMiddle(ListNode head) {
        // Check if the list is empty or contains only one node
        if (head == null || head.next == null) 
            return null; // Return null as there is no middle node to delete
        
        ListNode slow = head; // Initialize slow pointer to head
        ListNode fast = head; // Initialize fast pointer to head
        ListNode prev = null; // Initialize prev pointer to null

        // Traverse the list with two pointers: fast moves twice as fast as slow
        while (fast != null && fast.next != null) {
            prev = slow; // Store the previous node of the current slow pointer
            slow = slow.next; // Move slow pointer one step forward
            fast = fast.next.next; // Move fast pointer two steps forward
        }   

        // After the loop, slow is pointing to the middle node
        // If prev is not null, it means there is a node before the middle node
        if (prev != null) {
            prev.next = slow.next; // Skip the middle node by updating the next of the previous node
        }

        return head; // Return the head of the modified linked list
    }
}


// Method 2

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        // if list is null then there is no linkedlist to delelte node at the middle.
        if(head == null) return head;
        // if there is only one element then simply delete this only node and return null.
        if(head.next == null) return null;

        
        ListNode slow = head;
        ListNode fast = head; // fast = head.next gives the error thats why i tried for just head.
        ListNode prev = head;

        // find the middle
        while(fast != null ){
            fast = fast.next;

            if(fast != null){
                prev = slow;
                slow = slow.next;
                fast = fast.next;
            }
        }

        // delete the middle
        prev.next = slow.next;

        return head;
    }
}

Logic : Just maintain a prev to middle node and to delete the middle point the prev's next to middle's next.

LeetCode : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

CodeStudio : https://www.codingninjas.com/studio/problems/delete-middle-node_763267?leftPanelTabValue=PROBLEM

