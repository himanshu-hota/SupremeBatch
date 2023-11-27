public class Solution {
    public static Node sortList(Node head) {
        // Check if the list is empty or contains only one element
        if (head == null || head.next == null)
            return head;

        // Initialize an array to store the count of each element
        int arr[] = {0, 0, 0};

        // Traverse the linked list and count the occurrences of each element
        Node temp = head;
        while (temp != null) {
            arr[temp.data]++;
            temp = temp.next;
        }

        // Reconstruct the linked list in sorted order using the count array
        temp = head;
        int i = 0;
        while (temp != null) {
            if (arr[i] == 0) {
                i++;
            } else {
                // Assign the value of 'i' to the current node
                temp.data = i;
                // Decrease the count of 'i' in the array
                --arr[i];
                temp = temp.next;
            }
        }

        // Return the sorted linked list
        return head;
    }
}


// --------------------------------------- Pointer Approach ------------------------------------------------


public class Solution {
    // Function to sort a linked list containing 0s, 1s, and 2s
    public static Node sortList(Node head) {
        // Create three dummy nodes to represent the heads of three sublists
        Node zHead = new Node(-1); // Head of the sublist containing 0s
        Node oHead = new Node(-1); // Head of the sublist containing 1s
        Node tHead = new Node(-1); // Head of the sublist containing 2s

        // Create three tail pointers for the three sublists
        Node zTail = zHead; // Tail of the sublist containing 0s
        Node oTail = oHead; // Tail of the sublist containing 1s
        Node tTail = tHead; // Tail of the sublist containing 2s

        // Traverse the input linked list
        Node curr = head;

        while (curr != null) {
            // Based on the value of the current node, add it to the appropriate sublist
            if (curr.data == 0) {
                zTail.next = curr;
                zTail = zTail.next;
            } else if (curr.data == 1) {
                oTail.next = curr;
                oTail = oTail.next;
            } else {
                tTail.next = curr;
                tTail = tTail.next;
            }

            // Move to the next node in the input list
            curr = curr.next;
        }

        // Connect the three sublists
        zTail.next = oHead.next;
        oTail.next = tHead.next;
        tTail.next = null;

        // The sorted list starts with the next node of the dummy node for 0s
        return zHead.next;
    }
}




CodeStudio :- https://www.codingninjas.com/codestudio/problems/sort-linked-list-of-0s-1s-2s_1071937?leftPanelTab=1