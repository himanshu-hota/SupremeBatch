class Solution {
    public boolean isIdealPermutation(int[] nums) {
        
        for(int i =0; i< nums.length ;i++){
            // if at any place the diff. is more than one than 1 then the count of gloabl and local inv. differs in count.
            if(Math.abs(i - nums[i]) >1) return false;
        }

        return true;

    }
}

// Observations : 1. 0 should alwaays be present at either 0th or 1th index.
//                2. Other number should always be present at any ot i, i+1, or i-1 index.
//                3. If this two rules are voilated then the count of global and local inversions will differ.
                

LeetCode : https://leetcode.com/problems/global-and-local-inversions/