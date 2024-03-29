class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], long N) {
        // Your Code Here
        long c = 0;
        long temp[] = new long[arr.length];
        c = mergeSort(arr, temp, 0, arr.length - 1);

        return c;
    }

    // Helper function to perform merge sort and count inversions
    static long mergeSort(long arr[], long temp[], int start, int end) {
        if (start >= end) return 0;

        int mid = start + (end - start) / 2;
        long c = 0;

        // Recursively split the array into halves and merge them
        c += mergeSort(arr, temp, start, mid);
        c += mergeSort(arr, temp, mid + 1, end);
        c += merge(arr, temp, start, mid, end);

        return c;
    }

    // Helper function to merge two sorted subarrays and count inversions
    static long merge(long arr[], long temp[], int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;
        long c = 0;

        // Merge the two subarrays while counting inversions
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                c += mid - i + 1; // Increment inversion count
            }
        }

        // Copy any remaining elements from the first subarray
        while (i <= mid) temp[k++] = arr[i++];

        // Copy any remaining elements from the second subarray
        while (j <= end) temp[k++] = arr[j++];

        // Copy the merged array back to the original array
        while (start <= end) arr[start] = temp[start++];

        return c; // Return the inversion count
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

CodeStudio : https://www.codingninjas.com/studio/problems/count-inversions_615