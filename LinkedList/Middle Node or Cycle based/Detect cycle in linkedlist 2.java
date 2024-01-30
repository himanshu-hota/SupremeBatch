// Method 1

public class Solution {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // loop till the fast pointer reaches the end.
        while (fast != null) {
            fast = fast.next;

            if (fast != null) {

                slow = slow.next;
                fast = fast.next;

                // if both are same then this node is in the path that contains the cycle
                if (slow == fast) {
                    // find the starting point here

                    // reset slow to head.
                    slow = head;

                    // move each one step ahead untill they are point to same node.
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }

                    // now slow is standing at the starting point of the loop
                    return slow; // or return fast;
                }

            }
        }

        // if we reach here then no cycle was found.
        return null;
    }
}

// Method 2

public class Solution {
    public ListNode detectCycle(ListNode head) {

        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // loop till the fast pointer reaches the end.
        while(fast != null && fast.next != null)   {
            slow = slow.next;
            fast = fast.next.next;

            // if both are same then this node is in the path that contains the cycle
            if(slow == fast){
                // find the starting point here
                
                // reset slow to head.
                slow = head;

                // move each one step ahead untill they are point to same node.
                while(slow  != fast){
                    slow = slow.next;
                    fast = fast.next;
                }

                // now slow is standing at the starting point of the loop
                return slow; // or return fast;
            }
        }

        // if we reach here then no cycle was found.
        return null;
    }
}

LeetCode : https://leetcode.com/problems/linked-list-cycle-ii/

CodeStudio : https://www.codingninjas.com/studio/problems/detect-the-first-node-of-the-loop_1112628



----------------------- All these questions uses exactly same logic with some Modifications -------------------------

1. Find the middle of the singly linkedList :
https://leetcode.com/problems/middle-of-the-linked-list/description/

2. Detect the cycle in singly linkedlist : 
https://leetcode.com/problems/linked-list-cycle/

3. Detect the cycle in singly linkedlist 2 :
https://leetcode.com/problems/linked-list-cycle-ii/

4. Find the length of the loop : 
https://www.codingninjas.com/studio/problems/find-length-of-loop_8160455?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM