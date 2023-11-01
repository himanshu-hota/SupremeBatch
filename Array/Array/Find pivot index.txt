// Method 1 

class Solution {
    public int pivotIndex(int[] nums) {
        // Calculate the total sum of all elements in the array
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            // Calculate the sum of elements on the right side by subtracting the left sum and the current element from the total sum
            int rightSum = totalSum - (leftSum + nums[i]);

            // Check if the sum of elements on the left is equal to the sum of elements on the right
            if (leftSum == rightSum) {
                return i; // Found the pivot index
            }

            leftSum += nums[i]; // Add the current element to the left sum as we move to the next index
        }

        return -1; // No pivot index found
    }
}


// Method 2:

class Solution {
    public int pivotIndex(int[] nums) {
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


Steps : 1. One major catch in this question is that we are asked to calculate left sum and right sum of current element and check whether they are equal or not, but problems is that we are asked to not to include the current element and then check if sum of left to it and sum of right to it (excluding current) is equal or not.

        2. We can do so by calculating total sum.
        3. Then at every index calculate sum of its right elements (excluding current), sum of its left(excluding current) and then check for equality.
        4. If they are equal then current index is the pivot index.

LeetCode :- https://leetcode.com/problems/find-pivot-index/

Exactly same question : https://leetcode.com/problems/find-the-middle-index-in-array/submissions/1088926129/