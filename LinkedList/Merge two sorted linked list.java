public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // If one of the lists is null, return the other list
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    // Create a dummy node to hold the merged list
    ListNode result = new ListNode(-1);
    ListNode resultTail = result;

    // Pointers to the heads of the two lists
    ListNode head1 = list1;
    ListNode head2 = list2;

    // Merge the lists until one of them is exhausted
    while (head1 != null && head2 != null) {
        // Compare the values of the current nodes
        if (head1.val <= head2.val) {
            // If the value in list1 is smaller or equal, append it to the merged list
            resultTail.next = head1;
            resultTail = head1;
            head1 = head1.next;
        } else {
            // If the value in list2 is smaller, append it to the merged list
            resultTail.next = head2;
            resultTail = head2;
            head2 = head2.next;
        }
    }

    // If there are remaining nodes in list1, append them to the merged list
    while (head1 != null) {
        resultTail.next = head1;
        resultTail = head1;
        head1 = head1.next;
    }

    // If there are remaining nodes in list2, append them to the merged list
    while (head2 != null) {
        resultTail.next = head2;
        resultTail = head2;
        head2 = head2.next;
    }

    // Return the merged list by skipping the dummy node
    return result.next;
}


// ------------------------------------------------ RECURSIVE ---------------------------------------------------


class LinkedList
{
    
     static Node merge(Node a, Node b){
        if(a == null) return b;
        if(b == null) return a;
        
        Node ans = null;
        
        if(a.data <= b.data){
            ans = a;
            a.next = merge(a.next,b);
        }else{
            ans = b;
            b.next = merge(a,b.next);
        }
        
        return ans;
    }
    
    //Function to merge two sorted linked list.
    Node sortedMerge(Node list1, Node list2) {
    
    
    Node mergedLL = merge(list1,list2);
    
    return mergedLL;
     
   } 
}


LeetCode :- https://leetcode.com/problems/merge-two-sorted-lists/description/

GFG :- https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article