
	
	public static void print2DArray(int arr[][]) {
		
		int colLength = arr[0].length;
		int rowLength = arr.length;
		
		System.out.println("2D array is : ");
		for(int i = 0 ; i<rowLength; i++ ) {
			for(int j = 0 ; j< colLength ; j++) {
				System.out.print(arr[i][j] + " ");
			}
				System.out.println();
		}
	}
	