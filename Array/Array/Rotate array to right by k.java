class Solution {
    // Helper function to reverse a subarray of 'arr' from 'start' to 'end'
    static void reverse(int arr[], int start, int end) {
        int temp = 0;
        // Use a temporary variable to swap elements from 'start' to 'end'
        while (start <= end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // Move the 'start' pointer forward and the 'end' pointer backward
            start++;
            end--;
        }
    }

    // Function to rotate an array 'arr' of length 'n' to the right by 'k' positions
    public void rotate(int[] arr, int k) {
        int n = arr.length;
        // Calculate the effective rotation count 'k' by taking 'k' modulo 'n'
        k = k % n;
        // Calculate the pivot point for rotation (n - k)
        k = n - k;

        // Step 1: Reverse the first 'k' elements
        reverse(arr, 0, k - 1);

        // Step 2: Reverse the remaining 'n-k' elements
        reverse(arr, k, n - 1);

        // Step 3: Reverse the entire array to obtain the final rotated array
        reverse(arr, 0, n - 1);
    }
}


Note :- 1. It is exactly same as "Rotate array to left by k" except line no. 22.
        2. By using the line no. 22 we convert this question to "Rotate array to left by k".

LeetCode :- https://leetcode.com/problems/rotate-array/
