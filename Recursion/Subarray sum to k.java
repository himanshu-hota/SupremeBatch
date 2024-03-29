// brute force

class Solution {

    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i ; j < n; j++){
                sum += nums[j];
                if(sum == k) ans++;
            }
        }

        return ans;
    }
}



// CodeStudio Variant

import java.util.*;

public class Solution {

    // This method is a helper function to find subarrays with the given target sum
    public static void solve(int arr[], int idx, List<List<Integer>> ans, long target) {

        if (idx >= arr.length)
            return;

        long sum = 0;
        List<Integer> curr = new ArrayList<>();

        // Iterate through the array starting from the current index
        for (int i = idx; i < arr.length; i++) {
            sum += arr[i];
            curr.add(arr[i]);

            // If the sum equals the target, add the current subarray to the result and break
            if (sum == target) {
                ans.add(new ArrayList<>(curr));
                break;
            }
        }

        // Recursively call the solve method with the next index
        solve(arr, idx + 1, ans, target);
    }

    // Main method to find subarrays with the given target sum
    public static List<List<Integer>> subarraysWithSumK(int[] a, long k) {

        List<List<Integer>> ans = new ArrayList<>();

        // If the array is empty, return an empty result
        if (a.length == 0)
            return ans;

        // Call the helper function to find subarrays with the target sum
        solve(a, 0, ans, k);

        return ans;
    }
}



// optimized : sliding window approach

import java.util.*;

public class Solution {

    // Function to find subarrays with sum equal to the target
    public static List<List<Integer>> subarraysWithSumK(int[] arr, long target) {

        // List to store the result
        List<List<Integer>> ans = new ArrayList<>();

        // List to maintain the current subarray
        List<Integer> curr = new ArrayList<>();

        // Pointers for the sliding window
        int start = 0;
        int end = 0;

        // Variable to store the current sum of the subarray
        long sum = 0;

        // Iterate through the array using the sliding window approach
        while (end < arr.length) {

            // Include the current element in the sum and subarray
            sum += arr[end];
            curr.add(arr[end]);

            // Adjust the subarray and sum if it exceeds the target
            while (sum > target && start < arr.length) {
                sum -= arr[start];
                curr.remove(0);
                start++;
            }

            // If the current subarray has the target sum, add it to the result
            if (sum == target) {
                ans.add(new ArrayList<>(curr));
            }

            // Move the end pointer to the next element
            end++;
        }

        // Return the final result
        return ans;
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/subarrays-with-sum-%E2%80%98k_6922076

// LeetCode Variant


// Method 1

// Class to store the result (count of subarrays)
class Result {
    int count = 0;

    Result() {
        this.count = 0;
    }
}

// Main class containing the solution
class Solution {

    // Recursive method to count subarrays with sum equal to k
    public void countSub(int arr[], int k, int i, Result ans) {
        // Base case: if the index is beyond the array length, return
        if (i >= arr.length) return;

        // Initialize sum for the current subarray
        int sum = 0;

        // Iterate through subarrays starting from index 'i'
        for (int start = i; start < arr.length; start++) {
            // Update the sum with the current element
            sum += arr[start];

            // Check if the current subarray has a sum equal to 'k'
            if (sum == k) {
                ans.count++; // Increment the count
            }
        }

        // Recursively move to the next index
        countSub(arr, k, i + 1, ans);
    }

    // Main method to find the total count of subarrays with sum equal to k
    public int subarraySum(int[] nums, int k) {
        // Create an instance of Result to store the count
        Result ans = new Result();
        
        // Call the recursive method to calculate the count
        countSub(nums, k, 0, ans);

        // Return the final count
        return ans.count;
    }
}


// Method 2

class Solution {

    // Recursive helper function to find subarrays starting from index i with sum equal to target
    public int solve(int arr[], int target, int i) {
        // Base case: If the current index exceeds the array length, return 0
        if (i >= arr.length) return 0;

        int ans = 0; // Initialize the count of subarrays
        int sum = 0; // Initialize the current sum

        // Iterate through the array starting from index i
        for (int start = i; start < arr.length; start++) {
            sum += arr[start]; // Update the sum

            // If the sum becomes equal to the target, increment the count
            if (sum == target) ans++;
        }

        // Recursively call the function for the next index
        return ans + solve(arr, target, i + 1);
    }
    
    // Main function to find the total number of subarrays with sum equal to k
    public int subarraySum(int[] nums, int k) {
        return solve(nums, k, 0); // Start the recursive process from index 0
    }
}


LeetCode : https://leetcode.com/problems/subarray-sum-equals-k/