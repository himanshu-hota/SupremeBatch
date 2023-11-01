class Solution {
    public int findMiddleIndex(int[] nums) {
          // Calculate the total sum of all elements in the array
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {

            // Add the current element to the left sum as we move to the next index
            leftSum += nums[i]; 
            // Calculate the sum of elements on the right side by subtracting the left sum from the total sum
            int rightSum = totalSum - (leftSum - nums[i])  ;
     
            if (leftSum == rightSum) {
                return i; // Found the pivot index
            }
           
        }

        return -1; // No pivot index found
    }
}

LeetCode : https://leetcode.com/problems/find-the-middle-index-in-array/

Exactly same question : https://leetcode.com/problems/find-pivot-index/