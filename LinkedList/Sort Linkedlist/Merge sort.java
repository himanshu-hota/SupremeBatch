class Solution {

    // Helper function to find the middle of a linked list
    public ListNode getMiddle(ListNode head) {
        // Base case: if the list is empty or has only one node, return the head
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        // Use two pointers to traverse the list, with one moving twice as fast as the other
        while (fast != null) {
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        // The slow pointer is now at the middle of the list
        return slow;
    }   

    // Recursive function to perform merge sort on a linked list
    public ListNode mergeSort(ListNode head) {
        // Base case: if the list is empty or has only one node, return the head
        if (head == null || head.next == null) return head;

        // Find the middle of the list
        ListNode mid = getMiddle(head);

        // Split the list into two halves
        ListNode head1 = head;
        ListNode head2 = mid.next;
        mid.next = null;

        // Recursively sort the two halves
        ListNode left = mergeSort(head1);
        ListNode right = mergeSort(head2);

        // Merge the sorted halves
        ListNode finalMergedList = merge(left, right);

        // Return the merged and sorted list
        return finalMergedList;
    }

    // Helper function to merge two sorted linked lists
    public ListNode merge(ListNode head1, ListNode head2) {
        // Create a dummy node to represent the merged list
        ListNode mergedList = new ListNode(-1);
        ListNode temp = mergedList;

        // Iterate through both lists and merge them in sorted order
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }   

            temp = temp.next;
        }

        // If one of the lists is not fully processed, append the remaining nodes
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        // The merged list starts from the next of the dummy node
        return mergedList.next;
    }

    // Main function to sort a linked list using merge sort
    public ListNode sortList(ListNode head) {
        // Call the mergeSort function to perform the sorting
        return mergeSort(head);
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

CodeStudio :- https://www.codingninjas.com/codestudio/problems/merge-sort-linked-list_920473?leftPanelTab=1

LeetCode :- https://leetcode.com/problems/sort-list/submissions/703807651/