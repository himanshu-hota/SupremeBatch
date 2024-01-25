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



CodeStudio : https://www.codingninjas.com/studio/problems/search-in-a-sorted-2d-matrix_6917532?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION