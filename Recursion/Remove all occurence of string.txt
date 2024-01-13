// Recursive method

     public static String removeString(String str, String removeStr) {
        int index = str.indexOf(removeStr);
        if (index == -1) {
            return str; // Base case: removeStr not found in str
        }
        String modifiedStr = str.substring(0, index) + str.substring(index + removeStr.length());
        return removeString(modifiedStr, removeStr); // Recursive call to removeString()
    }


// Time complexity :- O(NM)                     N = str.length() M = part.size()


// Iterative method

class Solution {
    public String removeOccurrences(String s, String part) {
       
       int pLen = part.length();
       String ans = "";
       
       while(s.indexOf(part) != -1){
           int index = s.indexOf(part);
           s =  s.substring(0,index) + s.substring(index + pLen, s.length());
       }

       return s;
    }
}

// LeetCode : https://leetcode.com/problems/remove-all-occurrences-of-a-substring/submissions/1137260615/