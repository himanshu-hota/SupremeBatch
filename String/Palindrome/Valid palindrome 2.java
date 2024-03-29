   static boolean checkPalindrome(String str){
        
         int i = 0; //first pointer
        int j = str.length() -1; //second pointer

        while(i<=j){

            if(str.charAt(i) != str.charAt(j)){ //if any how characters are not same then
                return false; // it is not palindrome
            }

            i++; // move first pointer toward right
            j--; // move second pointer toward left
        }

        return true;
    }

	public static boolean validPalindrome(int n, String str) {
		// Write your code here
		int i =0;   // first pointer
        int j = str.length()-1; // second pointer

        while(i < j){

            // check characters if they are not same then
         if(str.charAt(i) != str.charAt(j)){
                 // check for string by removing ith character || //check for string removing jth character    
           return checkPalindrome(str.substring(i+1, j+1))  || checkPalindrome(str.substring(i, j));
            
        }else{
            i++; // move first pointer toward right
            j--; // move second pointer toward left
        }
        }

        // if everything looks good then it is a palindrome string
        return true;
	}

    CodeStudio :- https://www.codingninjas.com/codestudio/problems/valid-palindrome_2663285?leftPanelTab=1

    Leetcode :- https://leetcode.com/problems/valid-palindrome-ii/description/ 