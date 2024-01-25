public static void wavePrint(int mat[][]) {
    // Get the number of rows and columns in the matrix
    int rows = mat.length;
    int cols = mat[0].length;
    
    // Initialize a boolean variable to determine the printing direction (even or odd)
    boolean even = true;
    
    // Loop through each column of the matrix
    for(int j = 0; j < cols; j++) {
        if(even) {
            // If even, print elements in the current column from top to bottom
            for(int i = 0; i < rows; i++) {
                System.out.print(mat[i][j] +  ",");
            }
        } else {
            // If odd, print elements in the current column from bottom to top
            for(int i = rows - 1; i >= 0 ; i--){
                System.out.print(mat[i][j] +  ",");
            }
        }
        
        // Toggle the "even" variable to switch the printing direction
        even = even ? false : true;
    }
}
