// Method 1 

class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[256];

        // Populate the character frequency array
        for (char ch : s.toCharArray()) {
            map[ch]++;
        }

        // Find the index of the first unique character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(map[ch]  == 1) return i;
        }

        // Return -1 if no unique character is found
        return -1;
    }
}

Steps : 1. Map the frequencies.
        2. Traverse the string from left(start) and check if we find any character with frequency 1 then it appeared only once in the entire string and it is the first char that is unique, so this is the our answer.


// Method 2

class Solution {
    // array to track frequency 
    static int freq[] = new int[26];

    static void getCount(String s){
        // initialize all values as 0
        Arrays.fill(freq,0);
        
        for(int i = 0; i< s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        } 

    }
    public int firstUniqChar(String s) {
        if(s.length() <= 0) return -1;
       
        // store frequencies
        getCount(s);


        // traverse the string
        for(int i = 0; i< s.length(); i++){
            // if found any character with freq 1 then return it
            if(freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }

        // if found none then return -1
        return -1;
    }
}


LeetCode :- https://leetcode.com/problems/first-unique-character-in-a-string/description/

GFG :- https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

CodeStudio :- https://www.codingninjas.com/studio/problems/first-non-repeating-character_920324?leftPanelTab=1