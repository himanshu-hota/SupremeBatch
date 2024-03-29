//  Method 1

class Solution {
    // Function to segregate positive and negative elements in the array 'arr'.
    public void segregateElements(int arr[], int n) {
        // If the array is empty, there is nothing to segregate, so return early.
        if (n == 0) {
            return;
        }
        
        // Create a temporary array 'temp' with the same size as 'arr'.
        int temp[] = new int[n];
        
        // Initialize 'start' and 'end' pointers to help with segregation.
        int start = 0;
        int end = 0;
        
        // Count the number of positive elements in 'arr'.
        int positiveCount = 0;
        
        // Iterate through 'arr' to count the positive elements.
        for (int x : arr) {
            if (x > 0) {
                positiveCount++;
            }
        }
        
        // Initialize 'end' to the position where positive elements should start in 'temp'.
        end = positiveCount;
        
        // Iterate through 'arr' to segregate positive and negative elements into 'temp'.
        for (int x : arr) {
            if (x < 0) {
                temp[end++] = x; // Place negative elements at the end.
            } else {
                temp[start++] = x; // Place positive elements at the beginning.
            }
        }
        
        // Reset 'start' to 0 and copy the elements from 'temp' back to 'arr'.
        start = 0;
        for (int x : temp) {
            arr[start++] = x;
        }
    }
}

Steps: 1. Get count of positive values. and create a temp array.
	   2. Now iterate the array, and start filling the positive from start and negative from (postive_value+1) index.
	   		a. when found negative put at end pointer index and move forward.
			b. when found positive put at start pointer index and move forward.
	   3. Now put all elements from temp to original array.



Read More:- https://www.geeksforgeeks.org/-negative-numbers-beginning-positive-end-constant-extra-space/


GFG :- https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1