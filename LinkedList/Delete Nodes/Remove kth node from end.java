// Method 1

// Class Solution to provide methods for linked list operations
class Solution {

    // Function to find the length of the linked list
    public int findLen(ListNode head) {
        // If head is null, the list is empty, so return length as 0
        if (head == null) return 0;
        
        ListNode curr = head; // Start from the head of the list
        int len = 0; // Initialize length as 0
        
        // Traverse the list and count the number of nodes
        while (curr != null) {
            curr = curr.next; // Move to the next node
            len++; // Increment length
        }

        return len; // Return the length of the list
    }

    // Function to remove the nth node from the end of the linked list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = findLen(head); // Find the length of the list

        // If the list contains only one node and n is 1, remove that node and return null
        if (head.next == null && n == 1) return null;
        
        // If n is greater than the length of the list, no removal needed, return the head
        if (n > len) return head;

        // Calculate the index of the node to delete
        int toDelete = len - n;

        // If the first node needs to be deleted, return the next node as the new head
        if (toDelete == 0) return head.next;

        ListNode curr = head; // Current node initialized to the head
        ListNode prev = null; // Previous node initialized to null

        int i = 0; // Counter for traversing the list

        // Traverse the list until reaching the node to delete
        while (curr != null && i < toDelete) {
            prev = curr; // Update prev to current node
            curr = curr.next; // Move to the next node
            i++; // Increment counter
        }

        // If prev is not null, update its next pointer to skip the node to delete
        if (prev != null) {
            prev.next = curr.next;
        }
        
        return head; // Return the head of the modified list
    }
}

// Method 2

class Solution {

    static int findLen(ListNode head){
        ListNode temp = head;
        int count  =0;
        while(temp != null){
            temp = temp.next;
            count++;
        }

        return count;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        // calculate length of the linkedlist
        int len = findLen(head);

        // if list has only one element and n == 1
        if(len <= 1 && n ==1) return head.next;
        // if it asks to delete first node
        if(len == n) return head.next;
        // if node to delete doesn't exists
        if(n > len) return head;
        
        ListNode curr = head;
        // calculate index of node to delete
        int nodeToDelete = len - n;
        int count = 1;

        // go to 1 node before the nodeToDelete
        while(count < nodeToDelete && curr != null){
            curr = curr.next;
            count++;
        }

        // remove the node
        curr.next = curr.next.next;
     
        // return modified head;
        return head;


    }
}

LeetCode :- https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

CodeStudio :- https://www.codingninjas.com/codestudio/problems/delete-kth-node-from-end-in-linked-list_799912?leftPanelTab=1