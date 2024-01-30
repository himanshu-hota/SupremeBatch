// Method 1

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode ansHead = new ListNode(-1);
        ansHead.next = head;
        ListNode ansTail = ansHead;
        
        while( ansTail.next != null && ansTail.next.next != null){

            if(ansTail.next.val == ansTail.next.next.val){
                int value = ansTail.next.val;
                while(ansTail.next != null && ansTail.next.val == value) ansTail.next = ansTail.next.next;
            }else{
                ansTail = ansTail.next;
            }
        }


        return ansHead.next;

    }
} 

// Method 2

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Check if the head node is null or if there is only one node in the list
        // In such cases, there are no duplicates to remove, so return the head as it is.
        if(head==null || head.next==null){
             return head;
        }

        // Create a dummy node 'prev' and make it point to the head.
        // This is done to handle the case where the head node itself is a duplicate.
        ListNode prev = new ListNode();
        prev.next=head;
        ListNode curr=prev;

        // Traverse the list until there are at least two more nodes available
        while(curr.next!=null && curr.next.next!=null){
            // Check if the current node's value is equal to the value of the next node
            if(curr.next.val==curr.next.next.val){
                int value=curr.next.val;
                // If there are consecutive nodes with the same value, remove them all
                while(curr.next!=null && curr.next.val==value){
                    curr.next=curr.next.next;
                }
            }
            else{
                // If the current node's value is not equal to the value of the next node,
                // move the current pointer to the next node
                curr=curr.next;
            }  
        }
        
        // Return the modified list starting from the next node of the dummy node.
        return prev.next;
    }
}


Special Note : 1. We create a new node to handle the case if the starting point of the ll is duplicate itself.
               2. We update the curr node only when the next is a distinct node (distinct means unique that has no duplicates).
               3. If next of curr and next of next has the same value then 
                    a. Pick the value that is duplicate.
                    b. Keep updating the next of curr until we find the same value. ( most important is that we dont update the curr here, ye galti mat karna).
                    


LeetCode :- https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/