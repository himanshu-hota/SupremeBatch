// method 1

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();

        int i = 0;
        int open = 0;
        int start = 0;
        while(i < s.length()){

            char ch = s.charAt(i);

            if(ch == '(') open++;
            else if(ch == ')') open--;
            
            if(i>0 && open == 0){
                ans.append(s.substring(start+1,i));
                start = i+1;
            }
            

        i++;
        }

        return ans.toString();
    }
}

Note : 1. '(' ye mile to +1 kar do and ')' mile to -1.
       2. jab open 0 hoga to iska matlab ye hai ki abhi jis index pe hu aur last starting point k beech k paranthesis balanced hai, to ye beech wale paranthesis ans me add honge.
       3. start ko next se point kar to  kyoki is index tak ka ans store ho chuka hai.

// method 2

class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder ans = new StringBuilder();
        int count = 0;

        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                if(count > 0) ans.append(ch);
                count++;
            }else{
                if(count > 1) ans.append(ch);
                count--;
            }
        }

        return ans.toString();
    }
}

Special Note : 1. Balance tabhi hoga jab count even hoga (0 ko mat consider karna as even).  aur agar balanced hai to matlab hai ki ek valid pair mil gaya hai.
               
Steps : 1. If found '(' then increase the count.
        2. If found ')' then decrease the count.
        3. Include '(' only when you have more than 0 open paranthesis or in other words you have at least 1 open paranthesis.
        4. Include ')' only when you have more than 1 open paranthesis or in other words you have at least 1 open paranthesis to close it and make a pair .


CodeStudio : https://leetcode.com/problems/remove-outermost-parentheses/
