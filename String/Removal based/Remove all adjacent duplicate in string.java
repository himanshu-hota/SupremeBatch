// Method 1 

public String removeDuplicates(String s) {
        // Get the length of the input string
        int n = s.length();

        // If the string has 0 or 1 characters, no duplicates to remove
        if (n <= 1) return s;

        // Create a StringBuilder to store the result without consecutive duplicates
        StringBuilder ans = new StringBuilder();
        
        // Initialize the index to traverse the input string
        int i = 0;

        // Iterate through each character in the input string
        while (i < n) {
            // Get the current character
            char ch = s.charAt(i);

            // If the result StringBuilder is not empty and the last character is equal to the current character,
            // remove the last character to avoid consecutive duplicates
            if (ans.length() > 0 && ans.charAt(ans.length() - 1) == ch) {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                // Append the current character to the result StringBuilder
                ans.append(ch);
            }

            // Move to the next character in the input string
            i++;
        }

        // Return the result as a string without consecutive duplicate characters
        return ans.toString();
    }


// Method 2

 public static String removeDuplicates(String s) {

        //we are using StringBuilder because it is faster than regular string and StringBuffer
        StringBuilder ans = new StringBuilder("");
        
        int i = 0; 
        while(i<s.length()){


            int len = ans.length();

             //if our answer has any character then do further operations
             if(len > 0){
                 
                 //if last character of our answer and the current character are same then it will be adjacent 
                 if(ans.charAt(len-1) == s.charAt(i)){
                    ans.delete(len-1,len);
                }else{
                    ans.append(s.charAt(i)); // if they are not same then append it to our answer
                }
             
             }else{ //else put the character in tha answer

                ans.append(s.charAt(i));
                 
             }

             // go to next character
             i++;
        }

        return ans.toString();
    }


    Leetcode :- https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
    