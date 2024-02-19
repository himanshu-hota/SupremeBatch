
// method 1

    static void subStr(String str,String output){
        if(str.length() ==0){
            System.out.println(output);
            return;
        }

        //exclude
        subStr(str.substring(1),output);

        //include
        subStr(str.substring(1),output + (str.charAt(0)));
    } 


    // method 2

       static void subStr(String str,String output,int i){
        if(i >= str.length() ){
            System.out.println(output);
            return;
        }

        //exclude
        subStr(str,output,i+1);
        
        //include
        subStr(str,output+  str.charAt(i),i+1);
    }


    CodeStudio : https://www.codingninjas.com/studio/problems/all-substrings_1262347