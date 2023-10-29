	public static void sort0sAnd1s(ArrayList<Integer> arr) {
		int start = 0;
		int end = arr.size() -1;
		int i = 0 ; 
		int temp = Integer.MIN_VALUE;
		while(start< end){
			// if element is 0 then put it on right part
			if(arr.get(i) == 0) {
				//swap
				temp = arr.get(start);
				arr.set(start, arr.get(i));
				arr.set(i, temp);
				i++;
				start++;
			}else if(arr.get(i) == 1) {
				//swap
				temp = arr.get(end);
				arr.set(end, arr.get(i));
				arr.set(i, temp);
				end--;				
			}
		}
	}

	GFG :- https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1