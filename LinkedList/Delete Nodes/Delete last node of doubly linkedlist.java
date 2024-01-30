public class Solution {
    // Method to delete the last node of a doubly linked list
    public static Node deleteLastNode(Node head) {
        // If the list is empty or has only one node, return null (no nodes left)
        if (head == null || head.next == null) 
            return null;

        // Initialize two pointers, 'curr' to traverse the list and 'prev' to keep track of the previous node
        Node curr = head; // 'curr' points to the head initially
        Node prev = null; // 'prev' is initialized to null since there's no previous node for the head

        // Traverse the list until 'curr' points to the last node
        while (curr.next != null) {
            prev = curr; // Update 'prev' to the current node
            curr = curr.next; // Move 'curr' to the next node
        }

        // After the loop, 'curr' points to the last node
        // Disconnect the last node from the list by updating its previous and next pointers
        curr.prev = null; // Set the previous pointer of the last node to null
        prev.next = null; // Set the next pointer of the second-to-last node to null, effectively removing the last node

        return head; // Return the head of the modified list
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/delete-last-node-of-a-doubly-linked-list_8160469?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM