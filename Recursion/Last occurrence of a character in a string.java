class Solution {

    // Helper method to find the last index of character 'p' in string 's' starting from index 'i'
    int helper(String s, char p, int i) {
        // Base case: if the index 'i' goes below 0, character 'p' not found in the remaining string
        if (i < 0) return -1;

        // If the character at index 'i' is equal to 'p', return the current index
        if (s.charAt(i) == p) return i;

        // Recursive case: call the helper method with the updated index 'i-1'
        return helper(s, p, i - 1);
    }

    // Main method to find the last index of character 'p' in string 's'
    int LastIndex(String s, char p) {
        // Call the helper method starting from the end of the string (s.length() - 1)
        return helper(s, p, s.length() - 1);
    }
}


GFG : https://www.geeksforgeeks.org/problems/last-index-of-a-character-in-the-string4516/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article