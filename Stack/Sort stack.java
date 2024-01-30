// Method 1

public class Solution {

    static void insertInOrder(Stack<Integer> stack, int target) {
        if (stack.isEmpty() || stack.peek() <= target) {
            stack.push(target); // If the stack is empty or the top element is less than or equal to the target, push the target onto the stack.
        } else {
            int temp = stack.pop(); // Pop the top element from the stack.
            insertInOrder(stack, target); // Recursively call insertInOrder to insert the target in the correct sorted position.
            stack.push(temp); // Push back the popped element onto the stack.
        }
    }

    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop(); // Pop the top element from the stack.
            sortStack(stack); // Recursively call sortStack to sort the remaining elements in the stack.
            insertInOrder(stack, temp); // Insert the popped element in its correct sorted position within the stack.
        }
    }

}


// Method 2

/**
 * The GfG class provides a method to sort a given stack of integers in ascending order.
 */
class GfG {
 
    public Stack<Integer> sort(Stack<Integer> s) {
        // Create a new stack to hold the sorted elements
        Stack<Integer> st = new Stack<>();
        
        // Iterate through the original stack until it's empty
        while (!s.isEmpty()) {
            // Pop the top element from the original stack
            int peek = s.pop();
            
            // If the new stack is empty or the popped element is greater than its top,
            // push the popped element onto the new stack
            if (st.isEmpty() || peek > st.peek()) {
                st.push(peek);
            } else {
                // If the popped element is less than the top of the new stack,
                // continue popping elements from the new stack and pushing them
                // onto the original stack until the condition is met
                while (!st.isEmpty() && peek < st.peek()) {
                    s.push(st.pop());
                }
                
                // Push the popped element onto the new stack
                st.push(peek);
            }
        }
        
        // Return the sorted stack
        return st;
    }
}



Steps : 1. Idea => Pick an element and put it in its correct position.
        2. How are we doing that ? -> We pick an item from the original stack and put into aux/second stack only if it is smaller than the element on the top of aux/second stack.  
        3. > or < any operator can be used based on ascending or descendin order.

CodeStudio :- https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?leftPanelTab=1

GFG :- https://practice.geeksforgeeks.org/problems/sort-a-stack/1