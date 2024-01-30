// Iterative (similar to singly list logic)

public class Solution {
    /**
     * Reverses a doubly linked list.
     *
     * @param head The head of the doubly linked list to be reversed.
     * @return The head of the reversed doubly linked list.
     */
    public static Node reverseDLL(Node head) {
        // If the list is empty or has only one node, it's already reversed
        if (head == null || head.next == null) return head;

        // Initialize pointers for traversal
        Node prev = null; // Points to the previous node in the original list
        Node curr = head; // Points to the current node being processed

        // Traverse the list and reverse pointers
        while (curr != null) {
            Node next = curr.next; // Store the next node in the original list
            curr.next = prev; // Reverse the next pointer
            curr.prev = next; // Set the previous pointer to the original next node
            prev = curr; // Move prev pointer to the current node
            curr = next; // Move curr pointer to the next node in the original list
        }

        // After traversal, 'prev' will point to the new head of the reversed list
        return prev;
    }
}

Note : Just this line is addition to code of 'Reverse singly linkedlist' curr.prev = next;

Link : https://leetcode.com/problems/reverse-linked-list/

// recursive

private static Node reverseDLLHelper(Node prev, Node curr) {
        // Base case: if the current node is null, the reversal is complete
        if (curr == null) {
            return prev.prev; // The previous node after the traversal is the new head
        }

        // Swap the next and prev pointers of the current node
        Node next = curr.next;
        curr.next = prev;
        curr.prev = next;

        // Recursive call for the next node in the original list
        return reverseDLLHelper(curr, next);
}

CodeStudio : https://www.codingninjas.com/studio/problems/reverse-a-doubly-linked-list_1116098?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM