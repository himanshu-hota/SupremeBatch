    public String reorganizeString(String S) {
       // hash array to store frequencies
       int hash[] = new int[26];

       // step 1 :  hash the characters and their frequencies 
       for(int i = 0; i< S.length();  i++){
           hash[S.charAt(i) - 'a']++;
       }

       // step 2 : find the most occuring character
       int max = 0;
       int letter = 0;
       for(int i =0 ; i < hash.length; i++){
           if(max < hash[i]){
               max = hash[i]; // frequency
               letter = i;    // character
           }
       }

       // step 3 : check if solution is possible
       if(max > (S.length()+1) / 2){
           return "";
       }

       // step 4 : fill the most occuring character at non adjacent indices
       char ans[] = new char[S.length()];
       int idx =0;
       while(hash[letter] > 0){
            ans[idx] = (char)(letter + 'a'); // store character
            idx += 2;
            hash[letter]--; // decrease frequency
       }

       // step 5 : fill remaining characters
       for(int i = 0 ; i< hash.length;i++){
           while(hash[i] > 0){
               if(idx >= ans.length){ // if the idx exceeds the length then set it to 1
                   idx = 1;
               }
               ans[idx] = (char)(i + 'a'); // store character
               idx += 2;
               hash[i]--; // decrease frequency
           }
       }


        return String.valueOf(ans);
    }

    Leetcode :- https://leetcode.com/problems/reorganize-string/description/

    CodeStudio :- https://www.codingninjas.com/codestudio/problems/rearrange-string_982765?leftPanelTab=1