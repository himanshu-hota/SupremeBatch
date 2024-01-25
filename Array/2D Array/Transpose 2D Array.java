// using extra space

	public static void transpose(int arr[][]) {

		 int colLength = arr[0].length;
		 int rowLength = arr.length;	
		 
		 int transpose[][] = new int[colLength][rowLength];
		
		for(int i = 0; i < rowLength ; i++) {
			for(int j = 0 ; j < colLength ; j++) {
				 transpose[j][i] = arr[i][j];
			}
		}
		System.out.println("Transpose of the given 2D array is : ");
		print2DArray(transpose);
	}

//  using no extra space
	public static void transpose(int arr[][]) {
	    // Get the number of rows and columns in the input array.
	    int rows = arr.length;
	    
	    
	    for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < rows; j++) {
                // Swap elements at (i, j) and (j, i)
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
	}
	

	// one more way

	 for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
     }

	 Note : 1. Har ek row pe jao.
	 		2. Aur i wale varibale tak ki value ko swap kar do bhaisab.