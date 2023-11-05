import java.util.*;
import java.io.*;

public class Solution {
    // Method to count the number of flips required to turn all 0s to -1s in the input matrix
    public static int countFlip(int[][] mat) {

        int n = mat.length;  // Get the number of rows in the matrix
        int m = mat[0].length;  // Get the number of columns in the matrix

        int count = 0;  // Initialize a counter to keep track of the number of flips

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 0) {
                    // If the current element is 0, we need to flip it to -1 and count the flips

                    for (int k = 0; k < n; k++) {
                        // Check each column in the current row
                        if (mat[i][k] == 1) {
                            count++;  // Increment the count for each 1 in the row
                            mat[i][k] = -1;  // Flip the 1 to -1 to mark it as processed
                        }

                        // Check each row in the current column
                        if (mat[k][j] == 1) {
                            count++;  // Increment the count for each 1 in the column
                            mat[k][j] = -1;  // Flip the 1 to -1 to mark it as processed
                        }
                    }
                }
            }
        }

        return count;  // Return the total count of flips required to turn all 0s to -1s
    }
}


Steps: 1. pick one cell and if you found 0 then convert the entire row to -1 and entire col to -1.

CodeStudio : https://www.codingninjas.com/studio/guided-paths/data-structures-algorithms/content/118821/offering/1381900?leftPanelTabValue=PROBLEM