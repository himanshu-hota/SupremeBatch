class Solution {
    // Function to search and insert the given element in a sorted array
    public int searchInsert(int[] arr, int x) {
        
        int n = arr.length; // Length of the input array
        int start = 0; // Start index for binary search
        int end = n - 1; // End index for binary search
        int lastMax = -1; // Variable to track the last maximum index where arr[lastMax] < x

        // If x is smaller than the first element, insert at the beginning
        if(x < arr[0]) return 0;
        // If x is larger than the last element, insert at the end
        if(x > arr[n-1]) return n;
        
        // Binary search loop
        while(start <= end){
            int mid = start + (end - start)/2; // Calculate the middle index

            // If the middle element is equal to x, return its index
            if(arr[mid] == x){
                return mid;
            }
            // If x is greater than the middle element, search in the right half
            else if(arr[mid] < x){
                start = mid + 1;
            }
            // If x is smaller than the middle element, search in the left half
            else{
                end = mid - 1;
            }
        }

        // If the loop completes, it means x is not present in the array
        // The variable 'start' now represents the position where x should be inserted
        return start;
    }
}

Note : 1. When the loop terminates then the start will be standing at the element just greater than the target.
       2. In other words it is just a normal binary search, just at the end return the start. 



LeetCode : https://leetcode.com/problems/search-insert-position/description/