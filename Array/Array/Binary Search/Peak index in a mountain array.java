// Method 1 

class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int n = arr.length;

        // If the array has less than 3 elements, there can't be a peak.
        if (n < 3)
            return -1;

        int start = 0;
        int end = n - 2; // We start the 'end' pointer at the second-to-last element.

        // Binary search for the peak.
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if 'mid' is a peak by comparing it to its neighbors.
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid; // 'mid' is a peak.
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1; // Move 'start' to the right half.
            } else {
                end = mid - 1; // Move 'end' to the left half.
            }
        }

        return -1; // If no peak is found in the array, return -1.
    }
}

Steps :- 1. If the current mid element is greater than both previous and next element then it is the answer.
         2. if the next element of mid element is greater then then mid can not be answer, so move forward.
         3. if the prev element of mid element is greater then it can not be the answer , so move backward.


// Method 2

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            // if mid is smaller then its next then array is sorted till mid+1,
            // and peak index can never be present in the sorted array.
            if(arr[mid] <= arr[mid+1]) start = mid+1;
            else end = mid-1;
        }

        return start;
    }
}

    LeetCode :- https://leetcode.com/problems/peak-index-in-a-mountain-array/description/


    Note :- 1. when doing e = mid or s = mid , keep in mind that you should not use <= in while condition , because it can get stuck in infinite loop.
            2. peak index can never be present in the left sorted array.
            3. we have done e = mid because mid index can also be the peak index because it also has the property of arr[mid]> arr[mid+1] if it is from right sorted array.