// Variant 1

// Method 1

  class Solution {
    public int compress(char[] chars) {

        int totalCount = 0;
        int occurence = 0;
        char prevChar = chars[0];
        int index = 0;
        for(char curr : chars ){

            if(curr == prevChar){
                occurence++;
            }else{

                // 1 wala case
                if(occurence <= 1){
                    chars[index++] = prevChar;
                    totalCount++;
                }else{  // jyada wala case

                    // store the char
                    chars[index++] = prevChar;
                    totalCount++;
                    // store its frequency
                    String num = Integer.toString(occurence);
                    totalCount += num.length();
                    for(char c : num.toCharArray()) chars[index++] = c;
                }
                
                // update the char and its occerence as we have store it.
                prevChar = curr;    
                occurence  = 1;
            }

            
        }

    
        // 1 wala case
        if(occurence <= 1){
            chars[index++] = prevChar;
            totalCount++;
        }else{  // jyada wala case

            // store the char
            chars[index++] = prevChar;
            totalCount++;
            // store its frequency
            String num = Integer.toString(occurence);
            totalCount += num.length();
            for(char c : num.toCharArray()) chars[index++] = c;
        }

        return totalCount;       
    }
}

// Mehtod 2

class Solution {
    public int compress(char[] chars) {

        int i = 0;
        int n = chars.length;
        int totalCount = 0;
        int index = 0;
        while( i < n ){
            char curr = chars[i];
            int freq = 1; // yaha par galti karoge, 0 mat karna isko

            while( i+1 < n && chars[i] == chars[i+1]){
                i++;
                freq++;
            }

            // store character
            chars[index++] = curr;
            totalCount++; // one increment for 1 character

            // store frequency
            if( freq > 1){
                String freqStr = Integer.toString(freq);
                totalCount += freqStr.length();
                for(char ch : freqStr.toCharArray()){
                    chars[index++] = ch;
                }
            }


            i++;
        }


        return totalCount;
    }
}

// Variant 2

// Mehtod 1

public class Solution {
	public static String getCompressedString(String str) {
		
        char chars[] = str.toCharArray();

        int index = 0;
        char prevChar = chars[0];
        int occurence = 0;

        for(char curr : chars){

            if( curr == prevChar){
                occurence++;
            }else{

                if(occurence <= 1){
                    chars[index++] = prevChar;
                }else{
                    // store char
                    chars[index++] = prevChar;
                    
                    // store freq
                    String freq = Integer.toString(occurence);
                    for(char ch : freq.toCharArray()) chars[index++] = ch;
                
                }

                // update char after storing and reset its occurence.
                occurence = 1;
                prevChar = curr;

            }

        }


        if(occurence <= 1){
            chars[index++] = prevChar;
        }else{
            // store char
            chars[index++] = prevChar;
                    
            // store freq
            String freq = Integer.toString(occurence);
            for(char ch : freq.toCharArray()) chars[index++] = ch;
                
        }


        String ans = new String(chars);

        return ans.substring(0,index);
	}

}

// Mehtod 2

public class Solution {
	public static String getCompressedString(String str) {
		
        int n = str.length();
        int index = 0;
        StringBuilder ans = new StringBuilder();
        int i = 0;
        
        while(i < n){
            char curr = str.charAt(i);
            int count = 1;

            // get frequency
            while(i+1 < n && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }

            // store character
            ans.append(curr);

            // store frequency
            if(count > 1){
                String freq = Integer.toString(count);
                ans.append(freq);
            }
            i++;

        }

        return ans.toString();
	}

}

Leetcode :- https://leetcode.com/problems/string-compression/submissions/931079022/

CodeStudion :- https://www.codingninjas.com/codestudio/problems/compress-the-string_526