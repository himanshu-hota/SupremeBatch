// Method 1 


public class Solution {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // Boolean variable isColZero will tell us the same for the entire 1st column.
        boolean isColZero = false;
        for (int i = 0; i < n; i++) {

            // if any of the element at 0th column is 0 then we will make entire column zero at the end.
            if (matrix.get(i).get(0) == 0) {
                isColZero = true;
            }

            // make the arr[i][0] and arr[0][i] 0 to track 0.
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    // We have to set that entire row to be 0
                    matrix.get(i).set(0, 0);
                    // We have to set that entire column to be 0
                    matrix.get(0).set(j, 0);
                }
            }
        }
       

        // if the 0 is peresent in mat[i][0] or mat[0][i] then mark this cell 0.
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                /*
                  If starting cell of row or starting cell of column is zero,
                  then set entry at i,j to 0.
                */
                if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        
        // if the (0,0) element was 0 then we need to make entire row 0
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        
        // if any of the first col elemenet was initially 0 then we need to make entire col 0.
        if (isColZero) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }
        return matrix;
    }
}

Steps: 1. We will use the 0th row and 0th column to track which row and col to make 0 entirely.
       2. Intially loop from 0th row and 1st col till the end of the matrix and check if we find any 0,
          if found the 0 then mark the ith col at 0th row to 0,
          and mark the ith row and 0th col to 0.
          also if we find any elemenet is 0 in the 0th col then mark 'colIsZero' to true , this will help in marking the 0th col fill with 0.
       3. Now we know which rows and cols will be entirely filled with 0.
       4. Now loop from 1st row and 1st column till end of matrix and if you found the ith elemenet and -th row or 0th col is zero then mark this cell as 0.
       5. End


// Method 2

class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1;  // A flag to track the state of the first column
        int rows = matrix.length;
        int cols = matrix[0].length;

        // First pass: mark the cells that should be zeroed in the first row and first column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0)
                col0 = 0;  // If any cell in the first column is 0, set the flag
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;  // Mark the corresponding row and column
                }
            }
        }

        // Second pass: update the cells based on the marks in the first row and first column
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;  // Set the cell to zero if its corresponding row or column is marked
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;  // If the first column is marked, set the entire column to zero
            }
        }
    }
}

// MIX 

class Solution {
  public void setZeroes(int[][] matrix) {
    boolean isColZero = false;
    int n = matrix.length;
    int m = matrix[0].length;

    for (int i = 0; i < n; i++) {
      // if any of the element at 0th column is 0 then we will make the entire column zero at the end.
      if (matrix[i][0] == 0) {
        isColZero = true;
      }

      // Make the matrix[i][0] and matrix[0][i] 0 to track 0.
      for (int j = 1; j < m; j++) {
        if (matrix[i][j] == 0) {
          // We have to set that entire row to be 0
          matrix[i][0] = 0;
          // We have to set that entire column to be 0
          matrix[0][j] = 0;
        }
      }
    }

    // If the 0 is present in matrix[i][0] or matrix[0][i], then mark this cell as 0.
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 1; j--) {
        // If the starting cell of the row or starting cell of the column is zero, set entry at i, j to 0.
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }

      // If the first column is marked, set the entire column to zero
      if (isColZero) {
        matrix[i][0] = 0;
      }
    }

  }
}


CodeStudio : https://www.codingninjas.com/studio/problems/zero-matrix_1171153?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=PROBLEM