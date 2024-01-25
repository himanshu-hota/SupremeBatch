	
	public static void maxIn2DArray(int arr[][]) {
		 int max = Integer.MIN_VALUE;
		 int colLength = arr[0].length;
		 int rowLength = arr.length;		 
		 
		 for(int i = 0 ; i < rowLength; i++) {
			 for(int j = 0 ; j < colLength ; j++) {
				 if(max < arr[i][j]) {
					 max = arr[i][j];
				 }
			 }
		 }
		 
		 System.out.println("Maximum element in the array is : " + max);
	}