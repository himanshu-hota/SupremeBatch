public class Solution
{
    // Method to construct a doubly linked list from an array
    public static Node constructDLL(int []arr) {
        
        // Create the head node of the doubly linked list with the value from the first element of the array
        Node ansHead = new Node(arr[0]);
        // Initialize the tail node to the head node initially
        Node ansTail = ansHead;

        // Iterate through the array starting from the second element
        for(int i = 1; i < arr.length; i++){
            // Create a new node with the value from the current element of the array
            Node curr = new Node(arr[i]);
            // Set the previous pointer of the current node to point to the current tail node
            curr.prev = ansTail;
            // Set the next pointer of the current tail node to point to the newly created node
            ansTail.next = curr;
            // Update the tail node to the newly created node
            ansTail = ansTail.next;
        }

        // Return the head node of the constructed doubly linked list
        return ansHead;
    }
}



CodeStudio : https://www.codingninjas.com/studio/problems/introduction-to-doubly-linked-list_8160413?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM