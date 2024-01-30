class Solution {
    public Node copyRandomList(Node head) {
        // Step 1: Copy nodes
        Node curr = head;
        while(curr != null){
            // Create a new node with the same value as current node
            Node clone = new Node(curr.val);
            // Insert the cloned node after the current node
            clone.next = curr.next;
            curr.next = clone;
            // Move to the next original node
            curr = clone.next;
        }

        // Step 2: Copy random pointers
        curr = head;
        while(curr != null){
            // Get the cloned node corresponding to current node
            Node clone = curr.next;
            // Set the random pointer of cloned node to the cloned node of random pointer of original node
            clone.random = curr.random == null ? null : curr.random.next;
            // Move to the next original node
            curr = clone.next;
        }

        // Step 3: Detach original and cloned nodes
        curr = head;
        Node ansHead = null; // Head of the new list
        Node ansTail = null; // Tail of the new list
        
        while(curr != null){
            if(ansHead == null){
                // If it's the first node, update head and tail of new list
                ansHead = curr.next;
                ansTail = ansHead;
                // Update next pointer of original node to point to the next original node
                curr.next = ansHead.next;
                // Move to the next original node
                curr = curr.next;
            }else{
                // If it's not the first node, update tail of new list and detach original and cloned nodes
                ansTail.next = curr.next;
                ansTail = ansTail.next;
                curr.next = ansTail.next;
                curr = curr.next;
            }
        }

        // Return the head of the new list
        return ansHead;
    }
}


LeetCode :- https://leetcode.com/problems/copy-list-with-random-pointer/description/

GFG :- https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

CodeStudio :- https://www.codingninjas.com/codestudio/problems/clone-linked-list-with-random-pointer_873376?leftPanelTab=1