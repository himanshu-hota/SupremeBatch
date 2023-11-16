import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    // Function to count the number of ones in a sorted binary array
    public static int countOfOnes(ArrayList<Integer> arr) {
        int start = 0;
        int end = arr.size() - 1;

        // Binary search to find the lower bound or the first occurrence of 1 in the array
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) == 1) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // Calculate the count of ones in the array
        return arr.size() - start;
    }

    // Function to find the row with the maximum number of ones in a binary matrix
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        int max = Integer.MIN_VALUE;
        int rowNum = -1;

        // Iterate through each row in the matrix
        for (int i = 0; i < matrix.size(); i++) {
            // Count the number of ones in the current row
            int currCountOfOnes = countOfOnes(matrix.get(i));

            // Update the maximum count and row number if the current row has more ones
            if (currCountOfOnes > max) {
                max = currCountOfOnes;
                rowNum = i;
            }
        }

        // Return the row number with the maximum count of ones
        return rowNum;
    }
}

Steps : 1. Go to each row and count the ones, and the rowNum if we got higher freq. of ones.

CodeStudio : https://www.codingninjas.com/studio/problems/row-of-a-matrix-with-maximum-ones_982768?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM