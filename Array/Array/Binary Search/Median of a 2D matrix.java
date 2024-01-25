// Method 1

import java.util.*;

public final class Solution {
    public static int findMedian(int matrix[][], int m, int n) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int row[] : matrix){
            for(int x : row){
                pq.add(x);
            }
        }

        int totalElements = n*m;
        
        boolean even = (totalElements&1) == 0 ;

        for(int i = 0; i< totalElements/2; i++) pq.poll();

        if(even){
            int first = pq.poll();
            int second = pq.poll();
            return first + second / 2;
        }else{
            return pq.poll();
        }
    }
}

// Method 2

import java.util.ArrayList;
import java.util.Collections;

public final class Solution {
    public static int findMedian(int matrix[][], int m, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int row[] : matrix) {
            for (int x : row) {
                arr.add(x);
            }
        }

        Collections.sort(arr);

        int total = arr.size();

        if ((total & 1) == 0) {
            // even
            return (arr.get(total / 2) + arr.get((total / 2) - 1)) / 2;
        } else {
            // odd
            return arr.get(total / 2);
        }
    }
}


// Method 3

public final class MatrixMedianFinder {

    // Binary search to find the upper bound of the target in a sorted array.
    private static int upperBound(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    // Helper function to count elements in an array that are less than or equal to the target.
    private static int countMinThanOrEqualTo(int[] row, int target) {
        return upperBound(row, target);
    }

    // Function to find the median of a 2D matrix.
    public static int findMedian(int[][] matrix, int numRows, int numCols) {

        int minInFirstColumn = Integer.MAX_VALUE;
        int maxInLastColumn = Integer.MIN_VALUE;

        // Find the minimum value in the first column.
        for (int i = 0; i < numRows; i++) {
            minInFirstColumn = Math.min(minInFirstColumn, matrix[i][0]);
        }

        // Find the maximum value in the last column.
        for (int i = 0; i < numRows; i++) {
            maxInLastColumn = Math.max(maxInLastColumn, matrix[i][numCols - 1]);
        }

        // Initialize the search range between the minimum and maximum values.
        int start = minInFirstColumn;
        int end = maxInLastColumn;

        // Perform binary search to find the median.
        while (start <= end) {
            int mid = start + (end - start) / 2;

            int count = 0;

            // Count the number of elements less than or equal to mid in each row.
            for (int i = 0; i < numRows; i++) {
                count += countMinThanOrEqualTo(matrix[i], mid);
            }

            // Adjust the search range based on the count.
            if (count <= (numCols * numRows) / 2) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Return the final result.
        return start;
    }
}

Steps : 1. Fint the range ( find min from first column and max from last column).
        2. Apply Binary serach and get mid, now count how many elements are smalller than this mid, if count is less than equal to the half of the elements int the matrix then search for higher counts ( low = mid+1 ).
        3. Otherwise search for lower counts (high = mid-1).


CodeStudio : https://www.codingninjas.com/studio/problems/median-of-a-row-wise-sorted-matrix_1115473?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM