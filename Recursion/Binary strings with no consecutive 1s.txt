import java.util.*;

public class Solution {

    // This method generates all possible strings of length N
    // with the condition that there are no consecutive '1's.
    public static void solve(String output, int i, List<String> ans, int n) {
        // If the string reaches the desired length, add it to the result list
        if (i >= n) {
            ans.add(output);
            return;
        }

        // Recursive call for the case where the current digit is '0'
        solve(output + "0", i + 1, ans, n);

        // Recursive call for the case where the current digit is '1'
        // But only if the last character is not '1' to avoid consecutive '1's
        if (output.length() == 0 || output.charAt(output.length() - 1) != '1') {
            solve(output + "1", i + 1, ans, n);
        }
    }

    // This method generates all strings of length N with the specified conditions.
    public static List<String> generateString(int N) {
        List<String> ans = new ArrayList<>();

        // If N is 0, there are no strings to generate, return an empty list
        if (N == 0) return ans;

        // Initialize an empty string and start the recursive generation
        String output = "";
        int i = 0;
        solve(output, i, ans, N);

        // Return the list of generated strings
        return ans;
    }
}

Notes : 1. At any particular index there are two possible value, either '0' or '1', so try all combinations, where we can put either '0' or '1'.
        2. But dont put 1 if the previous element was also 1.


CodeStudio : https://www.codingninjas.com/studio/problems/-binary-strings-with-no-consecutive-1s._893001?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
