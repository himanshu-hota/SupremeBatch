class Solution {
    public int myAtoi(String s) {
        // Check if the input string is empty
        int n = s.length();
        if (n == 0) return 0;

        // Initialize variables
        int num = 0;  // The resulting integer
        int sign = 1; // The sign of the integer (1 for positive, -1 for negative)
        int i = 0;    // Index to traverse the input string

        // Skip leading whitespace characters
        while (i < n && s.charAt(i) == ' ') i++;

        // Check for a sign character (+/-)
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1; // Update sign based on the character
            ++i; // Move to the next character
        }

        // Process digits in the input string
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0'; // Convert the character to its numeric value

            // Check for overflow before updating num
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            num = num * 10 + digit; // Update num with the new digit
            ++i; // Move to the next character
        }

        // Return the final result with the correct sign
        return num * sign;
    }
}

Steps : 1. We first try to remove all blank/white spaces.
        2. Detect the sign of.
        3. Traverse till we find a digit and keep adding it to our answer.
        4. The case we have to handle when the num goes out of bound.

Speical Note :  if (num > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            This line checks if our num would exceed the Int range even after 1 iteration of the loop.
            In simple word we are checking if i add x to current num value , will it exceed or not , if exceeds then return the Int_max.

            

Leetcode :- https://leetcode.com/problems/string-to-integer-atoi/description/

CodeStudio :- https://www.codingninjas.com/codestudio/problems/atoi_981270?leftPanelTab=1