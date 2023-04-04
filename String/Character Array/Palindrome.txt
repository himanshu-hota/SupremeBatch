static void palindrome(char charArray[]) {
		
		int n = charArray.length;
		int j = n-1;
		for(int i = 0 ; i<=n/2 ;i++) {
			
			if(!(charArray[i] == charArray[j])) {
				System.out.println("Not plaindrome");
				return;
			}
			j--;
		}
		
		System.out.println("It is a palindrome string");
		
}