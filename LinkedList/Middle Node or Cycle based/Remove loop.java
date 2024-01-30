// Method 1

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        Node slow = head;
        Node fast = head;
        Node prev = null; // Initialize prev to null
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                slow = head;
                while(slow != fast){
                    prev = fast; // Update prev
                    slow = slow.next;
                    fast = fast.next;
                }
                // Handle case when loop starts at head
                if (prev != null) {
                    prev.next = null;
                } else {
                    // If prev is null, the loop starts at head
                    // Set the last node's next to null
                    Node last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    last.next = null;
                }
                return;
            }
        }
    }
}


// GFG variant

public static void removeLoop(Node head){
        
        Node slow = head;
        Node fast = head;
        boolean loopExists = false;
        
        
        // check for loop
        while(fast != null && fast.next != null){
            
            fast = fast.next.next;
            slow = slow.next;
            
            if(slow == fast){
                loopExists = true;
                break;
            }
        }
        
        
        if(loopExists){
            // reset slow to head
            slow = head;
            
            // if slow and fast are still same then it means loop exists at the starting of ll.
            if(slow == fast){
                // loop until the next of fast points to the slow/head node.
                while(fast.next != slow){
                    fast = fast.next;
                }
                
                // unlink 
                fast.next = null;
            }else{
                
                // loop till the next of both slow and fast are same
                // by doing this we stand at the node just before the start of the start of loop.
                while(slow.next != fast.next){
                    slow = slow.next;
                    fast = fast.next;
                }
                
                fast.next  = null;
            }
        }
        
    }

Steps : 1. First check if loop exists or not.
        2. Reset the slow pointer to head to find the starting point of loop.
        3. If the head itself is the starting point the currently the slow and fast both would be at head.
        4. If head is the starting point then keep moving the fast until its next pointer points to the slow/head ponter. and now remove the loop by marking fast.next = null.
        5. If head is not the starting point then find from where the loop starts, by moving both pointer one step ahead each time and when they meet(simply means points to the same node). break the loop and now remove the loop by marking fast/slow.next = null.


CodeStudio :- https://www.codingninjas.com/codestudio/problems/interview-shuriken-42-detect-and-remove-loop_241049?leftPanelTab=0

GFG :- https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1