 
public class Solution
{
 
    public static int searchInLinkedList(Node head, int k){

        // Check if the list is empty
        if(head == null) 
            return 0;
        
        // Check if the first node contains the value
        if(head.data == k) 
            return 1;

        // Create a temporary pointer to traverse the list
        Node temp = head;

        // Traverse the list and check for the value
        while(temp != null){
            if(temp.data == k) 
                return 1;
            temp = temp.next;
        }

        // Return 0 if the value is not found
        return 0;
    }
}

CodeStudio : https://www.codingninjas.com/studio/problems/search-in-a-linked-list_975381?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM