// Method 1

public class Solution {
    public static int lengthOfLoop(Node head) {
        if (head == null || head.next == null) return 0;

        Node slow = head;
        Node fast = head.next;

        // loop till fast reaches the end
        while (fast != null) {
            fast = fast.next;

            if (fast != null) {
                slow = slow.next;
                fast = fast.next;

                if (slow == fast) {
                    // now find the length of the loop
                    int len = 1;
                    fast = fast.next; // Move fast to the next node in the loop
                    while (fast != slow) {
                        fast = fast.next;
                        len++;
                    }

                    return len;
                }
            }

        }

        return 0;
    }

}

// Method 2

public class Solution {
    public static int lengthOfLoop(Node head) {
        if (head == null || head.next == null) return 0;

        Node slow = head;
        Node fast = head;

        // loop till fast reaches the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // if any point of time slow and fast are at same node then it means that
            // this node is in the path that contains the loop.
            if (slow == fast) {
                // now find the length of the loop
                int len = 1;
                fast = fast.next; // Move fast to the next node in the loop
                while (fast != slow) {
                    fast = fast.next;
                    len++;
                }

                return len;
            }
        }

        return 0;
    }

}

Special Note : It is very important to move fast one ponter ahead and starting len = 1 when finding the length of the loop, because if we don't move that so the 'while' loop would never run because slow == fast.

CodeStudio : https://www.codingninjas.com/studio/problems/find-length-of-loop_8160455?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM



----------------------- All these questions uses exactly same logic with some Modifications -------------------------

1. Find the middle of the singly linkedList :
https://leetcode.com/problems/middle-of-the-linked-list/description/

2. Detect the cycle in singly linkedlist : 
https://leetcode.com/problems/linked-list-cycle/

3. Detect the cycle in singly linkedlist 2 :
https://leetcode.com/problems/linked-list-cycle-ii/

4. Find the length of the loop : 
https://www.codingninjas.com/studio/problems/find-length-of-loop_8160455?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM



