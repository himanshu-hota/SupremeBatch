/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node insertAtFirst(Node list, int newValue) {
        
        if(list == null){
            list = new Node(newValue);
            return list;
        }
        
        // create new head.
        Node newHead = new Node(newValue);
        // connect its next to existing list.
        newHead.next = list;
        // connect existing list's prev to curr.
        list.prev = newHead;

        return newHead;
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/insert-node-at-the-beginning_8144739?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

