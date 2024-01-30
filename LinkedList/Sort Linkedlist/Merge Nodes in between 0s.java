// Method 1

class Solution {
    // Function to merge consecutive nodes with value 0 and replace them with the sum of their values.
    public ListNode mergeNodes(ListNode head) {
        // Initialize previous and current pointers.
        ListNode prev = null; // Points to the node before the current node.
        ListNode curr = head; // Points to the current node being processed.

        // Iterate through the list until the end is reached.
        while (curr.next != null) {
            // If the current node's value is 0, merge it with consecutive 0 nodes.
            if (curr.val == 0) {
                // Temporary pointer to traverse through consecutive 0 nodes.
                ListNode temp = curr.next;
                int sum = 0; // Variable to store the sum of consecutive non-zero node values.

                // Iterate through consecutive non-zero nodes and calculate their sum.
                while (temp != null && temp.val != 0) {
                    sum += temp.val;
                    temp = temp.next;
                }

                // Replace the value of the current node with the sum of consecutive non-zero node values.
                curr.val = sum;
                
                // Update the previous pointer to point to the current node.
                prev = curr;
                
                // Update the next pointer of the current node to skip the merged nodes.
                curr.next = temp;
            }

            // Update the previous and current pointers for the next iteration.
            prev = curr;
            curr = curr.next;
        }

        // Set the next pointer of the last processed node to null to terminate the list.
        prev.next = null;

        // Return the head of the modified list.
        return head;
    }
}


Note : 1. curr != null kyo nahi kiya? kyoki hum chahte hai ki prev wala node n-1th node ko point kare taki last wala node jo 0 hoga usko null kar sake.
       2. curr != null karte to ek bar aur traverse karna padta pura aur fir last wale ko null karna padta.
         


// Method 2

class Solution {
    // Merge nodes with consecutive zero values in a linked list
    public ListNode mergeNodes(ListNode head) {
        
        // Check if the input list is empty
        if(head == null) return head;

        // Initialize pointers for traversal
        ListNode newHead = head;          // Pointer to the current node in the modified list
        ListNode lastNodeOfNewHead = null; // Pointer to the last node in the modified list
        ListNode curr = head.next;         // Pointer to the current node in the original list
        
        int sum = 0; // Variable to store the sum of non-zero values

        // Traverse the original list
        while(curr != null){
            // If the current node's value is zero
            if(curr.val == 0){
                newHead.val = sum;          // Update the value of the current node in the modified list
                sum = 0;                    // Reset the sum for the next sequence of non-zero values
                lastNodeOfNewHead = newHead; // Update the last node pointer
                newHead = newHead.next;      // Move to the next node in the modified list
            }else{
                sum += curr.val;             // Accumulate non-zero values
            }

            curr = curr.next; // Move to the next node in the original list
        }

        // Set the next pointer of the last node in the modified list to null
        lastNodeOfNewHead.next = null;
        
        // Return the head of the modified list
        return head;

    }
}


LeetCode :- https://leetcode.com/problems/merge-nodes-in-between-zeros/description/

CodeStudio :- https://www.codingninjas.com/codestudio/problems/sum-between-zeroes_630463  