// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {
    public static void main(String[] args) {
        // Write your code here
        
        StringBuilder str = new StringBuilder("abcd");
        printPermu(str,0);
    }

    static void printPermu(StringBuilder str,int i){
        if(i >= str.length()){
            System.out.println(str);
            return;
        }

        for(int j =i ;j<str.length();j++){
            //swap to create new permutation
            char ch = str.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j,ch);

            //call
            printPermu(str,i+1);

            // swap again (backtracking) to change string back to original so that further calculation will be on correct string
            ch = str.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j,ch);

        }
    } 
}