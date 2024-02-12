import java.util.* ;
import java.io.*; 

public class Solution {

    // Method to convert the first letter of each word in the string to uppercase
    public static String convertString(String str) {
        
        // Create a StringBuilder object to modify the string
        StringBuilder s = new StringBuilder(str);    
        
        // Get the length of the string
        int n = str.length(); 

        // Iterate through each character in the string
        for(int i = 0; i < n ; i++) {
            
            // Check if the current character is the first character of the string or follows a space
            if(i == 0 || (i > 0 && s.charAt(i-1) == ' ')) {
                // Retrieve the character at the current index
                char ch = s.charAt(i);
                // Check if the character is a lowercase letter
                if(ch >= 'a' && ch <= 'z') {
                    // Convert the lowercase letter to uppercase
                    char upperCasedChar = (char)(ch + ('A' - 'a'));
                    // Update the character at the current index with the uppercase letter
                    s.setCharAt(i, upperCasedChar);
                }
            }
        }

        // Convert the StringBuilder object back to a string and return
        return s.toString();
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/convert-string_1062635