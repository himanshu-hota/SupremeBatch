class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        // store final answer
        StringBuilder ans = new StringBuilder();
        // pick first string to compare with rest
        String first = strs[0];

		// loop till first string has characters
        for(int i = 0 ; i<first.length();i++){
            char ch = first.charAt(i);
            boolean match = true;

			// traverse rest strings
            for(int j = 1; j < strs.length; j++){
				// grab the jth string
                String curr = strs[j];
				// check if character mismatch or
				// current string is smaller
                if( curr.length() <= i || curr.charAt(i) != ch){
                    match = false;
                    break;
                }
            }

			// if ch is matched then add it to ans
            if(match){
                ans.append(ch);
            }else{
				// otherwise break the loop because we wont find matches anymore
                break;
            }
        }

        return ans.toString();
    }
}




---------------------- Sorting ------------------

	public static String longestCommonPrefix(String[] arr, int n) {
		// if array is null or has only one string then return empty string
		if(arr == null || arr.length <0){
			return "";
		}

        // index counter
		int idx =0;

        // sort array in lexicographical order so that we can track prefix easily
		Arrays.sort(arr);
        // grab first string
		StringBuilder s1 = new StringBuilder(arr[0]);
        // grab last string
		StringBuilder s2 = new StringBuilder(arr[n-1]);

        // loop till index count is less than length of both strings
		while(idx < s1.length() && idx < s2.length()){
			if(s1.charAt(idx) == s2.charAt(idx)){ // go forward only if both characters at same index are same
				idx++;
			}else{
				break; // else break the loop
			}
		}

        // return the longest common prefix part of the string
		return s1.substring(0,idx);

	}


------------------------------ other way -----------------------------------

class Solution {
    public String longestCommonPrefix(String[] v) {
        
        // store final answer
        StringBuilder ans = new StringBuilder();
        
        // sort lexicographically 
        Arrays.sort(v);
        // get first string
        String first = v[0];
        // get last string
        String last = v[v.length-1];
        // get the length of smaller string among first and last string
        int smallerString = Math.min(first.length(), last.length());

        for(String x : v) System.out.println(x);

        // iterat thsese two string till the smaller string ends
        for (int i=0; i<smallerString; i++) {
            // at any point the characters mismatches return the stored answer
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            // append current character to final ans
            ans.append(first.charAt(i));
        }

        // if we reach till here the both strings are identical
        return ans.toString();
    }
}

LeetCode :- https://leetcode.com/problems/longest-common-prefix/description/

CodeStudio :- https://www.codingninjas.com/codestudio/problems/longest-common-prefix_2090383