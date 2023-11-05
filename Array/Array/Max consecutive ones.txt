class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0; // Initialize a variable to keep track of the current consecutive ones.
        int max = 0;   // Initialize a variable to keep track of the maximum consecutive ones found so far.

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count = 0; // Reset the count to zero when a zero is encountered, as consecutive ones are broken.
            } else {
                count++; // Increment the count when a one is encountered, extending the consecutive ones sequence.
                max = Math.max(count, max); // Update the maximum with the current count if it's larger.
            }
        }

        return max; // Return the maximum consecutive ones found in the array.
    }


LeetCode : https://leetcode.com/problems/max-consecutive-ones/