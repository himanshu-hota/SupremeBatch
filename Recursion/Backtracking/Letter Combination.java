// Method 1

class Solution {

    // This method recursively generates all possible combinations of letters corresponding to the given digits
    static void solve(List<String> phone, List<String> ans, int index, String digits, StringBuilder output) {
        if (index >= digits.length()) {
            ans.add(output.toString());  // Add the generated combination to the answer list
            return;
        }

        int digit = (int)(digits.charAt(index) - '0');  // Get the digit at the current index
        String value = phone.get(digit);  // Get the corresponding letters for the digit
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);  // Get each letter from the digit's corresponding letters
            output.append(ch);  // Append the letter to the output string
            solve(phone, ans, index + 1, digits, output);  // Recursive call to generate combinations for the next digit
            output.deleteCharAt(output.length() - 1);  // Remove the last added letter from the output string
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();  // List to store all generated combinations
        if (digits.length() == 0) {
            return ans;  // If no digits are provided, return an empty list
        }

        List<String> phone = new ArrayList<>();  // List to store the mapping of digits to letters
        phone.add(" ");
        phone.add(" ");
        phone.add("abc");
        phone.add("def");
        phone.add("ghi");
        phone.add("jkl");
        phone.add("mno");
        phone.add("pqrs");
        phone.add("tuv");
        phone.add("wxyz");

        int index = 0;  // Starting index for generating combinations
        StringBuilder output = new StringBuilder();  // StringBuilder to build the output combinations

        solve(phone, ans, index, digits, output);  // Call the solve method to generate all combinations
        return ans;  // Return the generated combinations
    }
}


// Rishta wahi soch nayi

class Solution {

    // Recursive function to generate letter combinations
    private void solve(String digits, List<String> ans, List<String> phone, int index, StringBuilder output) {

        // Base case: when the index exceeds the length of the input digits
        if (index >= digits.length()) {
            // Add the current combination to the result list
            ans.add(output.toString());
            return;
        }

        // Get the digit at the current index
        int digit = digits.charAt(index) - '0';
        // Get the corresponding letters for the digit from the phone mapping
        String values = phone.get(digit);

        // Iterate through the letters for the current digit
        for (int i = 0; i < values.length(); i++) {
            // Append the current letter to the output
            output.append(values.charAt(i));
            // Recursively call the function for the next index
            solve(digits, ans, phone, index + 1, output);
            // Backtrack: remove the last character to try other combinations
            output.deleteCharAt(output.length() - 1);
        }
    }

    // Main function to generate letter combinations for a given set of digits
    public List<String> letterCombinations(String digits) {

        // Result list to store generated combinations
        List<String> ans = new ArrayList<>();

        // Check if the input digits are empty
        if (digits.length() == 0) return ans;

        // Mapping of digits to corresponding letters on a phone keypad
        List<String> phone = Arrays.asList("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");

        // Call the recursive function to generate combinations
        solve(digits, ans, phone, 0, new StringBuilder());

        // Return the final list of combinations
        return ans;
    }
}

// Method 2 

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

	public static void solve(String s,int i,ArrayList<String> ans,ArrayList<String> phone,String str){
		if(i>=s.length()){
			ans.add(str);
			return;
		}

		int digit = s.charAt(i) - '0';
		String values = phone.get(digit);

		for(int idx = 0; idx < values.length(); idx++){
			char value = values.charAt(idx);
			solve(s,i+1,ans,phone,str+value);
		}
	}
    public static ArrayList<String> combinations(String s){
	
		ArrayList<String> ans = new ArrayList<>();

		ArrayList<String> phone = new ArrayList<>();
	

		phone.addAll(Arrays.asList(" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"));

		solve(s,0,ans,phone,"");

		return ans;

	}
}

Notes: 1. Firstly we create a map that map 0 -> 9 with corresponding string values.
       2. Make recursive call.
       3. If we anyhow make it to reach till end of the digits string then we have successfully consumed all the characters.
       4. Get the digit in number from the digits string.
       5. Get its corresponding string value.
       6. Now we have to map each of its character to characters of remaining digits.
       7. Traverse the received string value of the digit.
       8. Add 1 character each time and make recursive call for rest of its characters. 

LeetCode :- https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
CodeStudio :- https://www.codingninjas.com/codestudio/problems/letter-combinations-of-a-phone-number_983623?leftPanelTab=1  