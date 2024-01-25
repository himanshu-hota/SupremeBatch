class Compute {
    // Function to find the largest element in the array 'arr'.
    public int largest(int arr[], int n) {
        // If the array is empty, return -1 as there are no elements to find the largest among.
        if (n == 0) {
            return -1;
        }
        
        // Initialize 'max' to the smallest possible integer value to start the comparison.
        int max = Integer.MIN_VALUE;
        
        // Iterate through the array 'arr' to find the largest element.
        for (int x : arr) {
            // Check if the current element 'x' is greater than the current 'max' value.
            if (x > max) {
                // If 'x' is greater, update 'max' to 'x'.
                max = x;
            }
        }
        
        // Return the 'max' value, which is the largest element in the array.
        return max;
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/largest-element-in-array4009/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

Steps :- 1. Initialize a max variable that initially holds int_MIN.
		 2. Go to each element and check whether this element is greater than the max variable, if yes then update it.
		 3. Finally return ans.