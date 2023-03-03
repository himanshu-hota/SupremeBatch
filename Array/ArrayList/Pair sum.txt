	public static void pairSum(ArrayList<Integer> arr,int sum) {
		for(int i = 0 ; i< arr.size(); i++) {
			for(int j =i+1 ;j< arr.size(); j++) {
				int elem1 = arr.get(i);
				int elem2 = arr.get(j);
				if(elem1 + elem2 == sum) {
					System.out.print("[");
					System.out.print(elem1 + ", " + elem2);
					System.out.print("] ");
				}
			}
		}
		
		System.out.println();
	}