	
	public static void bubbleSort(int arr[]) {
		// outer loop for rounds
		for(int i = 0 ; i < arr.length-1; i++) {
			//inner loops for pass
			for(int j = 0 ;j < arr.length -i -1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.print("Sorted Array is :");
		printArray(arr);
	}


Note :- 1. In outer loop we are going till n-1 because we want inner loop to go til n (j+1).
		2. In inner loop we are going til n-i-1 because we are leaving 1 element at every iteration from the end as 1 element is sorted at every iteration.
	

--------------------------------------------------- Optimized Bubble sort ---------------------------------------------------------------------

		public static void bubbleSort(int arr[]) {
		for(int i = 0 ; i < arr.length-1; i++) {
			boolean swapped = false;
		
			for(int j = 0 ;j < arr.length -i -1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			
			//if no swap done then it is sorted now and no need for further iteration
			if(!swapped) {
				break;
			}
		}
		
		System.out.print("Sorted Array is :");
		printArray(arr);
	}
	\


GFG : https://practice.geeksforgeeks.org/problems/bubble-sort/1

CodeStudio :