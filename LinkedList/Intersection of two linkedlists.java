// Method 1

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        Map<Integer,ListNode> map = new HashMap<>();

        ListNode head1 = headA;
        ListNode head2 = headB;

        // hash all the nodes of first list
        while(head1 != null){
            map.put(head1.val, map.getOrDefault(head1.val,head1));
            head1 = head1.next;
        }

        // check one by one which node is already present in the map, that is the intersection point.
        while(head2 != null){
            if(map.getOrDefault(head2.val,null) == head2) return head2;
            head2 = head2.next;
        }

        // if we reach till here then no intersection was found.
        return null;

    }
}

// Method 2

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
        return null;
    }

    ListNode a = headA;
    ListNode b = headB;

    // this loop terminates only when the value of a and b are same
    // either both are null
    // or both holds the same value
    while (a != b) {
        a = (a == null) ? headB : a.next;
        b = (b == null) ? headA : b.next;
    }

    return a;
}

LeetCode :- https://leetcode.com/problems/intersection-of-two-linked-lists/description/

CodeStudio :- https://www.codingninjas.com/codestudio/problems/intersection-of-linked-list_630457?leftPanelTab=1

GFG :- https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article