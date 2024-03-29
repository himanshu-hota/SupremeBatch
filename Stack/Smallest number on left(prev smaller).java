static List<Integer> leftSmaller(int n, int a[]) {
    // Create a list to store the results
    List<Integer> ans = new ArrayList<>();
    
    // Create a stack to store the elements
    Stack<Integer> st = new Stack<>();
    
    // Push -1 as the initial value into the stack
    st.push(-1);
    
    // Iterate over the array
    for (int i = 0; i < n; i++) {
        int curr = a[i]; // Get the current element
        
        // Pop elements from the stack until the top element is greater than or equal to the current element
        while (st.peek() >= curr) {
            st.pop();
        }
        
        // Add the nearest left smaller element to the ans list
        ans.add(st.peek());
        
        // Push the current element into the stack
        st.push(curr);
    }
    
    // Return the ans list
    return ans;
}


Note : 1. Maintain stack for with initial value of -1.
       2. Go to each item in array and remove the all the items from the stack which are equal greaetr than curr element.
       3. Now add the peek of the stack to ans.
       4. Add curr to stack. 

Time complexity :- O(n)

GFG :- https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article