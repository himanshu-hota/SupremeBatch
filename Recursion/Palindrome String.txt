   static boolean palindrome(String str, int i , int j){

        if(str.length() == 0) return false;
        if(i >= j) return true;
        
        if(str.charAt(i) != str.charAt(j)){
            return false;
        }

        return palindrome(str,i+1,j-1);


    }