 
public class Solution {
 
    public static Node deleteLast(Node list){
        // Check if the list is empty or has only one node
        if(list.next == null) 
            return list;

        // Create a temporary pointer to traverse the list
        Node temp = list;

        // Traverse the list until the second-to-last node
        while( temp.next.next != null){
            temp = temp.next;
        }

        // Remove the reference to the last node, effectively deleting it
        temp.next = null;

        // Return the head of the modified linked list
        return list;
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/delete-node-of-linked-list_8160463?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
