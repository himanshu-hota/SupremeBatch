// Method 1
public class Solution {
    // Method to move all zeroes to the end of the array while maintaining the order of non-zero elements
    public void moveZeroes(int[] nums) {
        // Initialize a variable to keep track of the position to insert non-zero elements
        int pos = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero, move it to the position 'pos' and increment 'pos'
            if (nums[i] != 0) {
                nums[pos++] = nums[i];
            }
        }

        // Fill the remaining positions with zeroes to move all zeroes to the end
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }
}


LeetCode : https://leetcode.com/problems/move-zeroes/submissions/1091401766/