	static void readString(char charArray[]) {
		Scanner sc = new Scanner(System.in);
		charArray = sc.nextLine().toCharArray();
		for(char c : charArray) {
			System.out.print(c );
		}
		System.out.println();
		
	}