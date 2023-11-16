class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        // Find the maximum value in the nums array
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        // Initialize the search range
        int start = 1;
        int end = max;

        // Binary search for the smallest divisor
        while (start <= end) {
            // Calculate the middle value
            int mid = start + (end - start) / 2;

            // Calculate the sum of ceil(x/mid) for each x in nums
            int sum = 0;
            for (int x : nums) {
                int num = (int) Math.ceil((double) x / mid);
                sum += num;
            }

            // Adjust the search range based on the sum
            if (sum > threshold) {
                // If the sum is too large, reduce the divisor by adjusting the end
                start = mid + 1;
            } else {
                // If the sum is within the threshold, potentially reduce the divisor by adjusting the start
                // or continue searching for a smaller divisor on the left side
                end = mid - 1;
            }
        }

        // The start value is the smallest divisor that satisfies the threshold
        return start;
    }
}

Steps : 1. The max in the array would be the greatest divisor, find the max in the array.
        2. Loop from 1 -> Max in the array.
        3. Pick a mid and try dividing each num in the array and get the sum of all.
        4. If this sum is greater than the desired threshold then reduce the range , otherwise expand the range.


LeetCode : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/

CodeStudio : https://www.codingninjas.com/studio/problems/smallest-divisor-with-the-given-limit_1755882?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION