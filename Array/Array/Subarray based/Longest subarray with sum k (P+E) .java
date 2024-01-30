// Method 1

import java.util.HashMap;

class Solution {
    
    // Function for finding the length of the longest subarray with sum equal to K
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Initialize a hashmap to store the cumulative sum and its corresponding index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = 0; // Variable to store the maximum length of subarray with sum equal to K
        int sum = 0; // Variable to store the cumulative sum of elements
        
        // Iterate through the array
        for (int i = 0; i < N; i++) {
            sum += A[i]; // Update the cumulative sum
            
            // Check if the current sum equals the target sum (K)
            if (sum == K) {
                max = i + 1; // Update max to include all elements up to the current index
            }
            
            int find = sum - K; // Calculate the value to find in the hashmap
            
            // Check if there is a previous sum that, when subtracted, gives the target sum (K)
            if (map.containsKey(find)) {
                max = Math.max(max, i - map.get(find)); // Update max if a longer subarray is found
            }
            
            // If the current sum is not in the map, store it with its index
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return max; // Return the length of the longest subarray with sum equal to K
    }
}


Steps: 1. The idea is to Calculate sum till now (at each index) and check if we have already summed up to sum - k previously.
       2. Create a map and initially put (0,-1), which means that sum 0 is present at -1 index.
       3. Now iterate through the array and at each point calculate sum and check if the map contains sum-k,
        if yes then get the index and subtract with current index, and get the max of both.
       4. Now check if the map contains sum , if no then put it in the map along with its index. 

CodeStudio : https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=SUBMISSION