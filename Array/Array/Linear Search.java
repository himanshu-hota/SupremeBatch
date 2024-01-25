class Solution {
    // Function to search for an element 'k' in the array 'arr'.
    public int search(int arr[], int n, int k) {
        // If the array is empty, return -1 as there are no elements to search.
        if (n == 0) {
            return -1;
        }
        
        // Iterate through the array 'arr' to find the position of element 'k'.
        for (int i = 0; i < n; i++) {
            // If the current element 'arr[i]' is equal to 'k', return its position (1-based index).
            if (arr[i] == k) {
                return i + 1;
            }
        }
        
        // If 'k' is not found in the array, return -1 to indicate that it's not present.
        return -1;
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/searching-a-number0324/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

Steps: 1. Go to each index and check whether it has the target , if yes then return index+1 (position).
	   2. If the target is not found then return -1.