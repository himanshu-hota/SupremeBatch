static void readCharacter(char charArray[]) {
		Scanner sc = new Scanner(System.in);
		char ch = ' ';
		int i = 0;
		while(ch != '-' && i <charArray.length) {
			ch = sc.next().charAt(0);
			charArray[i] = ch;
			i++;
		}

	}