// Method 1

class Solution {
    // Function to delete duplicate elements from a sorted linked list
    public ListNode deleteDuplicates(ListNode head) {
        
        // Initialize a dummy node as the head of the resulting linked list
        ListNode ansHead = new ListNode(-1);
        // Pointer to keep track of the tail of the resulting linked list
        ListNode ansTail = ansHead;

        // Pointer to traverse the original linked list
        ListNode curr = head;

        // Iterate through the original linked list
        while(curr != null){
            // Move curr to the last node with the same value
            while(curr.next != null && curr.val == curr.next.val) 
                curr = curr.next;
            
            // Connect the tail of the resulting list to the last unique node
            ansTail.next = curr;
            ansTail = ansTail.next;
            
            // Move to the next distinct element in the original list
            curr = curr.next;
        }

        // Return the resulting list, excluding the dummy node
        return ansHead.next;
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1

LeetCode :- https://leetcode.com/problems/remove-duplicates-from-sorted-list/submissions/969410410/












public ListNode deleteDuplicates(ListNode head) {
    // Check if the list is empty or contains only one node
    if(head == null || head.next == null){
         return head;
    }

    // Create a new node 'prev' and set its next to the head of the list
    ListNode prev = new ListNode();
    prev.next = head;
    // Create a current node and initialize it with 'prev'
    ListNode curr = prev;

    // Traverse the list
    while(curr.next != null && curr.next.next != null){
        // Check if current node's value is equal to the next node's value
        if(curr.next.val == curr.next.next.val){
            int value = curr.next.val;
            // Skip all nodes with the same value as 'value'
            while(curr.next != null && curr.next.val == value){
                curr.next = curr.next.next;
            }
        }
        else{
            // Move to the next node
            curr = curr.next;
        }  
    }
    
    // Return the head of the modified list
    return prev.next;
}


LeetCode :- https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/
