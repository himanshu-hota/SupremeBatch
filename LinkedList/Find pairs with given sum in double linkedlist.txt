class Solution {
    // Function to find pairs with a given sum in a doubly linked list
    // Parameters:
    // - target: the target sum to find
    // - head: the head of the doubly linked list
    // Returns:
    // - ArrayList of ArrayLists containing pairs with the given sum
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        
        // ArrayList to store pairs with the given sum
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        // If the linked list is empty, return an empty result
        if(head == null) return ans;
        
        // Set 'tail' to the last node in the linked list
        Node tail = head;
        while(tail.next != null) tail = tail.next;
        
        // Loop through the linked list until the head value is less than the tail value
        while(head.data < tail.data){
            
            // Calculate the current sum of head and tail values
            int currSum = head.data + tail.data;
            
            // Check if the current sum is equal to the target sum
            if(currSum == target){
                // If equal, add the pair to the result, and move head and tail pointers accordingly
                ans.add(new ArrayList<>(Arrays.asList(head.data, tail.data)));
                head = head.next;
                tail = tail.prev;
            } else if(currSum < target){
                // If the current sum is less than the target, move the head pointer to the next node
                head = head.next;
            } else {
                // If the current sum is greater than the target, move the tail pointer to the previous node
                tail = tail.prev;
            }
        }
        
        // Return the final result
        return ans;
    }
}


GFG : https://practice.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1