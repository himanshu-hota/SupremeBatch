class Solution {
    // Function to find the sum of the minimum and maximum elements in the array 'arr'.
    public static int findSum(int arr[], int n) {
        // If the array is empty, return -1 as there are no elements to find the sum for.
        if (n == 0) {
            return -1;
        }
        
        // Initialize 'min' and 'max' to extreme values for comparison.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        // Iterate through the array 'arr' to find the minimum and maximum elements.
        for (int x : arr) {
            // Update 'min' to the smaller value between 'min' and 'x'.
            min = Math.min(min, x);
            // Update 'max' to the larger value between 'max' and 'x'.
            max = Math.max(max, x);
        }
        
        // Return the sum of the minimum and maximum elements in the array.
        return min + max;
    }
}

GFG :- https://practice.geeksforgeeks.org/problems/max-min/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
