class Solution {
    
    // Recursive binary search function
    int bs(int arr[], int start, int end, int target) {
        
        // Base case: If the search space is empty, return -1
        if (start > end) return -1;
        
        // Calculate the middle index
        int mid = start + (end - start) / 2;
        
        // If the middle element is the target, return its index
        if (arr[mid] == target) return mid;
        // If the target is greater, search the right half
        else if (arr[mid] < target) return bs(arr, mid + 1, end, target);
        // If the target is smaller, search the left half
        else return bs(arr, start, mid - 1, target);
    }
    
public:
    
    // Function to perform binary search on an array
    int binarysearch(int arr[], int n, int k) {
        
        // Call the recursive binary search function
        return bs(arr, 0, n - 1, k);
    }
};



GFG : https://practice.geeksforgeeks.org/problems/binary-search-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article