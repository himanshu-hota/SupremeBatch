
public class Solution {
	public static StringBuilder replaceSpaces(StringBuilder str) {
		if(str.length() == 0) return new StringBuilder();

		StringBuilder ans = new StringBuilder();

		int start = 0;
		int end = 0;

		while(end < str.length()){
            // processing for the last word.
			if(end == str.length() -1 ){
				ans.append(str.substring(start,end+1));
			}

            // processing for the rest words
			if(str.charAt(end) == ' '){
				ans.append(str.substring(start,end));
                // add '@40' instead of ' '
				ans.append("@40");
                // update starting point
				start = end+1;	
			}
			

			++end;
		}

		return ans;
	}
}

CodeStudio :- https://www.codingninjas.com/studio/problems/replace-spaces_1172172?leftPanelTab=0