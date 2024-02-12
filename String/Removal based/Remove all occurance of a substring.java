// Method 1 

public String removeOccurrences(String s, String part) {
        // Create a StringBuilder to represent the mutable string
        StringBuilder ans = new StringBuilder(s);

        // Get the length of the part to be removed
        int len = part.length();

        // Continue removing occurrences until none are left
        while (ans.indexOf(part) != -1) {
            // Find the index of the first occurrence of the part
            int index = ans.indexOf(part);

            // Delete the occurrence from the StringBuilder
            ans.delete(index, index + len);
        }

        // Convert the StringBuilder back to a string and return the result
        return ans.toString();
}


// Method 2

public String removeOccurrences(String s, String part) {
    // Get the length of the input string and the part to be removed
    int n = s.length();
    int len = part.length();

    // Continue removing occurrences until none are left
    while (s.indexOf(part) != -1) {
        // Find the index of the first occurrence of the part
        int index = s.indexOf(part);

        // Remove the part by concatenating the substrings before and after it
        s = s.substring(0, index) + s.substring(index + len, n);
    }

    // Return the modified string after removing all occurrences of the specified part
    return s;
}


LeetCode : https://leetcode.com/problems/remove-all-occurrences-of-a-substring/submissions/1103278842/

