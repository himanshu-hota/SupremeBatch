// method 1

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

    // Function to search for a target element in a 2D matrix
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

// method 2

class Solution {

    // Binary search to find the row where the target might be located
    public int findRow(int arr[][], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid][0] == target)
                return mid;
            else if (arr[mid][0] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // If the target is not found in any row, return the index of the last row visited
        return end;
    }

    // Binary search in a single row to find the target
    public int bs(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // If the target is not found in the row, return -1
        return -1;
    }

    // Main function to search for the target in the 2D matrix
    public boolean searchMatrix(int[][] matrix, int target) {

        // Check if the matrix has only one element, and that element is the target
        if (matrix.length == 1 && matrix[0][0] == target)
            return true;

        // Find the row index where the target might be located
        int rowIndex = findRow(matrix, target);

        int index = 0;

        // If findRow returns -1, it means the target is in the first row
        if (rowIndex == -1) {
            index = bs(matrix[0], target);
        } else {
            // If findRow returns a valid index, perform binary search in that row
            index = bs(matrix[rowIndex], target);
        }

        // If the index is not -1, the target is found; otherwise, it's not in the matrix
        return index >= 0 ? true : false;
    }
}



LeetCode : https://leetcode.com/problems/search-a-2d-matrix/

CodeStudio : https://www.codingninjas.com/studio/problems/search-in-a-2d-matrix_980531?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM