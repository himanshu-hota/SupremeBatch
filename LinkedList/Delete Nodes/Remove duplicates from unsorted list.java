import java.util.HashSet;

public class Solution {
	
    // Function to remove duplicate elements from a singly linked list
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {

        // Initialize a dummy node as the head of the resulting linked list
        LinkedListNode<Integer> ansHead = new LinkedListNode<>(-1);
        // Pointer to keep track of the tail of the resulting linked list
        LinkedListNode<Integer> ansTail = ansHead;

        // HashSet to store unique elements encountered
        HashSet<Integer> set = new HashSet<>();
        // Pointer to traverse the original linked list
        LinkedListNode<Integer> curr = head;
        
        // Iterate through the original linked list
        while(curr != null){
            // If the current element is not in the set, it's unique
            if(!set.contains(curr.data)){
                // Add it to the set
                set.add(curr.data);
                // Connect it to the tail of the resulting list
                ansTail.next = curr;
                ansTail = ansTail.next;
            }

            // Move to the next element in the original list
            curr = curr.next;
        }

        // Set the next pointer of the last node to null to terminate the resulting list
        ansTail.next = null;

        // Return the resulting list, excluding the dummy node
        return ansHead.next;
	}
}


LeetCode :- https://www.codingninjas.com/codestudio/problems/remove-duplicates-from-unsorted-linked-list_1069331
