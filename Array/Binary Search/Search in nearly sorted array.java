	public static void SearchInNearlySortedArray(int arr[],int target) {
		int start= 0 ;
		int end = arr.length -1;
		int mid = start + (end - start) / 2;
		
		while(start <= end) {
				if(arr[mid]  == target) {
				System.out.println("Element found at " + mid +  "th index");
				return;
			}else if(mid-1 >= start && arr[mid-1]  == target) {
				System.out.println("Element found at " + (mid - 1) +  "th index");
				return;
			}else if(mid+1 <= end && arr[mid + 1]  == target) {
				System.out.println("Element found at " + (mid + 1) +  "th index");
				return;
			}else if(target < arr[mid]) {
				end = mid -2;
			}else {
				start = mid +2;
			}
			
			mid = start + (end - start) / 2;
		}
		
		System.out.println("Element not found!!!");
	}


	GFG :- https://www.geeksforgeeks.org/search-almost-sorted-array/

	Special Note : 1. Element ya to mid me hoga ya mid-1 me ya mid+1.
				   2. To teeno ko check kar lo kya ye target hai? agar ha to return kardo.	
				   3. Agar nahi to check karo ki kya target mid se chhota hai to mid-2 karna kyoki upar hamne mid aur mid-1 (2) element check kar liye hain.
				   4. Agar target mid se bada hai to mid+2 karna kyoki upar hamne mid mid+1 (2) elements check kar liye hain.

    Note : - 1. We have added condition that >= start and <= end to optimize the code , so that no unnecessary check is performed.
			 2. The question says the num is present at any of (ith,ith+1,ith-1), normally we in binary search we check at ith index, what we have to do in this question is that , just put two more check on ith+1 and ith-1 , thats it, and it is a normal binary search.
