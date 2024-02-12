// Method 1

import java.util.HashSet;

public class Solution {
    
    // Method to count substrings with exactly 'k' distinct characters
    public static int countSubStrings(String str, int k) {
        
        int n = str.length(); // Length of the input string
        int count = 0; // Initialize count of substrings
        
        // Loop through each character in the input string
        for(int i = 0; i < n; i++) {
            StringBuilder sub = new StringBuilder(); // StringBuilder to store the substring
            HashSet<Character> set = new HashSet<>(); // HashSet to store distinct characters
            
            // Loop through characters starting from index 'i'
            for(int j = i; j < n; j++) {
                char ch = str.charAt(j); // Get the character at index 'j'
                sub.append(ch); // Append the character to the substring
                set.add(ch); // Add the character to the set
                
                // If the size of the set becomes equal to 'k', increment count
                if(set.size() == k) {
                    count++;
                }
            }
        }
        
        return count; // Return the count of substrings with exactly 'k' distinct characters
    }
    
    public static void main(String[] args) {
        String str = "ababa";
        int k = 2;
        System.out.println("Count of substrings with exactly " + k + " distinct characters: " + countSubStrings(str, k));
    }
}


Note : Above method is derived from 'Subarray pattern of Array Section' where we Calculate each Subarray and then perform any operations.

Little optimized : 

import java.util.*;

public class Solution {
    public static int countSubStrings(String str, int k) {

        int n = str.length();
        int count = 0;

        for(int i = 0;i < n; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = i; j < n ; j++){
                char ch = str.charAt(j);
                set.add(ch);
                if(set.size() == k){
                    count++;
                }
            }
        }

        return count;
    }
}

Note : In Above we code we saw that there was no need of subarray string so we eliminated that.

// Method 2

import java.util.HashMap;

public class Solution {
    // Method to count substrings with exactly k distinct characters
    public static int countSubStrings(String str, int k) {

        // Get the length of the input string
        int n = str.length();
        // Initialize the count of substrings with k distinct characters
        int count = 0;

        // Iterate through all possible window sizes
        for (int window = 1; window <= n; window++) {
            // Initialize start and end pointers for the current window
            int start = 0;
            int end = window;

            // HashMap to store the frequency of characters within the current window
            HashMap<Character, Integer> map = new HashMap<>();

            // Populate the frequency map for the initial window
            for (int i = start; i < end; i++) {
                map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
            }

            // Check if the current window has k distinct characters
            if (map.size() == k) {
                count++;
            }

            // Slide the window through the entire string
            while (end < n) {
                // Update the frequency of characters as the window slides
                map.put(str.charAt(start), map.get(str.charAt(start)) - 1);
                if (map.get(str.charAt(start)) == 0) {
                    map.remove(str.charAt(start));
                }

                // Include the character at the new end position
                map.put(str.charAt(end), map.getOrDefault(str.charAt(end), 0) + 1);

                // Check if the updated window has k distinct characters
                if (map.size() == k) {
                    count++;
                }

                // Move the window forward
                start++;
                end++;
            }
        }

        // Return the final count of substrings with k distinct characters
        return count;
    }
}


Yaha galti karoge --> <= n tak window size hoga bhai kyoki n size k window ko bhi consider karna hai

Special Note : This technequie is derived from "Sum of beauty of all substring".

Logic : We will check for each window of size 1 -> <=n and check.

Steps : 1. Pick a window.
        2. Count distinct characters, if its count is k then increment the count.
        3. Move the window by excluding the first char of current window and including the next char.
        4. If the freq is 0 then remove it from the map.
        5. Calculate ans for next window.


CodeStudio : https://www.codingninjas.com/studio/problems/count-with-k-different-characters_1214627?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM