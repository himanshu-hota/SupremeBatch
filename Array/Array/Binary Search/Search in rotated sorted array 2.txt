class Solution {
    public boolean search(int[] arr, int target) {
        // Initialize pointers for binary search
        int start = 0;
        int end = arr.length - 1;

        // Perform binary search
        while (start <= end) {
            // Calculate mid index
            int mid = start + (end - start) / 2;

            // Check if target is found at mid index
            if (arr[mid] == target) return true;

            // Handle cases where duplicates exist at start, mid, and end
            if (arr[start] == arr[mid] && arr[mid] == arr[end]) {
                start++;
                end--;
            } else if (arr[start] <= arr[mid]) {
                // Left half is sorted
                if (target >= arr[start] && target < arr[mid]) {
                    // Target is in the left half
                    end = mid - 1;
                } else {
                    // Target is in the right half
                    start = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > arr[mid] && target <= arr[end]) {
                    // Target is in the right half
                    start = mid + 1;
                } else {
                    // Target is in the left half
                    end = mid - 1;
                }
            }
        }

        // Target not found in the array
        return false;
    }
}

Note : By using this code we can also solve "Search in rotated sorted array 1".

Steps : 1. We have to handle the duplicates elements first, the first "if" check handles the duplicate values.
        2. After handling the duplicates, Now need to figure out which part is sorted and has the value.
        3. The 'else if' part checks if the left part is sorted, if yes then check if the target falls in this range.
        4. If we reached the else case then right part is sorted , now need to check if target falls in this range.
        5. If we come out of the while loop then element is not present in the array.


LeetCode : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

CodeStudio : https://www.codingninjas.com/studio/problems/search-in-a-rotated-sorted-array-ii_7449547?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION