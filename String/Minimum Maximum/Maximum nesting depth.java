public class Solution {
    public static int maxDepth(String s) {

        int max = Integer.MIN_VALUE;
        int open = 0;

        for(int i = 0; i< s.length() ; i++){

            char ch = s.charAt(i);
            if(ch == '('){
                open++;
                max = Math.max(open,max);
            }else if(ch == ')'){
                open--;
            }
        }

        return max;
    }
}

Special Note : You might think that by only counting the opening paranthesis will get the answer, but that would count all open paranthesis irrespective of valid pairs. Thats why we have to decrease the count we found a valid pair.

Steps : 1. When found '(' increment the count, and update the max with current count of valid open paranthesis.
        2. When found ')' decrement the count.
        

CodeStudio : https://www.codingninjas.com/studio/problems/maximum-nesting-depth-of-the-parentheses_8144741?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION