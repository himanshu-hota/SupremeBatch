// Method 1

class Solution{
    
    // Method to find the length of the linked list
    static int findLen(Node head){
        if(head == null) return 0; // If head is null, the length is 0
        
        Node curr = head;
        int len = 0; // Initialize length counter
        
        // Traverse the linked list and count nodes
        while(curr != null){
            len++;
            curr = curr.next;
        }
        
        return len; // Return the length of the linked list
    }
    
    // Method to delete nodes from a linked list in groups of M nodes skipped by N nodes
    static void linkdelete(Node head, int M, int N){
        
        int len = findLen(head); // Get the length of the linked list
        
        if(M >= len) return; // If M is greater than or equal to the length, no deletion required
        
        Node curr = head; // Current pointer initialized to head
        Node prev = null; // Previous pointer initialized to null
        
        int i = 0;
        
        // Traverse M nodes
        while(i < M && curr != null){
            i++;
            prev = curr; // Update previous pointer
            curr = curr.next; // Move current pointer
        }
        
        i = 0;
        
        // Traverse N nodes to skip
        while(curr != null && i < N){
            curr = curr.next; // Move current pointer
            i++;
        }
        
        prev.next = curr; // Link previous node to the current node
        
        // Recursively call the function for the remaining list
        linkdelete(curr, M, N);
    }
}


// Method 2

static void linkdelete(Node head, int M, int N) {
    // Check if the head is null, indicating an empty list
    if (head == null) return;

    Node curr = head;
    int count = 1;
    // Traverse to the Mth node
    while (curr != null && count < M) {
        curr = curr.next;
        count++;
    }

    // If we reached the end of the list before finding the Mth node, return
    if (curr == null) return;
    Node MthNode = curr;
    curr = curr.next;

    count = 0;
    // Traverse N nodes from the Mth node and delete them
    while (curr != null && count < N) {
        curr = curr.next;
        count++;
    }

    // Link the Mth node to the node after the deleted nodes
    MthNode.next = curr;

    // Perform garbage collection to free up memory
    System.gc();

    // Recursively call linkdelete with the updated current node and continue deleting nodes
    linkdelete(curr, M, N);
}


Special Note : 1. Question says to delete N nodes after each M nodes till last of the linkedlist.
               2. Recursion lagana padega bhai aage ke nodes k liye.

Steps : 1. Skip M-1 nodes,and stand at mth node, now make sure that there are remaining nodes to delete, if no nodes available then return. (why skip m-1 nodes ? --> because deletion will be done from mth+1 node so we need the mth node to link it with the nodes after deletion).
        2. Store the pointer of the mth node. and move the curr pointer one step ahead (VVIMP mat bhulna). (why moving one step ahead ? --> because we want deletion from mth+1 node).
        3. Now delete N nodes.
        4. Link the mth node pointer with curr pointer to link them together.
        5. Recursive call for remaining nodes. (this is VVIMP dont forget to make recursive call).



GFG :- https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article