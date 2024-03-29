class Solution {

    static int helper(int arr[], int start, int end, int k) {
        while (start <= end) {
            int mid1 = start + (end - start) / 3; // Calculate mid1
            int mid2 = end - (end - start) / 3; // Calculate mid2

            if (arr[mid1] == k)
                return 1;
            if (arr[mid2] == k)
                return 1;

            if (k < arr[mid1]) {
                end = mid1 - 1; // Adjust end index
            } else if (k > arr[mid2]) {
                start = mid2 + 1; // Adjust start index
            } else { // this is the case when target lies in between mid1 and mid 2
                start = mid1 + 1; // Adjust start index
                end = mid2 - 1; // Adjust end index
            }
        }

        return -1;
    }

    static int ternarySearch(int arr[], int N, int k) {
        // Your code here

        if (N <= 0) return -1;

        return helper(arr, 0, N - 1, k);


    }
}

GFG :- https://practice.geeksforgeeks.org/problems/searching-an-element-in-a-sorted-array-ternary-search--141631/1