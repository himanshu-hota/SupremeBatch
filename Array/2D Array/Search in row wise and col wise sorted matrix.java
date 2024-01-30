import java.util.*;

public class Solution {
    // Helper function to perform binary search in a sorted array and return the column index of the target.
    static int colIdx(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1; // Target not found in the array.
    }

    // Function to search for the target element in a 2D matrix.
    public static boolean searchElement(int[][] MATRIX, int target) {
        for (int row[] : MATRIX) {
            int ans = colIdx(row, target);
            if (ans >= 0) {
                return true; // If the target is found in a row, return true.
            }
        }

        return false; // If the target is not found in any row, return false.
    }
}

// optimized

import java.util.*;

public class Solution {
    // Method to search for an element in a 2D matrix
    public static boolean searchElement(int [][]MATRIX, int target) {
        // Get the number of rows and columns in the matrix
        int rows = MATRIX.length;
        int cols = MATRIX[0].length;

        // Calculate the total number of elements in the matrix
        int total = rows * cols;

        // Initialize variables for binary search
        int start = 0;
        int end = total - 1;

        // Perform binary search
        while(start <= end){
            // Calculate the middle index
            int mid = start + (end - start)/2;

            // Calculate row and column indices for the middle element
            int rowIndex = mid / cols;
            int colIndex = mid % cols;

            // Get the middle element
            int element = MATRIX[rowIndex][colIndex];

            // Check if the middle element is equal to the target
            if(element == target) 
                return true;
            // If the middle element is less than the target, search the right half
            else if(element < target) 
                start = mid + 1;
            // If the middle element is greater than the target, search the left half
            else 
                end = mid - 1;
        }

        // If the target element is not found, return false
        return false;
   }
}


Note : 1. If we have m*n matrix then total element would be m*n.
       2. Now if we want to get indices of any element from 0 -> m*n then what we have to do is ----> rowIndex = mid/totalCols , colIndex = mid%totalCols.
       3. Above is the formula to get indices of any element between 0 -> totalElements.

CodeStudio : https://www.codingninjas.com/studio/problems/search-in-a-sorted-2d-matrix_6917532?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION