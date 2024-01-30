class Solution {
    // Method to find the middle node of a linked list
    public ListNode middleNode(ListNode head) {
        ListNode slow = head; // Initialize slow pointer to head
        ListNode fast = head; // Initialize fast pointer to head

        // Traverse the list with two pointers: fast moves twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step forward
            fast = fast.next.next; // Move fast pointer two steps forward
        }

        return slow; // When fast reaches the end, slow will be at the middle node
    }
}


LeetCode : https://leetcode.com/problems/middle-of-the-linked-list/