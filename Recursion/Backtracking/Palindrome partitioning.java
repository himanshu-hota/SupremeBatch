import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Main method to partition the input string into palindrome substrings
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();

        // Check if the input string is empty
        if (s.length() == 0) return ans;

        List<String> path = new ArrayList<>();

        // Start the recursive partitioning process
        solve(s, 0, ans, path);

        return ans;
    }

    // Recursive method to find all possible palindrome partitions
    public void solve(String s, int idx, List<List<String>> ans, List<String> path) {

        // Base case: if the current index is beyond the string length, add the current path to the answer
        if (idx >= s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Iterate through the string starting from the current index
        for (int i = idx; i < s.length(); i++) {

            // Check if the substring from the current index to i is a palindrome
            if (isPalindrome(s, idx, i)) {
                // If it is a palindrome, add it to the current path and continue with the next index
                path.add(s.substring(idx, i + 1));
                solve(s, i + 1, ans, path);
                // Backtrack: remove the last added substring for the next iteration
                path.remove(path.size() - 1);
            }
        }
    }

    // Helper method to check if a substring is a palindrome
    public boolean isPalindrome(String str, int start, int end) {

        // Check if the substring is a palindrome using two pointers approach
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }

        return true;
    }
}


Steps : 1. We go to each index and try to do partitioning, if we were able to perform partitioning then we make recursive call for rest of the string from next index. 
        2. If we were not able to perform partitioning then simply skip this index and go to next index.

Special Note : We only make recursive call when we are able to make a partitioning( keep in mind ).

LeetCode : https://leetcode.com/problems/palindrome-partitioning/description/