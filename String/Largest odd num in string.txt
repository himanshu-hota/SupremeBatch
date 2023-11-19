class Solution {
    public String largestOddNumber(String num) {
        

        for(int i = num.length() - 1  ; i>= 0; i--){
            if((num.charAt(i)&1) == 1){
                return num.substring(0,i+1);
            }
        }

        return "";
    }
}

Steps : 1. Traverse from end.
        2. If found any odd digit the return the string till here as it is the max odd num we can make.

        
LeetCode : https://leetcode.com/problems/largest-odd-number-in-string/submissions/1100011884/