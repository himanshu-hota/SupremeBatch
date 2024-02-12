// Method 1

class Solution {

    public int beauty(String sub){
        if(sub.length() <= 2) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int map[] = new int[256];

        for(int i =0; i < sub.length(); i++){
            char ch = sub.charAt(i);
            int index = ch - 'a';
            map[index]++;
        }

        for(int x : map){
            if(x != 0){
                min = Math.min(min,x);
                max = Math.max(max,x);
            }
        }

        return max - min;
    }

    public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n ; j++){
                // why +1 ? --> beacause substring excludes the jth index. so we have to manually add +1 to include jth char for current subarray.
                String sub = s.substring(i,j+1);
                ans += beauty(sub);
            }
        }

        return ans;
    }
}

Notes : 1. Get each subarray.
        2. Count its beauty and add it to ans.
        3. How to count ? --> get count of each character in the substring, and then find the most and least occuring characters and then return its differences.
         

class Solution {

    public int beauty(int freq[]){

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int x : freq){
            if(x != 0){
                min = Math.min(min,x);
                max = Math.max(max,x);
            }
        }

        return max - min;

    }

    public int beautySum(String s) {
        
        int n = s.length();
        // if length is 2 or less then no need to calculate ans.
        if(n <= 2) return 0;

        int ans = 0;

        // we will start from window of size 3 and eventually expand the window size
        for(int window = 3 ; window <= n ; window++){
            
            // get window size
            int start = 0; 
            int end = window;

            // Count freq.
            int freq[] = new int[26];
            for(int i = start; i<end; i++){
                freq[s.charAt(i) - 'a']++;
            }

            // store ans and move window 
            ans += beauty(freq); // ans of current window

            while(end < n){
                freq[s.charAt(start) - 'a']--;
                freq[s.charAt(end) - 'a']++; 
                ans += beauty(freq); // ans of next window
                start++;
                end++;
            }

        }

        return ans;
    }
}

Logic : 1. If str = "a" then min occuring char will be 'a' as well max occuring char will be 'a' and diff is 1-1 => 0;
        2. str = "ab" min = 'a' or 'b' and max = 'a' or 'b' so diff = 1-1 => 0.
        3. str = "aa" min = 'a' or max = 'a' so diff = 2-2 => 0.
        
        So we see that if we have length less than 2 we dont need to calculate ans.

        Main idea is to we will take initial window size of at least 3 elements and then after each iteration will expand the window size for example 4, 5, 6 ....  <=n , yes <=n , not <. Why? -> because we want also to check for window size of lengh of string (full length of string).


Steps : 1. initially take window size of 3.
        2. Calculate freq of characters in the given window sized string.
        3. Calculate beauty of this window sized string and store it.
        4. Move the window by excluding the first char of current window and including the next char.
        5. Repeat above steps for window size of 3 -> <=n.

Leetcode : https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

GFG : https://www.geeksforgeeks.org/problems/sum-of-beauty-of-all-substrings-1662962118/1

CodeStudio : https://www.codingninjas.com/studio/problems/sum-of-beauty-of-all-substrings_8143656?leftPanelTabValue=SUBMISSION