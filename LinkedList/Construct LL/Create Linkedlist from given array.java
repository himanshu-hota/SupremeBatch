public class Solution {

    // Method to construct a linked list from an integer array
    public static Node constructLL(int[] arr) {
        // If the array is empty, return a single node with value -1
        if (arr.length == 0)
            return new Node(-1);

        // Create the head node with the value of the first element in the array
        Node ansHead = new Node(arr[0]);
        // Initialize the tail node as the head node
        Node ansTail = ansHead;

        // Traverse the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Create a new node with the value of the current element
            Node curr = new Node(arr[i]);
            // Link the current node to the next of the tail node
            ansTail.next = curr;
            // Update the tail node to the current node
            ansTail = ansTail.next;
        }

        // Return the head of the constructed linked list
        return ansHead;
    }
}



CodeStudio : https://www.codingninjas.com/studio/problems/introduction-to-linked-list_8144737?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM