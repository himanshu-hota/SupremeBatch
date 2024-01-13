class Solution {

    static int robHelper(int arr[] , int i){
        if(i >= arr.length){
            return 0;
        }

        int lootFromCurrentHome = arr[i] + robHelper(arr,i+2); // rob from current house
        int lootFromNextHome = 0 + robHelper(arr,i+1); // rob from next house

        return Math.max(lootFromCurrentHome,lootFromNextHome); // return max looted amount 
         
    }

    public int rob(int[] nums) {
        int ans = robHelper(nums,0);
        

        return ans;
    }
}

LeetCode : https://leetcode.com/problems/house-robber/

CodeStudio : https://www.codingninjas.com/studio/problems/loot-houses_630510