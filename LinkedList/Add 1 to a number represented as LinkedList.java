// Method 1

class Solution{
    
    public static Node reverse(Node head){
        
        Node prev = null;
        Node curr = head;
        
        while( curr != null ){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public static Node addOne(Node head){ 
        
        // reverse the entire list
        head = reverse(head);;
        Node curr = head;
        
        while(curr != null){
            
            // try to add 1 to the node
            curr.data += 1;
            
            // check if carry is generated or not
            if(curr.data < 10){
                return reverse(head);
            }else{
                curr.data = 0;
            }
            
            // check if we are at last node
            if(curr.next == null){
                break;
            }else{
                curr = curr.next;
            }
            
        }
        
        // if we reach till here then it means we need to manually process for the last digit.
        Node lastDigit = new Node(1);
        curr.next = lastDigit;
        
        // reverse the list to get the correct order.
        return reverse(head);
        
    }
}

// Mehod 2

public static Node addOne(Node head){ 
        
        // reverse the entire list
        head = reverse(head);;
        Node curr = head;
        Node tail = head;
        
        while(curr != null){
            
            // try to add 1 to the node
            curr.data += 1;
            
            // check if carry is generated or not
            if(curr.data < 10){
                return reverse(head);
            }else{
                curr.data = 0;
            }
            
            tail = curr;
            curr = curr.next;
            
            
        }
        
        // if we reach till here then it means we need to manually process for the last digit.
        Node lastDigit = new Node(1);
        tail.next = lastDigit;
        
        // reverse the list to get the correct order.
        return reverse(head);
        
    }

Special Note : 1. VVIMP is that we reverse the entire list and return the pointer to head and then assign the curr to head;
                    head = reverse(head);
               2. If we do like this then it wont be correct
                    curr = reverse(head);
               3. Always reverse the head when returning the ans because we want the entire list to reverse and return the correct ans, if we just return the curr pointer then it wont give us the entire list, and end up returning the wrong answer.     

Stepe : 1. Reverse the entire list.
        2. Loop till the current pointer is not null.
        3. Try to add 1 to the curr node,(as it is the last node because we reversed the list, and it is the node to which we have to add 1).
        4. Check if after adding the value becomes more than 0 -> 9 , which is 10. if no then simply reverse the list and return the ans.
        5. If no then set 0 to current node.
        6. Now check if we are at the last node then break the loop otherwise move to the next node.
        7. If we come out of loop it means that we have to manually take care of the last digit.
        8. Crate a new node with value 1 and append it to the tail of the list (curr.next).
        9. Reverse the list and return the answer.


GFG : https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/0