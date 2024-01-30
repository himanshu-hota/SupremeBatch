class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int n = nums.size();

        // Check if 'k' is greater than the length of 'nums'
        if (k > n) return -1.0; // Return -1.0 for consistency with double type

        double sum = 0;  // Variable to keep track of the current sum
        double avg = 0;  // Variable to store the current average
        double ans = 0;  // Variable to store the maximum average

        // Initialize 'sum' with the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int start = 0; // Modified starting point for the subarray
        int end = k;   // Ending point for the subarray
        ans = sum / k; // Initialize 'ans' with the average of the first 'k' elements

        // Iterate through the array to find the maximum average
        while (end < n) {
            sum -= nums[start++]; // Remove the element at the old 'start' from 'sum'
            sum += nums[end++];   // Add the element at the new 'end' to 'sum'
            avg = sum / k;        // Calculate the new average
            ans = max(avg, ans);  // Update 'ans' if the new average is greater
        }

        return ans; // Return the maximum average found
    }
};


Steps; 1. Get average of first k elements.
       2. Pick window of k and keep calculating average of k elements, 


LeetCode : https://leetcode.com/problems/maximum-average-subarray-i/description/