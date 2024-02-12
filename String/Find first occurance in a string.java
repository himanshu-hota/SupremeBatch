// Method 1

    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        if(m == 0 || n == 0) return -1;
        if(m > n) return -1;

        // loop till n-m because if haystacks length is 10 and needles length is 5 then there is no sense to visit (10-5 +1)th index and after it because we wont find answer at any condition after (10-5+1)th index
          for(int i = 0; i <= n-m; i++){
            for(int j = 0; j < m ; j++){
                char hCh = haystack.charAt(i+j);
                char nCh = needle.charAt(j);

                if(hCh != nCh) break;

                //if we anyhow managed to reach till m-1 then we have found the answer index
                if(j == (m-1)){
                    return i;
                }
            }
        }

        return -1;
    }

// Method 2

class Solution {
    public int strStr(String haystack, String needle) {
        
        // Initialize pointers for haystack and needle
        int i = 0;
        int j = 0;

        // Get the lengths of haystack and needle
        int n = haystack.length();
        int m = needle.length();

        // Check for edge cases: if either needle or haystack is empty, or if needle is longer than haystack
        if(m == 0 || n == 0) return -1;
        if(m > n) return -1;

        // Iterate through the haystack
        while(i < n){
            // Get the characters at the current positions in haystack and needle
            char hCh = haystack.charAt(i);
            char nCh = needle.charAt(0);

            // Check if the current character in haystack matches the first character in needle
            if(hCh == nCh){
                // Reset the pointer for needle and create an index variable to track the starting position
                j = 0; 
                int index = i;
                int k = i;
                
                // Continue comparing characters in both haystack and needle
                while(j < m && k < n){
                    hCh = haystack.charAt(k);
                    nCh = needle.charAt(j);

                    System.out.println(nCh+ " " +hCh);

                    // If characters don't match, break the inner loop
                    if(hCh != nCh) break;

                    // Move to the next characters in both haystack and needle
                    k++;
                    j++;
                }

                // If inner loop completed (j reached the end of needle), return the starting index
                if(j == m) return index;
            }

            // Move to the next character in haystack
            i++;
        }

        // If no match is found, return -1
        return -1;
    }
}


Leetcode : https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/