	
	public static void searchIn2DArray(int arr[][] , int key) {
		
		int colLength = arr[0].length;
		int rowLength = arr.length;
		
		for(int row = 0 ; row < rowLength ; row++) {
			for(int col = 0 ; col < colLength ; col++ ) {
				if(arr[row][col] == key) {
					System.out.println("Element found at : " + (colLength*row+col +1) + "th " + "Position");
					System.out.println("row index : " + row);
					System.out.println("col index : " + col);
					return;
				}
			}
		}
		
		System.out.println("Element not found!!!!");
		
	}
