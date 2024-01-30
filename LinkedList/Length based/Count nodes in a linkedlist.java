
public class Solution {

    public static int length(Node head){
        // Check if the list is empty
        if(head == null) 
            return 0;
        
        // Check if the list has only one node
        if(head.next == null) 
            return 1;

        // Create a temporary pointer to traverse the list
        Node temp = head;

        // Initialize length counter
        int len = 0;

        // Traverse the list and count nodes
        while(temp != null){
            len++;
            temp = temp.next;
        }

        // Return the length of the linked list
        return len;
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/count-nodes-of-linked-list_5884?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM