public boolean hasCycle(ListNode head) {
    if (head == null) return false; // If the head is null, there is no cycle.

    ListNode slow = head; // Initialize the slow pointer to the head.
    ListNode fast = head.next; // Initialize the fast pointer to the next node of the head.

    while (fast != null && fast.next != null) {
        if (slow == fast) return true; // If the slow and fast pointers meet, there is a cycle.
        slow = slow.next; // Move the slow pointer one step forward.
        fast = fast.next.next; // Move the fast pointer two steps forward.
    }

    return false; // If the loop completes without finding a cycle, return false.
}


GFG :- https://practice.geeksforgeeks.org/problems/circular-linked-list/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

LeetCode :- https://leetcode.com/problems/linked-list-cycle/description/