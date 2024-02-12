class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0, tPointer = 0;

        while (sPointer < s.length() && tPointer < t.length()) {
            // move the s pointer if the characters matches
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            
            tPointer++;
        }

        // if we have reached the end of the s string then it means that it is a sub.
        return sPointer == s.length();
    }
}



LeetCode :- https://leetcode.com/problems/is-subsequence/description/

GFG :- https://practice.geeksforgeeks.org/problems/check-for-subsequence4930/1

CodeStudio :- https://www.codingninjas.com/studio/problems/is-subsequence_892991?leftPanelTab=0