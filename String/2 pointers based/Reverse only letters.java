// method 1

class Solution {

    public boolean isLetter(char ch){
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))return true;
        else return false;
    }

    public String reverseOnlyLetters(String s) {
        StringBuilder ans = new StringBuilder(s);

        int i = 0;
        int j = s.length()-1;

        while(i<=j){
            char c1 = ans.charAt(i);
            char c2 = ans.charAt(j);

            boolean leftIsLetter = isLetter(c1);
            boolean rightIsLetter = isLetter(c2);
            boolean bothAreLetters = leftIsLetter && rightIsLetter;

            if(bothAreLetters){
                ans.setCharAt(i,c2);
                ans.setCharAt(j,c1);
                i++;
                j--;
            }else if(leftIsLetter && !rightIsLetter){
                j--;
            }else if(rightIsLetter && !leftIsLetter){
                i++;
            }else{
                i++;
                j--;
            }

        }


        return ans.toString();

    }
}

// method 2

class Solution {
     public String reverseOnlyLetters(String s) {

        // Create a StringBuilder to manipulate characters
        StringBuilder ans = new StringBuilder(s);

        // Initialize pointers for the start and end of the string
        int i = 0;
        int j = s.length() - 1;

        // Continue swapping letters until the pointers meet
        while (i < j) {

            // If character at 'i' is not a letter, move 'i' pointer forward
            if (!Character.isLetter(ans.charAt(i))) {
                i++;
            }
            // If character at 'j' is not a letter, move 'j' pointer backward
            else if (!Character.isLetter(ans.charAt(j))) {
                j--;
            }
            // If both characters at 'i' and 'j' are letters, swap them and move pointers
            else {
                char a = ans.charAt(i);
                char b = ans.charAt(j);

                ans.setCharAt(i, b);
                ans.setCharAt(j, a);

                i++;
                j--;
            }
        }

        // Return the string with reversed letters
        return ans.toString();
    }
}


Leetcode :- https://leetcode.com/problems/reverse-only-letters/

CodeStudio :- https://www.codingninjas.com/codestudio/problems/reverse-only-letters_1235236