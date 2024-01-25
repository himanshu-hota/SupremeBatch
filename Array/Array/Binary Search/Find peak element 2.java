// Method 1

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        // adjacent elements pointers
        int up = -1;
        int le = -1;
        int ri = -1;
        int dow = -1;

        // range 
        int rows = mat.length;
        int cols = mat[0].length;

        for(int i = 0; i< mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                
                int element = mat[i][j];

                // up
                up = (i-1) >= 0 ? mat[i-1][j] : -1;
                // left
                le = (j-1) >= 0 ? mat[i][j-1] : -1;
                // down
                dow = (i+1) < rows ? mat[i+1][j] : -1;
                // right
                ri = (j+1) < cols ? mat[i][j+1] : -1;

                if(element > up && element > le && element > dow && element > ri){
                    return new int[]{i,j};
                }

            }
        }

        return new int[]{-1,-1};
    }
}

// Method 2

public class Solution {

    // Function to find the row with the maximum value in a given column
    public static int maxRow(int arr[][], int col) {

        int start = 0;
        int end = arr.length;
        int max = -1;
        int row = -1;

        // Iterate through the rows of the column and find the maximum element
        while (start < end) {
            int element = arr[start][col];
            if (element > max) {
                max = element;
                row = start;
            }
            start++;
        }

        return row;
    }

    // Function to find a peak element in a 2D array
    public static int[] findPeakGrid(int[][] arr) {

        int rows = arr.length;
        int cols = arr[0].length;

        int start = 0;
        int end = cols - 1;

        // Binary search on columns
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Find the row with the maximum value in the current column
            int maxR = maxRow(arr, mid);

            // Check elements to the left and right of the mid column
            int left = (mid - 1) >= 0 ? arr[maxR][mid - 1] : -1;
            int right = (mid + 1) < cols ? arr[maxR][mid + 1] : -1;

            int element = arr[maxR][mid];

            // Compare the current element with its neighbors to determine if it's a peak
            if (element > left && element > right) {
                return new int[]{maxR, mid}; // Peak found
            } else if (element < left) {
                end = mid - 1; // Search in the left half
            } else {
                start = mid + 1; // Search in the right half
            }
        }

        return new int[]{-1, -1}; // No peak found
    }
}


Steps : 1. Get the middle column.
        2. Check which element is the max in this col and at which row.
        3. Now get the element and check if it is greater than its left and right, if yes then it is the peak element.
        (why not checking up and down? -> already done when we were finding max in the column).
        4. If left is greater then search on the left part.
        5. If right is greater then search on the right part.


LeetCode : https://leetcode.com/problems/find-a-peak-element-ii/

CodeStudio : https://www.codingninjas.com/studio/problems/find-peak-element_7449073?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM