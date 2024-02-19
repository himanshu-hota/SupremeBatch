import java.util.ArrayList;
import java.util.List;
public class Solution {

    public static void solve(String str,List<String> ans, int i , String output){

        if( i >= str.length()){
            ans.add(output);
            return;
        }

        // include
        solve(str,ans,i+1,output+str.charAt(i));

        // exclude
        solve(str,ans,i+1,output);
    }
    public static List<String> generateSubsequences(String s) {
        List<String> ans = new ArrayList<>();

        if(s.length() == 0) return ans;

        solve(s,ans,0,"");

        return ans;
    }
}

CodeStudio : https://www.codingninjas.com/studio/problems/print-subsequences_8416366?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf