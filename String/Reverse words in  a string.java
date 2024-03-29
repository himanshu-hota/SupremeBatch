class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();

        int start = 0;
        int end = s.length()-1;

        while(start <= end){
            // skip the spaces and get index of character.
            while (end >= 0 && s.charAt(end) == ' ') end--;
            int wordEnd = end + 1; // +1 because we are standing at space.
            // skip characters and get index of space.
            while (end >= 0 && s.charAt(end) != ' ') end--;
            int wordStart = end + 1; // +1 because i is exclusive

            // Get and add the word
            ans.append(s.substring(wordStart,wordEnd));

            if (end > 0) { // galti karoge >= nahi hoga kyoki first wale character k bad space nahi chahiye.
                ans.append(" "); // add a space between words
            }

            end--;

        }   

        // Edge case
        if(ans.charAt(ans.length()-1) == ' ') ans.deleteCharAt(ans.length() - 1);

        return ans.toString();
    }
}

LeetCode : https://leetcode.com/problems/reverse-words-in-a-string/