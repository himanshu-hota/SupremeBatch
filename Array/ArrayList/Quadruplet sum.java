	public static void  quadrupletsSum(ArrayList<Integer> arr , int sum) {
		for(int i = 0 ; i< arr.size(); i++) {
			for(int j =i+1 ;j< arr.size(); j++) {
				for(int k = j+1; k< arr.size() ; k++) {
					for(int p = k+1 ; p < arr.size() ; p++) {
						int elem1 = arr.get(i);
						int elem2 = arr.get(j);
						int elem3 = arr.get(k);
						int elem4 = arr.get(p);
						if(elem1 + elem2 + elem3 + elem4 == sum) {
							System.out.print("[");
							System.out.print(elem1 + ", " + elem2 + ", " + elem3 + ", " + elem4);
							System.out.print("] ");
						}											
					}

				}

			}
		}
		
		System.out.println();
	}