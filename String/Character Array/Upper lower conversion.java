// Lower case

static void lowerCase(char charArray[]) {
	for(int i =0 ; i< charArray.length ; i++) {
		if(charArray[i] >= 'A' && charArray[i] <= 'Z') {
		char newChar = (char)((int)charArray[i] - (int)'A'  + (int)'a');
		charArray[i] = newChar;	
		}
	}
}

// Upper case

static void upperCase(char charArray[]) {
	for(int i =0 ; i< charArray.length ; i++) {
		if(charArray[i] >= 'a' && charArray[i] <= 'z') {
		char newChar = (char)((int)charArray[i] - (int)'a' + (int)'A');
		charArray[i] = newChar;
		}
	}
}	


Shortcut : 1. toLower -> // System.out.println((char)(character + ('a' - 'A'))); 
		   2. toUpper -> // System.out.println((char)(character + ('A' - 'a')));	

How : 1. 'A' + ('a' - 'A') = 'a' // left wale 'A' me character fit karna hai.
	  2. 'a' + ('A' - 'A') = 'A' // left wale 'a' me character fit karna hai.