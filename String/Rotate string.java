// Mehod 1 

class Solution {
    // Method to check if one string can be obtained by rotating another string
    public boolean rotateString(String s, String goal) {
        // Initialize a variable to track the number of rotations
        int j = 0;

        // Iterate through the string s to perform rotations
        while(j < s.length()){
            // Perform rotation by moving the first character to the end
            String rotated = s.substring(1) + s.charAt(0);

            // Check if the rotated string matches the goal string
            if(rotated.equals(goal)) return true;

            // Update the string for the next iteration
            s = rotated;

            // Increment the rotation counter
            j++;
        }

        // If no match is found after all rotations, return false
        return false;
    }
}



Logic : Rotate the given string n times and check if any of the rotated string mathches the goal.

// Method 2 

public class Solution {
    public boolean rotateString(String s, String g) {
        // Check if the lengths of the strings are not equal
        if (s.length() != g.length()) {
            return false;
        }

        StringBuilder a = new StringBuilder(s);
        
        int j = 0;
        
        // Iterate through rotations
        while (j != s.length()) {
            // Perform rotation
            StringBuilder result = new StringBuilder(a.substring(1));
            result.append(a.charAt(0));

            // Check if the rotated string is equal to the target string
            if(rotated.toString().equals(goal)) return true;

            j++;
            a = result;
        }

        return false;
    }
}

// Optimized 

public class Solution {
    public boolean rotateString(String s, String g) {
        // Check if the lengths of the strings are not equal
        if (s.length() != g.length()) {
            return false;
        }

        // Concatenate the original string with itself
        String concatenated = s + s;

        // Check if the target string is a substring of the concatenated string
        return concatenated.contains(g);
    }
}


LeetCode : https://leetcode.com/problems/rotate-string/
