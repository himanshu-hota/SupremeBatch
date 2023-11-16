// Method 1

class Solution {
    // Function to perform binary search in a sorted array
    public boolean findInRow(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        // Binary search in the row to find the target element
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                // Target element found in the row
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Target element not found in the row
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
         // Iterate through each row in the matrix
        for (int row[] : matrix) {
            // Check if the target element is present in the current row
            boolean found = findInRow(row, target);
            
            // If found, return true
            if (found) {
                return true;
            }
        }

        // Target element not found in any row
        return false;
    }
}

Special Note : Above code is "Search in 2D matrix 1", this code works for this question too.

// Method 2

class Solution {
    // Function to search for a target element in a 2D matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // Get the number of rows and columns in the matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Initialize pointers to the top-right corner of the matrix
        int row = 0;
        int col = matrix[0].length - 1;

        // Iterate until the pointers stay within the matrix boundaries
        while (row < rows && col >= 0) {
            // Get the element at the current position
            int element = matrix[row][col];

            // Check if the element is equal to the target
            if (element == target) {
                // Target element found
                return true;
            } else if (element < target) {
                // If the element is less than the target, move to the next row
                row++;
            } else {
                // If the element is greater than the target, move to the previous column
                col--;
            }
        }

        // Target element not found in the matrix
        return false;
    }
}


LeetCode : https://leetcode.com/problems/search-a-2d-matrix-ii/