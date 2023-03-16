public static void firstOccurance(int arr[] , int target) {
		int n = arr.length;
		int start = 0;
		int end = n-1;
		int index = -1;
		int mid = start + (end - start )/2;
				
		
		while(start<=end){
				//if element is found then search for more appearance in left part
				if(arr[mid] == target) {
					index = mid; // store the index
					end = mid -1;
				}else if(target < arr[mid]) { // if target is less than middle element the search it on left part
					end = mid-1;
				}else if(target > arr[mid]) { // if target is greater than middle element the search it on right part
					start = mid + 1;
				}
				
				//update middle index
				mid  = start + (end-start)/2;
		}
		
		
		
		if(index >=0) {
			System.out.println("First occurance at : " + (index + 1) + "th position");
		}else {
			System.out.println("Element not found!!!");
		}
				
		
	}