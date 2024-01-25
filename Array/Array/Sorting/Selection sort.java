	public static void selectionSort(int arr[]) {

        //outer loop for rounds
		for(int i = 0 ; i < arr.length-1 ; i++ ) {
			int min = i;
            //inner loop for pass
			for(int j = i+1 ; j< arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			System.out.println(min);
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		
		System.out.println("Sorted array is:");
		printArray(arr);
	}


	Note :- 1. In outer loop we are going till n-1 because we want inner loop to go till <n .
			2. If we try to put <n in outer loop then it will throw index out of bound .
			3. In inner loop we are starting with i+1 because we want to leave 1 element at every iteration as 1 element at starting will be sorted at every iteration


GFG : https://practice.geeksforgeeks.org/problems/selection-sort/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

CodeStudio : https://www.codingninjas.com/studio/problems/selection-sort_981162