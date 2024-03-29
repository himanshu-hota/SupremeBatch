public class Solution {
    public static int search(int[] arr, int x) {
        // Initialize variables
        int i = 1;                     // Start with step size 1
        int n = arr.length;            // Get the length of the array
        while (i < n && arr[i] < x) {
            i *= 2;                    // Double the step size until arr[i] is greater or equal to x
        }

        int start = i / 2;              // Set the start of the binary search range
        int end = Math.min(i, n - 1);   // Set the end of the binary search range, making sure it doesn't exceed the array size When we come out of loop, the start index always point to the just greater element then given k
         
        // Perform binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;  // Calculate the middle index

            if (arr[mid] == x) {
                return mid;               // If the element at mid is equal to x, return the index
            } else if (arr[mid] < x) {
                start = mid + 1;          // If the element at mid is less than x, update the start
            } else {
                end = mid - 1;            // If the element at mid is greater than x, update the end
            }
        }

        return -1;                       // Return -1 to indicate that the element x was not found in the array
    }
}



	Steps: 1. Find a range.
		   2. Perform normal Binary serach. 	

	Why min(i,n-1) ? -> because when we come out of loop it is possible that i exceed the array range so thats why min.
	
	Why i/2 ? -> because when we come out of loop it is sure that i crossed the index where actual answer is present.

	JUST DO 1 DRY RUN AND YOU WILL GET IT.
	

	GFG :- https://www.geeksforgeeks.org/exponential-search/