
class Solution {
    
    // Function to find the pivot element in a rotated sorted array
    int findPivot(int arr[]) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            // If there is only one element in the array, it is the pivot
            if (start == end) return start;
			
            // Check for the pivot element
            if (mid + 1 <= end && arr[mid] > arr[mid + 1]) return mid;
            else if (mid - 1 >= start && arr[mid - 1] > arr[mid]) return mid - 1;
			
            // Modified binary search algorithm to find the pivot
            if (arr[start] > arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        
        return -1; // No pivot found, array is not rotated
    }
    
    // Function to perform binary search for a key in a sorted array
    int bs(int arr[], int start, int end, int k) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == k) return mid;
            else if (arr[mid] < k) start = mid + 1;
            else end = mid - 1;
        }
        
        return -1; // Key not found in the array
    }
    
    // Main search function to find a key in a rotated sorted array
    int search(int arr[], int l, int h, int key) {
        int n = arr.length;
      
        if (n == 0) return -1; // Empty array case

        int pivot = findPivot(arr);
      
        if (pivot == -1) {
            // If there's no pivot, the array is not rotated, perform a regular binary search
            return bs(arr, 0, n - 1, key);
        }
      
        if (arr[pivot] == key) return pivot; // If the pivot is the key, return its index
      
        if (arr[0] > key)
            return bs(arr, pivot + 1, n - 1, key); // Search in the right part of the rotated array
        else
            return bs(arr, 0, pivot - 1, key); // Search in the left part of the rotated array
    }
}


GFG: https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1