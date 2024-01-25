public static void BinarySearchIn2DArray(int arr[][],int target) {
		int row = arr.length;
		int col = arr[0].length;
		int total = row*col;
		int start = 0;
		int end = total-1;
		int mid = start + (end - start) / 2;
		
		while(start <= end) {
			int rowIndex = mid/col;
			int colIndex = mid%col; 
			int element = arr[rowIndex][colIndex];
			
			if(target == element) {
				System.out.println("Element found at arr[" + rowIndex + "][" + colIndex + "]");
				return;
			}else if( target < element) {
				end = mid - 1;
			}else {
				start = mid+1;
			}
			
			mid = start + (end - start) /2;
		}
		System.out.println("Element not found!!!");
	}