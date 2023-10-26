class Compute {
    // Function to find the smallest element in the array 'arr'.
    public int smallest(int arr[], int n) {
        // If the array is empty, return -1 as there are no elements to find the smallest among.
        if (n == 0) {
            return -1;
        }
        
        // Initialize 'min' to the smallest possible integer value to start the comparison.
        int min = Integer.MIN_VALUE;
        
        // Iterate through the array 'arr' to find the smallest element.
        for (int x : arr) {
            // Check if the current element 'x' is smaller than the current 'min' value.
            if (x < min) {
                // If 'x' is greater, update 'mminax' to 'x'.
                min = x;
            }
        }
        
        // Return the 'min' value, which is the smallest element in the array.
        return min;
    }
}


Steps :- 1. Initialize a min variable that initially holds int_MAX.
		 2. Go to each element and check whether this element is greater than the min variable, if yes then update it.
		 3. Finally return ans.
