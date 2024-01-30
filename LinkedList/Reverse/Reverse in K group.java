
//------------------------------------------------ LeetCode -------------------------------------------------

// Method 1

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null) return head;

        ListNode tail = head;

        for(int i = 0; i < k ; i++){
            if(tail == null) return head;
            tail = tail.next;
        }

        ListNode newHead = reverse(head,tail);

        head.next = reverseKGroup(tail,k);

        return newHead;
    }


    private ListNode reverse(ListNode head, ListNode tail){

        ListNode curr = head;
        ListNode prev = null;
        while(curr != tail){
            
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        return prev;
    }
}

// Method 2

class Solution {

    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null) return  head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int i = 0;

        int len = 0;
        while(curr != null){
            len++;
            curr = curr.next;
        }

        // agar k se kam elements hai to revers mat karo yahi se return kar jao
        if(len < k) return head;

        curr = head;

        // ye wala loop utne elements ko reverse karta hai jitne availabel ho ya 'k' k equal ho.
       while(i  < k && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        // ye kyun? 
        head.next = reverseKGroup(next,k);
        
        // prev hi return karna hai kyoki jab reverse karte hain to prev element hi return karte hain yad karo.
        return prev;
    }
}

// 1->2->3->4  me agar k = '2' ho to  2->1->4->3 aisa hona chahiye.
// dhyan se dekho to pata chalta hai ki aage ka reverse kiya hue nodes ko 1 k aage lagana hai yani ki original head k aage.
        head.next = reverseKGroup(next,k);

LeetCode : https://leetcode.com/problems/reverse-nodes-in-k-group/

//------------------------------------------------ GFG -------------------------------------------------

// Method 1

class Solution
{
    public static Node reverse(Node head, int k)
    {
         if(head == null || head.next == null) return  head;

        Node curr = head;
        Node prev = null;
        Node next = null;
        int i = 0;
     
       // ye wala loop utne elements ko revere karta hai jitne availabel ho ya k elements ho
       while(i  < k && curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        head.next = reverse(next,k);
        
        return prev;
    }
}


// Method 2

class Solution{
    
    
    private static Node reverseX(Node head, Node tail){

        Node curr = head;
        Node prev = null;
        while(curr != tail){
            
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }


        return prev;
    }
    
    public static Node reverse(Node head, int k)
    {
        
         if(head == null || head.next == null) return head;

        Node tail = head;

        // if k exceeds the length of the total nodes then simply make k = length of nodes and reverse it.
        for(int i = 0; i < k ; i++){
            if(tail == null){
                k = i+1;
                break;
            }
            tail = tail.next;
        }

        Node newHead = reverseX(head,tail);

        head.next = reverse(tail,k);

        return newHead;
        
    }
}


Special Note : 1. In the for loop why we are breaking when tail == null ? --> because if k size is greater than the availabel nodes to reverse then simpy reverse the elements that are remaining irrespective of k.

LeetCode edition is different ---> that variant says that if less than k nodes are there then dont reverse anything. but gfg and codestudio variants asks to reverse the remaining elements.


GFG :- https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


//------------------------------------------------ CodeStudio -------------------------------------------------

import java.util.ArrayList;


public class Solution {

    // Helper function to reverse a portion of the linked list
    static Node reverseX(Node head, Node tail) {
        Node curr = head;
        Node prev = null;

        while (curr != tail) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Recursive function to reverse a portion of the linked list based on given indices
    static Node reverse(Node head, int idx, ArrayList<Integer> b) {
        if (head == null || head.next == null || idx >= b.size()) return head;

        int k = b.get(idx);
        Node tail = head;

        for (int i = 0; i < k; i++) {
            if (tail == null) {
                k = i + 1;
                break;
            }
            tail = tail.next;
        }

        Node newHead = reverseX(head, tail);

        head.next = reverse(tail, idx + 1, b);

        return newHead;
    }

    public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
        // this is because we don't want to consider 0 as a block size
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : b) {
            if (i > 0) {
                arr.add(i);
            }
        }

        // Reverse the linked list based on the indices in the 'arr' list
        return reverse(head, 0, arr);
    }
}



CodeStudio :- https://www.codingninjas.com/codestudio/problems/reverse-blocks_763406?leftPanelTab=1