public class Solution {

    // Function to find the index of the pivot element in a rotated sorted array
    public static int findPivot(int arr[]) {
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

    // Function to find the number of rotations in a rotated sorted array
    public static int findKRotation(int[] arr) {
        // Get the length of the array
        int n = arr.length;

        // Find the index of the pivot element
        int pivot = findPivot(arr);

        // Check if a pivot is found
        if (pivot == -1) {
            // No rotation, return 0 rotations
            return 0;
        } else {
            // Return the number of rotations (index of the pivot + 1)
            return pivot + 1;
        }
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/rotation_7449070?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM