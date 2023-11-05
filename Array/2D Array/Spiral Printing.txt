class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        // Initialize the result list.
        List<Integer> ans = new ArrayList<>();

        // Get the number of rows (m) and columns (n) in the matrix.
        int m = mat.length;
        int n = mat[0].length;

        // Calculate the total number of elements in the matrix.
        int total = n * m;
        int count = 0; // Initialize a counter to keep track of the number of elements added to the result.

        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        // Iterate through the matrix in a spiral order until all elements are added.
        while (count < total) {
            // Traverse the upper row from left to right.
            for (int i = startCol; i <= endCol; i++) {
                ans.add(mat[startRow][i]);
                count++;
            }
            startRow++;

            // Traverse the rightmost column from top to bottom.
            for (int i = startRow; i <= endRow && count < total; i++) {
                ans.add(mat[i][endCol]);
                count++;
            }
            endCol--;

            // Traverse the lower row from right to left.
            for (int i = endCol; i >= startCol && count < total; i--) {
                ans.add(mat[endRow][i]);
                count++;
            }
            endRow--;

            // Traverse the leftmost column from bottom to top.
            for (int i = endRow; i >= startRow && count < total; i--) {
                ans.add(mat[i][startCol]);
                count++;
            }
            startCol++;
        }

        // Return the final result list.
        return ans;
    }
}

Note : It is important that we increment the startRow,startCol,endCol,endRow just after its respective for loop, if we increment it at the end of the while loop then it would not work as expected.

LeetCode : https://leetcode.com/problems/spiral-matrix/
