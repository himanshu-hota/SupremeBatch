	
	public static void rowWiseSum(int arr[][]) {
		
		int colLength = arr[0].length;
		int rowLength = arr.length;
		int sum = 0;
		for(int row = 0 ; row < rowLength ; row++) {
			
			for(int col= 0; col < colLength; col++) {
				sum += arr[row][col];	
			}
			
			System.out.println("Sum of " + (row+1) + "th row :" + sum);
			sum = 0 ;
		}
	}