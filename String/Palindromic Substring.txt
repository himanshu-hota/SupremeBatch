   static void expand(String str , int left,int right,ArrayList<String> ans){
        
        // check and expand the string if it is palindromic
        while(left>=0 && right<str.length() && str.charAt(left) == str.charAt(right)){
            //add the substring only when length of palindromic substring is greater than 1
            if(!(left == right))
                ans.add(str.substring(left,right+1));
            right++;
            left--;
            
        }

        
    }
    public int CountPS(String str, int N)
    {
        //code here
        ArrayList<String> ans = new ArrayList<>();
        int count = 0;
        int n = str.length();
        for(int center =0 ; center < n ;center++){
            
            // get all palindromic substring of odd length
            expand(str,center,center,ans);
            
            // get all palindromic substring of even length
            expand(str,center,center+1,ans);
            
        }
        
        return ans.size();
    }


    GFG :- https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string0652/1

    ------------------------------------------------------------------------------------------------------------------

    static int expand(String str,int left , int right){
        int count = 0;

        // check and expand the string if it is palindromic
        while(left>=0 && right <str.length() && str.charAt(left) == str.charAt(right)){
            count++;
            left--;
            right++;
        }


        return count;
    }

    public int countSubstrings(String s) {
        
        int n = s.length();
        int count = 0;
        for(int center =0; center< n;center++){
            //odd ka answer || count all palindromic substring of odd length
            int oddKaAnswer = expand(s,center,center);
            count += oddKaAnswer;

            //even ka answer || count all palindromic substring of even length
            int evenKaAnswer = expand(s,center,center+1);
            count += evenKaAnswer;

        }

        return count;
    }

    LeetCode :- https://leetcode.com/problems/palindromic-substrings/description/

    CodeStudio :- https://www.codingninjas.com/codestudio/problems/palindromic-substrings_630404?leftPanelTab=1