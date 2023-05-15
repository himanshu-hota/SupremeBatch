    static void reverseString(StringBuilder str, int i,int j){
        if(i > j  || str.length() == 0){
            return ;
        }

        char c = str.charAt(i);
        str.setCharAt(i,str.charAt(j));
        str.setCharAt(j,c);

        // Recursive call        
        reverseString(str,i+1,j-1);

    }