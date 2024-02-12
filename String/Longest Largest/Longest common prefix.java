// Method 1

class Solution {
    // Function to find the longest common prefix among an array of strings
    public String longestCommonPrefix(String[] strs) {
        // Check if the input array is empty
        if (strs.length == 0) {
            return ""; // If empty, there is no common prefix, so return an empty string
        }

        // Take the first string as the reference for comparison
        String first = strs[0];

        // Iterate through each character of the first string
        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i); // Get the character at the current position

            // Compare the character with the corresponding position in other strings
            for (int j = 1; j < strs.length; j++) {
                String curr = strs[j]; // Get the current string for comparison

                // Check if the current string is shorter than the reference string
                // or if the characters at the current position are not the same
                if (i >= curr.length() || curr.charAt(i) != ch) {
                    // Return the common prefix found so far (up to the current position)
                    return first.substring(0, i);
                }
            }
        }

        // If all strings are the same, return the entire string as the common prefix
        return first;
    }
}


// Method 2


class Solution {
    // Function to find the longest common prefix among an array of strings
    public String longestCommonPrefix(String[] strs) {
        // Get the number of strings in the array
        int n = strs.length;

        // Check if the input array is empty
        if (n == 0) {
            return ""; // If empty, there is no common prefix, so return an empty string
        }
        
        // Check if there is only one string in the array
        if (n == 1) {
            return strs[0]; // If only one string, it is the common prefix
        }

        // Initialize an index variable to track the common prefix length
        int idx = 0;

        // Sort the array of strings lexicographically
        Arrays.sort(strs);

        // Get the first and last strings after sorting
        String first = strs[0];
        String last = strs[n - 1];

        // Compare characters at the same index in the first and last strings
        while ((idx < first.length() && idx < last.length()) && (first.charAt(idx) == last.charAt(idx))) {
            idx++;
        }

        // Return the common prefix found so far (up to the current index)
        return first.substring(0, idx);
    }
}


Steps : 1. Sort the array( this will arrange the strings lexicographically).
        2. Now by only comparing the first and the last string for equality we can tell how many characters are common.
        3. Return the part of the string that matches.

LeetCode : https://leetcode.com/problems/longest-common-prefix/