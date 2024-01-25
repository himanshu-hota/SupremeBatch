class Solution {
    // Helper method to reverse an array
    public void reverse(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    // Main method to rotate the matrix
    public void rotate(int[][] mat) {
        int n = mat.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Reverse each row of the matrix
        for (int i = 0; i < n; i++) {
            reverse(mat[i]);
        }
    }
}


LeetCode : https://leetcode.com/problems/rotate-image/

CodeStudio : https://www.codingninjas.com/studio/problems/rotate-the-matrix_6825090?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM