// Method 1

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        // Iterate through the list, reversing pointers
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // Return the new head of the reversed list
    }

    
    public boolean isPalindrome(ListNode head) {
        // Base cases: empty list or single-node list is palindrome
        if(head == null) return false;
        if(head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Find the middle of the list using slow and fast pointers
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // If the list has odd number of nodes, move slow to the next node
        if(fast != null){
            prev = slow;
            slow = slow.next;
        }

        // Split the list into two halves and reverse the second half
        prev.next = null;
        ListNode head1 = head;
        ListNode head2 = reverse(slow);

        // Compare the first half with the reversed second half
        while(head1 != null && head2 != null){
            if(head1.val != head2.val) return false;
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }
}


// Method 2

class Solution {

    // Reverse the given linked list
    public ListNode reverse(ListNode head){

        // If the list is empty or has only one element, return it as it is already reversed
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        // Iterate through the list, reversing the pointers
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // Return the new head of the reversed list
    }

    // Check if a linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        
        // If the list is empty, it can't be a palindrome
        if(head == null) return false;
        
        // If the list has only one element, it is a palindrome
        if(head.next == null) return true;
        
        ListNode slow = head;
        ListNode fast = head.next;

        // Move 'fast' two steps and 'slow' one step, finding the middle of the list
        while(fast != null ){
            fast = fast.next;

            if(fast != null){
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Reverse the second half of the list
        ListNode reversedHalf = reverse(slow.next);

        // Connect the reversed second half to the first half
        slow.next = reversedHalf;

        ListNode head1 = head;       // Pointer for the first half of the original list
        ListNode head2 = slow.next;  // Pointer for the reversed second half of the list

        // Compare values of corresponding nodes in the two halves
        while(head2 != null){
            if(head1.val != head2.val) return false;

            head1 = head1.next;
            head2 = head2.next;
        }

        return true; // If all values match, the list is a palindrome
    }
}


LeetCode :- https://leetcode.com/problems/palindrome-linked-list/description/

CodeStudio : https://www.codingninjas.com/studio/problems/check-if-linked-list-is-palindrome_985248?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM