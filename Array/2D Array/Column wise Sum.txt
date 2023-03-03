
	public static void colWiseSum(int arr[][]) {
		
		int colLength = arr[0].length;
		int rowLength = arr.length;
		int sum = 0;
		for(int col = 0 ; col < colLength ; col++) {
			for(int row = 0 ;row< rowLength ; row++) {
				sum += arr[row][col];
			}
			System.out.println("Sum of " + (col+1) + "th col : " + sum);
			sum = 0;
		}
	}