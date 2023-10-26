class Solution {
    // Helper function to reverse a subarray of 'arr' from 'start' to 'end'
    static void reverse(int arr[], int start, int end) {
        int temp = 0;
        // Use a temporary variable to swap elements from start to end
        while (start <= end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // Move the 'start' pointer forward and the 'end' pointer backward
            start++;
            end--;
        }
    }

    // Function to rotate an array 'arr' of length 'n' to the right by 'd' positions
    static void rotateArr(int arr[], int d, int n) {
        // Calculate the effective rotation count 'k' by taking 'd' modulo 'n'
        int k = d % n;
        
        // Step 1: Reverse the first 'k' elements
        reverse(arr, 0, k - 1);
        
        // Step 2: Reverse the remaining 'n-k' elements
        reverse(arr, k, n - 1);
        
        // Step 3: Reverse the entire array to obtain the final rotated array
        reverse(arr, 0, n - 1);
    }
}


Large Rotation Values: If k is greater than the length of the array n, it means that you're rotating the array more times than there are elements. For example, if the array has 5 elements, and you want to rotate it 7 times to the right, it's equivalent to rotating it 2 times (7 % 5 = 2). This operation effectively reduces k to the smallest positive integer that produces the same effect.

Negative Rotation Values: If k is negative, it represents a left rotation. However, it's common to work with positive rotation values. By applying k % n, you're effectively converting a negative left rotation into an equivalent positive right rotation. For example, if you want to perform a left rotation of -3, it's equivalent to a right rotation of 2 (3 % 5 = 2 in an array of length 5).


Steps :- 1. Firstly get the correct count of rotation.
         2. Reverse the array from 0 -> k-1.
         3. Reverse the array from k -> n-1.
         4. Reverse the array from 0 -> n-1.


GFG :- https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article