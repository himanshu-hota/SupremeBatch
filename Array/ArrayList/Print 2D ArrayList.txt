	
	public static void print2DArraylist(ArrayList<ArrayList<Integer>> arr) {
			
			for(int i=0 ; i < arr.size() ; i++) {
				for(int j =0 ; j<arr.get(i).size() ; j++) {
					System.out.print(arr.get(i).get(j) + " ");
				}
				System.out.println();
			}
	}