// Method 1 

class Solution {

    // Function to add two numbers represented by linked lists
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Check if one of the lists is null
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int sum = 0;
        int carry = 0;

        // Initialize pointers for the result linked list
        ListNode ansHead = null;
        ListNode ansTail = null;

        // Traverse the input lists
        while (l1 != null || l2 != null) {
            sum = carry;

            // Add values of the current nodes
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Extract the digit and carry
            int digit = sum % 10;
            carry = sum / 10;

            // Create a new node with the result digit
            ListNode newNode = new ListNode(digit);

            // Update the result linked list
            if (ansHead == null) {
                ansHead = newNode;
                ansTail = newNode;
            } else {
                ansTail.next = newNode;
                ansTail = newNode;
            }
        }

        // Check if there's a remaining carry
        if (carry > 0) {
            ListNode lastDigit = new ListNode(carry);
            ansTail.next = lastDigit;
            ansTail = lastDigit;
        }

        return ansHead;
    }
}

// Method 2

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        // reverse 
        // l1 = reverse(l1);
        // l2 = reverse(l2);

        ListNode ansHead = null;
        ListNode ansTail = null;

        // add
        int carry = 0;
        int sum = 0;
        while(l1 != null && l2 != null){
            sum = carry + l1.val + l2.val;
            int digit = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(digit);
            if(ansHead == null){
                ansHead = newNode;
                ansTail = newNode; 
            }else{
                ansTail.next = newNode;
                ansTail = newNode;
            }

            l1 = l1.next;
            l2 = l2.next;

        }

        while(l1 != null){
            sum = carry + l1.val;
            int digit = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(digit);
            ansTail.next = newNode;
            ansTail = newNode;
            l1 = l1.next;
        }

        
        while(l2 != null){
            sum = carry + l2.val;
            int digit = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(digit);
            ansTail.next = newNode;
            ansTail = newNode;
            l2 = l2.next;
        }

        while(carry != 0){
            sum = carry ;
            int digit = sum%10;
            carry = sum/10;
            ListNode newNode = new ListNode(digit);
            ansTail.next = newNode;
            ansTail = newNode;
            
        }

        // ansHead = reverse(ansHead);
        return ansHead;
    }
}

LeetCode :- https://leetcode.com/problems/add-two-numbers/description/

GFG :- https://practice.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

CodeStudio : https://www.codingninjas.com/studio/problems/add-two-numbers_1170520?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM