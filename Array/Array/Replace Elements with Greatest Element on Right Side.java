

class Solution {

    public int[] replaceElements(int[] arr) {
        // maintain a max value till now
        int max = -1;
        for(int i= arr.length -1 ; i >=0 ; i--){
            // store thr current element
            int curr  = arr[i];
            // update the original array 
            arr[i] = max;
            // update the max
            max = Math.max(curr,max);
            
        }
        return arr;
    }
}

LeetCode :- https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

GFG :- https://practice.geeksforgeeks.org/problems/greater-on-right-side4305/1