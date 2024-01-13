class Pair { 
    String str;
    int index;

    Pair(String s, int i){
        this.str = s;
        this.index = i;
    }
}

class Solution {

    public Pair decode(String str, int index){

        StringBuilder curr = new StringBuilder();
        int num = 0;

        while(index < str.length()){
            
            char ch = str.charAt(index);
            
            if(Character.isDigit(ch)){
                num = num*10 + ch - '0';
            }else if(ch == '['){ // 
                Pair ans = decode(str,index+1);
                index = ans.index;
                curr.append(ans.str.repeat(num));
                num = 0;
            }else if(ch == ']'){
                return new Pair(curr.toString(), index);
            }else{
                curr.append(ch);
            }

            index++;
        }

        return new Pair(curr.toString(), index);

    }
    
    public String decodeString(String s) {
        return decode(s,0).str;
    }
}

Steps : 1. if found an digit then get the actual digit.
        2. if found '[' then 
            a. make recursive call for 'aage ka ans'.
            b. update the index ( will get the index from recursion until which solution has been generated).
            c. append the string got from recursion digit times in the ans string.
            d. reset the digit.
        3. if found ']' then we have to return ans till now.
        4. if found a alphabet then append it to ans string.


LeetCode : https://leetcode.com/problems/decode-string/description/