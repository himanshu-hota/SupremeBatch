class Solution {
    int countZeroes(int[] arr, int n) {
        
        // if array has no elemens then ans would be 0.
        if(n == 0) return 0;
        
        // initial count of 0's and 1's.
        int zeroes = 0;
        int ones = 0;
        
        // traverse the array
        for(int x : arr){
            // if current element is 0 then increase the count of zeros
            if(x == 0) zeroes++;
            // if current element is 1 then increase the count of ones.
            else if(x == 1) ones++;
        }
        
        // Finally return ans.
        return zeroes;
    }

}

Steps:- 1. Traverse the array and keep count of zeroes and ones.
        2. Return the count of zeroes.

	
	GFG :- https://practice.geeksforgeeks.org/problems/count-the-zeros2550/1