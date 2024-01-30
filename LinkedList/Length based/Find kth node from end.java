class Solution {
    // Method to find the length of the linked list
    int findLen(Node head) {
        Node curr = head; // Initialize a current pointer to the head of the list
        int len = 0; // Initialize length counter

        // Traverse the linked list and count nodes
        while (curr != null) {
            len++; // Increment length counter
            curr = curr.next; // Move to the next node
        }

        return len; // Return the length of the linked list
    }

    // Method to get the Nth node from the end of the linked list
    int getNthFromLast(Node head, int n) {
        int len = findLen(head); // Get the length of the linked list

        // If the value of n is greater than the length of the list, return -1
        if (n > len)
            return -1;

        int toFind = len - n; // Calculate the position of the node to be found from the beginning

        int count = 0; // Initialize a counter to track the current position
        Node curr = head; // Initialize a current pointer to the head of the list

        // Traverse the list until the desired position is reached
        while (curr != null && count < toFind) {
            count++; // Increment the counter
            curr = curr.next; // Move to the next node
        }

        return curr.data; // Return the data of the node found at the Nth position from the end
    }
}



GFG :- https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article