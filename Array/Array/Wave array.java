class Solution {
    public static void convertToWave(int n, int[] a) {
        // code here
        
        int start =0;
        int end = 1;
        
        while(end<n){
            
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start += 2;
            end += 2;
            
        }
    }
}

GFG : https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1