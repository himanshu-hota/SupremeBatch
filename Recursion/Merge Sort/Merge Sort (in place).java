class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1); // Call mergeSort to sort the array
        return nums; // Return the sorted array
    }

    static void mergeSort(int arr[], int start, int end) {
        if (start >= end)
            return; // Base case: If start is greater than or equal to end, return

        int mid = start + (end - start) / 2; // Calculate the middle index

        mergeSort(arr, start, mid); // Sort the left half of the array
        mergeSort(arr, mid + 1, end); // Sort the right half of the array
        mergeInPlace(arr, start, mid, end); // Merge the sorted halves in place
    }

    static void mergeInPlace(int arr[], int start, int mid, int end) {
        int total = end - start + 1; // Calculate the total number of elements to be merged
        int gap = total / 2 + total % 2; // Calculate the initial gap size

        while (gap > 0) {
            int i = start, j = gap + start; // Set the indices for comparing elements within the gap
            while (j <= end) {
                if (arr[i] > arr[j]) { // If the element at index i is greater than the element at index j
                    int temp = arr[i]; // Swap the elements
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                ++i;
                ++j;
            }
            gap = gap <= 1 ? 0 : (gap / 2 + gap % 2); // Reduce the gap size by half, rounding up if necessary
        }
    }
}


Notes : 1. The normal merge sort takes O(n) space complexity , to avoid this space complexity we use merge sort (in place) method.
        2. The mergeSort function is the same , but merge function is different.
        3. We take a gap variable and assign the value of Math.ceil((length of left arr + length of right arr)/2) or in other words (totalLen/2 + totalLen%2).
        4. We loop till we have an active gap is greater than 0.
        5. We take two pointers one is 'i' and one is 'j', assign 'i' to start , 'j' to start+gap.
        6. Loop till j reaches the end and check if element at i greater than j , if yes then swap.
        7. Now after the inner loop we update the gap size to again Math.ceil(total/2), but when gap size becomes 1 we dont half. why ? --> because if we try to do Math.ceil(1) it is always 1, so it would stuck in infinite loop, thats why don't break into half when gap becomes 1.

LeetCode :- https://leetcode.com/problems/sort-an-array/description/