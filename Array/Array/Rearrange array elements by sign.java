class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        int n = nums.length;

        // index to put positive elements
        int pos = 0;
        // index to put negative elements
        int neg = 1;

        int ans[] = new int[n];

        for(int x : nums){
            // if num is positive then put it in pos index otherwise neg index.
            if(x >=0 ){
                ans[pos] = x;
                pos += 2;
            }else{
                ans[neg] = x;
                neg += 2;
            }
        }

        return ans;
    }
}

LeetCode : https://leetcode.com/problems/rearrange-array-elements-by-sign/

CodeStudio : https://www.codingninjas.com/studio/problems/alternate-numbers_6783445?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM