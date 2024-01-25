	public static void takeInputInArrayList(ArrayList<Integer> arr) {
		int element = 0 ;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any element : ");
		while(element != -1) {
			
			element = sc.nextInt();
			System.out.print("Enter next element: ");
			if(element != -1)
				arr.add(element);
		}
		System.out.println();
		System.out.println();
	}