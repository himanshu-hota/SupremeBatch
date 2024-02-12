// Method 1

static boolean checkVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'|| ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }else {
            return false;
        }
    }

    public String reverseVowels(String s) {
        StringBuilder ans = new StringBuilder(s);

        int i =0 ;
        int j = s.length() -1;

        while(i < j){
            boolean c1 = checkVowel(ans.charAt(i)); // check is character is a vowel or not
            boolean c2 = checkVowel(ans.charAt(j)); // check is character is a vowel or not

            // if both the characters are vowel then only reverse 
            if(c1 && c2){
                char ch = ans.charAt(i);
                ans.setCharAt(i,ans.charAt(j));
                ans.setCharAt(j,ch);
                i++;
                j--;
            }else if(!c1){ // if starting character is not a vowel then move the pointer
                i++;
            }else{
                j--; // if ending character is not a vowel then move the pointer
            }

        }

        return ans.toString();
    }


// Method 2

class Solution {

    // Method to add vowels to the HashSet
    public void addVowels(HashSet<Character> vowels) {
        // List of vowels to add to the HashSet
        List<Character> valuesToAdd = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        vowels.addAll(valuesToAdd);
    }

    // Method to reverse vowels in a string
    public String reverseVowels(String s) {
        // HashSet to store vowels
        HashSet<Character> vowels = new HashSet<>();
        // StringBuilder to manipulate the characters
        StringBuilder ans = new StringBuilder(s);
        // Populate the HashSet with vowels
        addVowels(vowels);

        // Two pointers for swapping vowels in the string
        int i = 0;
        int j = s.length() - 1;

        // Iterate through the string until the pointers meet
        while (i <= j) {
            // Get characters at the pointers
            char first = s.charAt(i);
            char second = s.charAt(j);

            // If both characters are vowels, swap them and move the pointers
            if (vowels.contains(first) && vowels.contains(second)) {
                ans.setCharAt(i, second);
                ans.setCharAt(j, first);
                i++;
                j--;
            }
            // If only the first character is a vowel, move the second pointer
            else if (vowels.contains(first)) {
                j--;
            }
            // If only the second character is a vowel, move the first pointer
            else {
                i++;
            }
        }

        // Return the modified string
        return ans.toString();
    }
}


    Leetcode :- https://leetcode.com/problems/reverse-vowels-of-a-string/description/

    CodeStudio :- https://www.codingninjas.com/codestudio/problems/reverse-vowels-in-a-string_1231000?leftPanelTab=1