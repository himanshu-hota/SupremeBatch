	public static void insertionSort(int arr[]) {
		
		for(int i = 0 ;i< arr.length ; i++) {
			
			int key = arr[i];
			int j = i-1;
			
            // shift all elements greater than key
			while(j>= 0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
            // copy element to right position
    		arr[j+1] = key; 
		}
		
		System.out.print("Sorted array is: ");
		printArray(arr);
	}

    Note :- 1. In outer loop we are starting from 1 index not 0 because we want inner loop to go till 0 index (j = i-1).
            2. grab the element.
            3. compare with others element.
            4. shift required elements.
            5. put element at right place.


GFG : https://practice.geeksforgeeks.org/problems/insertion-sort/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

CodeStudio : https://www.codingninjas.com/studio/problems/insertion-sort_3155179?leftPanelTab=1