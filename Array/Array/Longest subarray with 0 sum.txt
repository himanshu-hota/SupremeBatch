import java.util.*;

public class Solution {

    public static int helper(int[] a, int k) {
        // Initialize the maximum length of the subarray to 0.
        int max = 0;
        
        // Get the length of the input array 'a'.
        int n = a.length;
        
        // Create a HashMap to store the cumulative sum of elements and their corresponding indices.
        HashMap<Integer, Integer> sumTillNow = new HashMap<>();
        
        // Initialize the cumulative sum variable 'sum' to 0.
        int sum = 0;
        
        // Initialize the HashMap with an initial entry for sum 0 at index -1.
        sumTillNow.put(0, -1);

        // Iterate through the elements of the array.
        for (int i = 0; i < n; i++) {
            // Update the cumulative sum.
            sum += a[i];

            // Check if the cumulative sum minus 'k' is present in the HashMap.
            if (sumTillNow.containsKey(sum - k)) {
                // Calculate the length of the subarray and update 'max' if necessary.
                max = Math.max(max, i - sumTillNow.get(sum - k));
            }

            // If the cumulative sum is not present in the HashMap, add it with its current index.
            if (!sumTillNow.containsKey(sum)) {
                sumTillNow.put(sum, i);
            }
        }

        // Return the maximum length of the subarray.
        return max;
    }

    public static int getLongestZeroSumSubarrayLength(int []arr){
        // Write your code here.

        int ans = helper(arr,0);

        return ans;
    }
}

Note : This question is solved using "Longest subarray with sum equal to k (P+E)".

Link to this : https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_Arrayproblems&leftPanelTabValue=SUBMISSION

CodeStudio : https://www.codingninjas.com/studio/problems/longest-subarray-with-zero-sum_6783450?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM