// Method 1

class Solution {

    // Helper function to find the index of the first occurrence of 1 in a row.
    private int firstOccur(int arr[]) {
        int n = arr.length;
        int index = n;

        // Iterate through the row array to find the first occurrence of 1.
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int[] rowAndMaximumOnes(int[][] arr) {

        int n = arr.length; // Number of rows
        int m = arr[0].length; // Number of columns
        int max1s = 0; // Maximum number of 1s found
        int idx = 0; // Index of the row with maximum 1s

        // Iterate through each row of the 2D array.
        for (int i = 0; i < n; i++) {
            // Sort the row array (Note: Sorting may not be necessary in this context).
            Arrays.sort(arr[i]);

            // Find the index of the first occurrence of 1 in the row.
            int first = firstOccur(arr[i]);

            // Calculate the number of 1s in the row.
            int curr1s = m - first;

            // Update the maximum number of 1s and the index accordingly.
            if (curr1s > max1s) {
                max1s = Math.max(max1s, curr1s);
                idx = i;
            }
        }

        // Create and return an array containing the index and the maximum number of 1s.
        int ans[] = {idx, max1s};
        return ans;
    }
}

// Method 2

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int n = mat.length;
        int oneCount = Integer.MIN_VALUE;
        int rowNo = -1;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            if (count > oneCount) {
                oneCount = count;
                rowNo = i;
            }
        }

        int[] ans = {rowNo, oneCount};
        return ans;
    }
}


LeetCode :- https://leetcode.com/problems/row-with-maximum-ones/