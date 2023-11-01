class Solution{
    static int findSingle(int N, int arr[]){
        // code here
        
        int ans = 0;
        
        for(int x : arr) ans ^= x;
        
        return ans;
    }
}

Note : it is the same question as the "The number that appears only once" (LeetCode).

GFG :- https://practice.geeksforgeeks.org/problems/alone-in-couple5507/1

LeetCode :- https://leetcode.com/problems/single-number/description/