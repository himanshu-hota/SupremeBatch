	static void reverseCharArray(char charArray[]) {
		int i =0,j =charArray.length-1;
		
		while(i<=j) {
			char c = charArray[i];
			
			charArray[i] = charArray[j];
			charArray[j] = c;
			
			i++;
			j--;
		}
		
		System.out.print("Reversed character array : " );
		for(char c : charArray) {
			System.out.print(c);
		}
		
		System.out.println();
//		for(int i = charArray.length-1;i>=0;i--) {
//			System.out.println(charArray[i]);
//		}
		
	}
	
