	public static void minIn2DArray(int arr[][]) {
		 int min = Integer.MAX_VALUE;
		 int colLength = arr[0].length;
		 int rowLength = arr.length;		 
		 
		 for(int i = 0 ; i < rowLength; i++) {
			 for(int j = 0 ; j < colLength ; j++) {
				 if(min > arr[i][j]) {
					 min = arr[i][j];
				 }
			 }
		 }
		 
		 System.out.println("Minimum element in the array is : " + min);
	}