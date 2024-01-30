class Solution {

    // Helper function to find the length of the linked list
    public int findLen(ListNode head){
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            curr = curr.next;
            count++;
        }
        return count;
    }

    // Main function to rotate the linked list to the right by k positions
    public ListNode rotateRight(ListNode head, int k) {
        
        // If the list is empty, has only one node, or rotation count is 0, return the list as it is
        if(head == null || head.next == null || k == 0) return head;

        // Find the length of the linked list
        int n = findLen(head);
        
        // If k is greater than the length of the list, take the modulus to avoid unnecessary rotations
        if(k > n) k = k%n;

        // If k becomes equal to the length of the list or 0, no rotation is needed, return the list as it is
        if(k == n || k == 0) return head;

        // Calculate the position of the node to which we need to rotate
        int nodeToGo = n - k;

        // Initialize variables to traverse the list
        int i = 0;
        ListNode prev = null;
        ListNode curr = head;

        // Traverse till the node just before the node to which we need to rotate
        while( i < nodeToGo && curr != null){
            i++;
            prev = curr;
            curr = curr.next;
        }

        // Disconnect the list from the node just before the rotation point
        prev.next = null;
        
        // Save the node to which the list has been rotated (the kth node from the beginning)
        ListNode kthNode = curr;

        // Traverse to the end of the rotated list to get the last node
        while(kthNode.next != null) kthNode = kthNode.next;

        // Connect the last node to the beginning of the original list to complete the rotation
        kthNode.next = head;

        // Return the head of the rotated list
        return curr;
    }
}


Note : 1. curr stans at n-kth node and pre stands at just before n-kth node.
       2. We have to point prev to null and last node to head. 

LeetCode :- https://leetcode.com/problems/rotate-list/description/

CodeStudio : https://www.codingninjas.com/studio/problems/rotate-linked-list_920454?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION