class Solution {

    // Function to find the index of the pivot element in a rotated sorted array
    public int findPivot(int arr[]) {
        // Initialize pointers for binary search
        int start = 0;
        int end = arr.length - 1;

        // Perform binary search to find the pivot
        while (start <= end) {
            // Calculate mid index
            int mid = start + (end - start) / 2;

            // Check if mid is the pivot point
            if (mid + 1 <= end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid - 1 >= start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Adjust pointers based on the sorted half
            if (arr[start] <= arr[mid]) {
                // Left half is sorted
                start = mid + 1;
            } else {
                // Right half is sorted
                end = mid - 1;
            }
        }

        // No pivot found
        return -1;
    }

    // Function to find the minimum element in a rotated sorted array
    public int findMin(int[] arr) {
        // Get the length of the array
        int n = arr.length;

        // Find the index of the pivot element
        int pivot = findPivot(arr);

        // Check if a pivot is found
        if (pivot == -1) {
            // No rotation, return the first element
            return arr[0];
        } else {
            // Return the element after the pivot as the minimum element
            return arr[pivot + 1];
        }
    }
}


Steps : 1. Find the pivot index (the idx at which the element is greater than its left and right both).
        2. The next element to pivot is the smallest element of the array.

LeetCode : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

CodeStudio : https://www.codingninjas.com/studio/problems/rotated-array_1093219?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION