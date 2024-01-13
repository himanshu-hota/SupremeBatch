class Solution {

    static boolean helper(String s , int si ,String p, int pi){
        // if no characters left to match then it is the answer
        if(si == s.length() && pi == p.length()){
            return true;
        }

        // if part has remaining characters then it must be '*' otherwise solution not possible
        if(si == s.length() && pi < p.length()){
            while(pi<p.length()){
                if(p.charAt(pi) != '*') return false;
                pi++;
            }
            return true;
        }

        // if characters matches then move to next check
        if(pi < p.length() && si < s.length())
        if(s.charAt(si) == p.charAt(pi) || '?' == p.charAt(pi)) return helper(s,si+1,p,pi+1);
        
        // if found any '*' then there are two possible solution
        if(pi < p.length() && si < s.length())
        if(p.charAt(pi) == '*'){
            // treat '*' as null
            boolean case1 = helper(s,si,p,pi+1);
            // treat '*' as 1 character
            boolean case2 = helper(s,si+1,p,pi);
            return case1 || case2;
        }

        // characters didn't match'
        return false;
    }

    public boolean isMatch(String s, String p) {
        return helper(s,0,p,0);
    }
}


// Cleaner way 


    public boolean solve(String s,int si, String p,int pi){
        if(si >= s.length() && pi >= p.length()) return true;
        if(si < s.length() && pi >= p.length()) return false;
        if(si >= s.length() && pi < p.length()){
            for(int i = pi; i < p.length(); i++){
                if(p.charAt(i) != '*') return false;
            }

            return true;
        }
        boolean way1 = false;
        boolean way2 = false;

        if(s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?'){
            way1 = solve(s,si+1,p,pi+1);
        }

        if(p.charAt(pi) == '*'){
            way2 = solve(s,si+1,p,pi) || solve(s,si,p,pi+1);
        }

        return way1 || way2;
    }

LeetCode : https://leetcode.com/problems/wildcard-matching/description/