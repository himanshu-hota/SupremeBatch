// Method 1

public class Solution {
    
    // Function to remove consecutive duplicates from a string
    public static String removeConsecutiveDuplicates(String s) {
        
        // StringBuilder to store the result without consecutive duplicates
        StringBuilder ans = new StringBuilder();
        
        // Initialize index variable
        int i = 0;
        
        // Iterate through the input string
        while (i < s.length()) {
            // Check if the result is empty or the last character is not equal to the current character
            if (ans.length() == 0 || ans.charAt(ans.length() - 1) != s.charAt(i)) {
                // Append the current character to the result
                ans.append(s.charAt(i));
            }
            
            // Move to the next character in the input string
            i++;
        }
        
        // Convert the StringBuilder to a string and return the result
        return ans.toString();
    }
}


// Method 2

public static String removeConsecutiveDuplicates(String s) {

		// Write your code here

        
		StringBuilder ans = new StringBuilder("");

		int i = 0;

		while(i < s.length()){
			int len = ans.length();

            //if our answer string has any character then only proceed further
			if(len > 0){
				//if last character of our answer string and current character are same then dont add it to answer
				if(!(ans.charAt(len-1) == s.charAt(i))){
					ans.append(s.charAt(i));
				}

			}else{ // if answer string is empty then add the current character
				ans.append(s.charAt(i));
			}

            // move to next character
			i++;
		}

        // convert stringbuilder to string and return it
		return ans.toString();
	}

// Method 2


public class Solution {
	public static String removeConsecutiveDuplicates(String s) {

        // If the length of the input string is 0 or 1, no duplicates to remove
        if (s.length() <= 1) {
            return s;
        }

        // Create a StringBuilder to store the result, initially with the first character
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));

        // Initialize pointers for traversal
        int i = 0;
        int n = s.length();

        // Iterate through each character in the input string
        while (i < n) {

            // Get the current character
            char ch = s.charAt(i);

            // If the current character is different from the last character in the result
            if (ans.charAt(ans.length() - 1) != ch) {
                // Append the current character to the result
                ans.append(ch);
            }

            // Move to the next character
            i++;
        }

        // Return the result as a string
        return ans.toString();
    }

}

Steps : 1. Create a string and initially add the first character fo the given string.
		2. Now iterate through the given string and check whether the last character of the ans string is same as currect character , if yes then dont add this character to ans.
		


CodeStudio :- https://www.codingninjas.com/codestudio/problems/remove-consecutive-duplicates_893195?leftPanelTab=1