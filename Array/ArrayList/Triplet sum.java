	public static void tripletSum(ArrayList<Integer> arr , int sum) {
		for(int i = 0 ; i< arr.size(); i++) {
			for(int j =i+1 ;j< arr.size(); j++) {
				for(int k = j+1; k< arr.size() ; k++) {
					int elem1 = arr.get(i);
					int elem2 = arr.get(j);
					int elem3 = arr.get(k);
					if(elem1 + elem2 + elem3 == sum) {
						System.out.print("[");
						System.out.print(elem1 + ", " + elem2 + ", " + elem3);
						System.out.print("] ");
					}					
				}

			}
		}
		
		System.out.println();
	}