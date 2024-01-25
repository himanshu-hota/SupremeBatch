class Solution {
    // This function reverses a subarray within the input array.
    void reverseSubArray(int arr[], int n, int l, int r) {
        // If the specified range is not valid (i.e., l is greater than r), no reversal is performed.
        if (l > r) {
            return;
        }
        
        // Convert the 1-based range positions to 0-based indices by subtracting 1.
        l--;
        r--;

        // Temporary variable to assist in the reversal process.
        int temp = 0;

        // Reverse the elements in the given range.
        while (l < r) {
            // Swap the elements at positions l and r using the temporary variable.
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // Move the left pointer (l) to the right, and the right pointer (r) to the left
            // until they meet in the middle, effectively reversing the subarray.
            l++;
            r--;
        }
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/reverse-sub-array5620/1