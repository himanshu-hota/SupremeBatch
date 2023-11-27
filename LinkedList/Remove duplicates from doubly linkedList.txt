// Method 1

class Solution {
    // Function to remove duplicates from a sorted doubly linked list
    // Parameters:
    // - head: the head of the doubly linked list
    // Returns:
    // - The head of the modified linked list with duplicates removed
    Node removeDuplicates(Node head) {
        // Check if the linked list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize pointers for traversal
        Node temp = head;  // Current node being considered
        Node prev = null;  // Previous distinct node

        // Iterate through the linked list
        while (temp != null) {
            // Check for duplicate nodes
            if (prev != null && prev.data == temp.data) {
                // Skip all consecutive duplicate nodes
                while (temp != null && temp.data == prev.data) {
                    temp = temp.next;
                }
            }

            // Update pointers to remove duplicates
            if (prev != null) {
                prev.next = temp;
                if (temp != null) {
                    temp.prev = prev;
                }
            }

            // Move pointers to the next distinct node
            if (temp != null) {
                prev = temp;
                temp = temp.next;
            }
        }

        // Return the head of the modified linked list
        return head;
    }
}

// Method 2

class Solution {
    // Method to remove duplicate nodes from a doubly linked list
    // Returns the head of the modified linked list
    Node removeDuplicates(Node head) {
        // Check if the list is empty or has only one element
        if (head == null || head.next == null)
            return head;

        // Initialize a pointer to traverse the linked list
        Node curr = head;

        // Traverse the linked list to remove duplicates
        while (curr != null && curr.next != null) {
            // Check if the current node has the same data as the next node
            if (curr.data == curr.next.data) {
                // Skip the next node by updating the current node's next pointer
                curr.next = curr.next.next;

                // Update the previous pointer of the new next node (if it exists)
                if (curr.next != null) {
                    curr.next.prev = curr;
                }
            } else {
                // Move to the next node if no duplicates are found
                curr = curr.next;
            }
        }

        // Return the head of the modified linked list
        return head;
    }
}

GFG : https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1