 static int isPalindrome(String str) {
        
        
        int i = 0; //first pointer
        int j = str.length() -1; //second pointer

        while(i<=j){

            if(str.charAt(i) != str.charAt(j)){ //if any how characters are not same then
                return 0; // it is not palindrome
            }

            i++; // move first pointer toward right
            j--; // move second pointer toward left
        }

        return 1;
    }

    GFG :- https://practice.geeksforgeeks.org/problems/palindrome-string0817/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

    