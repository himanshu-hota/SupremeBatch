public class Solution {
    public static Node deleteAllOccurrences(Node head, int k) {

        if(head == null) return null;
        if(head.next == null && head.data == k) return null;


        // remove all the occurence of k from the starting point of the linkedlist.
        while(head != null && head.data == k){
            head = head.next;
        }


        // Now process for the rest elements.
        Node curr = head;
        Node prev = curr;

        while(curr != null){
            // if curr's data is k then link prev's next to currr's next
            if(curr.data == k){
                prev.next = curr.next;
                // if curr's next(which is now prev's next) is not null then link it's prev to prev.
                if(prev.next != null){
                    prev.next.prev = prev;
                }
            }

            prev = curr;    
            curr = curr.next;
        }

       
        return head;

    }
}

Steps : 1. If the k occurs in the starting of the linked list then how we can have it's prev ? , so remove skip those nodes or we can say delete thos nodes.
        2. Now process for the rest of the list.
        3. If curr's data is k then link the previous node's next to curr's next node.
        4. Now if then curr's next node is not null then link curr's next node's prev to previous node of curr.
        5. Point prev node to curr and curr node to next.

CodeStudio : https://www.codingninjas.com/studio/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION