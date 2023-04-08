private static String expandAroundCenter(String s, int left, int right) {
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return s.substring(left+1, right);
}

    public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) {
        return s;
    }

    String longest = "";

    for (int i = 0; i < s.length(); i++) {
        // Find palindromes with odd length
        String oddPalindrome = expandAroundCenter(s, i, i);
        if (oddPalindrome.length() > longest.length()) {
            longest = oddPalindrome;
        }

        // Find palindromes with even length
        String evenPalindrome = expandAroundCenter(s, i, i+1);
        if (evenPalindrome.length() > longest.length()) {
            longest = evenPalindrome;
        }
    }

    return longest;
    }


    LeetCode :- https://leetcode.com/problems/longest-palindromic-substring/description/

    CodeStudio :- https://www.codingninjas.com/codestudio/problems/longest-palindromic-substring_892999