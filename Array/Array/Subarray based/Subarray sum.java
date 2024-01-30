// Method 1

class Solution {
    // Function to count the number of subarrays with sum equal to k
    public int subarraySum(int[] nums, int k) {

        // Initialize a variable to keep track of the count of subarrays with sum equal to k
        int count = 0;

        // Iterate through each element in the array as a potential starting point
        for (int i = 0; i < nums.length; i++) {
            // Initialize the sum for the current subarray
            int sum = 0;

            // Iterate through elements from the current starting point to the end of the array
            for (int j = i; j < nums.length; j++) {
                // Update the sum with the current element
                sum += nums[j];

                // Check if the current subarray has a sum equal to k
                if (sum == k) {
                    // Increment the count if the condition is met
                    count++;
                }
            }
        }

        // Return the final count of subarrays with sum equal to k
        return count;
    }
}


// Method 2

class Solution {
    // Function to count the number of subarrays with sum equal to k
    public int subarraySum(int[] nums, int k) {

        // Map to store the cumulative sum frequencies
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize variables for the cumulative sum, count of subarrays, and iterate through the array
        int sum = 0;
        int count = 0;
        for (int x : nums) {
            // Update the cumulative sum
            sum += x;

            // Calculate the value to find in the map to satisfy the condition sum - k
            int find = sum - k;

            // Check if the current sum is equal to k, increment count
            if (sum == k) {
                count++;
            }

            // Increment count by the frequency of the previously found cumulative sum
            count += map.getOrDefault(find, 0);

            // Update the map with the current cumulative sum and its frequency
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Return the final count of subarrays with sum equal to k
        return count;
    }
}


Same Logic : 'subarray xor to k'
Link :

LeetCode : https://leetcode.com/problems/subarray-sum-equals-k/

CodeStudio : https://www.codingninjas.com/studio/problems/subarray-sums-i_1467103?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION