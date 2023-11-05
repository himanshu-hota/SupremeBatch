public class Solution {
    public static int isSorted(int n, int []a) {
        
        // assum this -1 is present at index -1;
        int prev = -1;

        // now check if we find any elemenet that is smaller than its perv than array is not sorted.
        for(int x : a){
            if(x < prev) return 0;
            prev = x;
        }

        return 1;
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/ninja-and-the-sorted-check_6581957?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM