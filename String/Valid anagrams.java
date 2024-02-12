// Method 1

class Solution {
    
    public boolean isAnagram(String s, String t) {

        // Check if the lengths of the two strings are different
        if (s.length() != t.length()) return false;

        // Initialize arrays to count the occurrences of characters in each string
        int map1[] = new int[256];
        int map2[] = new int[256];

        // Get the lengths of the strings
        int n1 = s.length();
        int n2 = t.length();

        // Initialize pointers for iterating through both strings
        int i = 0;
        int j = 0;

        // Count occurrences of characters in the first string (s)
        while (i < n1 && j < n2) {
            map1[s.charAt(i)]++;
            map2[t.charAt(j)]++;

            // Move to the next character in each string
            i++;
            j++;
        }

        // Compare the counts of characters in both strings
        i = 0;
        while (i < n1) {
            int x = map1[s.charAt(i)];
            int y = map2[s.charAt(i)];

            // If the counts are not equal, the strings are not anagrams
            if (x != y) return false;

            // Move to the next character in the first string
            i++;
        }

        // If all characters have the same count, the strings are anagrams
        return true;
    }
}


// Method 2

public boolean isAnagram(String a, String b) {

        // if length of both are not same then its not possible to have a anagram
        if(a.length() != b.length()){
            return false;
        }
        
        // array to track frequency
        int HashTable[] = new int[256];
        // temp fill array with 0
        Arrays.fill(HashTable,0);
        
        
        int i = 0;
        
        // iterate String 1 and decrease the value at the given character index
        while(i< a.length()){
            HashTable[a.charAt(i)]--;
         
            i++;
        }

        i = 0;
        // iterate String 1 and increase the value at the given character index
        while(i< b.length()){
         
            HashTable[b.charAt(i)]++;
            i++;
        }
        
        
        i =0;
        
        
       // if at any index the value is not zero then there are character whose frequency mismatch in both string hence it is not a valid anagram 
       while(i< 256){
            if(HashTable[i] != 0)        {
                return false;
            }
            i++;
        }
        
        
        // if everything looks good till here then it is a valid anagram
        return true;
    }

    // Method 3

    import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to character arrays
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        // Sort the character arrays
        Arrays.sort(charArrayS);
        Arrays.sort(charArrayT);

        // Compare the sorted arrays
        return Arrays.equals(charArrayS, charArrayT);
    }
}



    LeetCode :- https://leetcode.com/problems/valid-anagram/

    CodeStudio :- https://www.codingninjas.com/codestudio/problems/anagram-pairs_626517