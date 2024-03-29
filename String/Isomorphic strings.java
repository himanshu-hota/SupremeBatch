public boolean isIsomorphic(String s, String t) {
    
    // if length of given strings are not equal then the are not isIsomorphic
    if(str1.length() != str2.length()){
			return false;
		}

		int map1[] = new int[256]; // map for first string
		int map2[] = new int[256]; // map for second string

        // traverse first string
		for(int idx = 0 ; idx < str1.length() ;idx++){

            // if element in both map at given index are not same then they are not isIsomorphic
			if(map1[str1.charAt(idx)] != map2[str2.charAt(idx)] ){
				return false;
			}

            // map elements
			map1[str1.charAt(idx)]  = idx+1;
			map2[str2.charAt(idx)]  = idx+1;
		}

        // if everything looks good then they are isomorphic
		return true;
    }

    Leetcode :- https://leetcode.com/problems/isomorphic-strings/description/

    CodeStudio :- https://www.codingninjas.com/codestudio/problems/check-if-two-given-strings-are-isomorphic-to-each-other_1117636?leftPanelTab=1