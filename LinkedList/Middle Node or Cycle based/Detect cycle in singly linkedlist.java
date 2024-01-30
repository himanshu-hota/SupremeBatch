public class Solution {
    // Method to check if a linked list has a cycle
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; // Initialize slow pointer to head
        ListNode fast = head; // Initialize fast pointer to head

        // Traverse the list with two pointers: fast moves twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step forward
            fast = fast.next.next; // Move fast pointer two steps forward
            if (slow == fast) // If slow and fast meet, there is a cycle
                return true; // Return true
        }

        return false; // If fast reaches the end of the list, there is no cycle
    }
}


Logic : logic used in the question is same as "Find middle of the linkedList"

Link : https://leetcode.com/problems/middle-of-the-linked-list/description/


Modifications : if(slow == fast) return true;

LeetCode : https://leetcode.com/problems/linked-list-cycle/

CodeStudio : https://www.codingninjas.com/studio/problems/cycle-detection-in-a-singly-linked-list_628974?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM


----------------------- All these questions uses exactly same logic with some Modifications -------------------------

1. Find the middle of the singly linkedList :
https://leetcode.com/problems/middle-of-the-linked-list/description/

2. Detect the cycle in singly linkedlist : 
https://leetcode.com/problems/linked-list-cycle/

3. Detect the cycle in singly linkedlist 2 :
https://leetcode.com/problems/linked-list-cycle-ii/

4. Find the length of the loop : 
https://www.codingninjas.com/studio/problems/find-length-of-loop_8160455?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM