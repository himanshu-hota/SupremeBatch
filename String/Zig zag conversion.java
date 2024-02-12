public static String zigzagConversion(String s, int row) {


		// String array to store individual rows
		StringBuilder[] strs = new StringBuilder[row];
		
		// make individual row a string
		for(int k = 0; k<row; k++){
			strs[k] = new StringBuilder();
		}

		// pointer to each vharacter
		int i =0;
		// traverse the string
		while(i < s.length()){
		
			// top to bottom storing
			for(int j = 0; j<row && i< s.length() ; j++){
				strs[j].append((s.charAt(i)));
				i++;
			}

			// bottom to top storing
			for(int j = row-2; j>0 && i< s.length() ; j--){
				strs[j].append((s.charAt(i)));
				i++;
			
		}
		}	
		
		// final answer holder string
		StringBuilder ans = new StringBuilder();
		//append each row after one another
		for(StringBuilder str:strs){
			ans.append((str));
		}

		//convert stringbuilder to string
		return ans.toString();

	}


Note : 1. First wala for loop top to bottom store kar raha hai.
	   2. Second wala for loop bottom to top store kar raha hai. (first and last row ko chhod kar. why ? --> kyoki first loop loop handle kar leta hai is case ko, aur agar second wale for loop ko bhi n-1 -> 0 tak chalenge to n-1th and 0th row do do bar aa jaenge).



    Leetcode :- https://leetcode.com/problems/zigzag-conversion/

    CodeStudio :- https://www.codingninjas.com/codestudio/problems/zig-zag-conversion_3164695