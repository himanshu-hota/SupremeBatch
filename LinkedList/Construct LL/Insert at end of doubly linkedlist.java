 
public class Solution
{
    
    public static Node insertAtTail(Node list, int k) {

        // Check if the list is empty, then create a new node as the head
        if(list == null) 
            return new Node(k);

        // Create a temporary pointer to traverse the list
        Node temp = list;

        // Traverse the list to find the current tail
        while(temp.next != null) {
            temp = temp.next;
        }

        // Create a new node with the given value
        Node newTail = new Node(k);

        // Set the previous node of the new tail to the current tail
        newTail.prev = temp;

        // Set the next node of the current tail to the new tail
        temp.next = newTail;

        // Return the head of the doubly linked list after insertion
        return list;
    }
}



CodeStudio : https://codingninjas.com/studio/problems/insert-at-end-of-doubly-linked-list_8160464?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
