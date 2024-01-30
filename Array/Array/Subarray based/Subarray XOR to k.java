// Method 1

public class Solution {
    public static int subarraysWithSumK(int[] a, int b) {
        // Initialize count to keep track of subarrays with sum equal to b
        int count = 0;

        // Get the length of the input array
        int n = a.length;

        // Iterate through all possible starting points of subarrays
        for (int i = 0; i < n; i++) {
            // Initialize XOR variable for the current subarray
            int xor = 0;

            // Iterate through all possible ending points of subarrays starting from i
            for (int j = i; j < n; j++) {
                // Update XOR with the current element in the subarray
                xor ^= a[j];

                // Check if the XOR of the subarray equals the target sum b
                if (xor == b) {
                    // Increment count if the condition is met
                    count++;
                }
            }
        }

        // Return the final count of subarrays with sum equal to b
        return count;
    }
}

Note : The above approach is the bruteforce that checks for xor of each subarray and compare with given xor.

// Method 2

public class Solution {
    public static int subarraysWithSumK(int[] a, int b) {
        int xor = 0;  // Initialize the cumulative XOR value to 0.
        int count = 0;  // Initialize the count of subarrays with XOR equal to 'b' to 0.

        Map<Integer, Integer> map = new HashMap<>();  // Create a HashMap to store XOR values and their frequencies.

        for (int x : a) {
            xor ^= x;  // Update the cumulative XOR value by XOR-ing it with the current element 'x'.

            if (xor == b) {
                count++;  // If the cumulative XOR is equal to 'b', increment the count.
            }

            int find = xor ^ b;  // Calculate the XOR value needed to achieve 'b'.

            // Increment the count by the frequency of 'temp' in the map using 'getOrDefault'.
            count += map.getOrDefault(find, 0);

            // Update the map with the current XOR value. If it's not in the map, initialize its frequency as 1.
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;  // Return the final count of subarrays with XOR equal to 'b'.
    }
}

Similar Question : subarray sum to k ==> Same logic same code just sign is changed (^ --> +).
Link : https://leetcode.com/problems/subarray-sum-equals-k/description/

Steps : 1. Keep calculating XOR if found to k then increase the count.
        2. Keep track of XOR till now, and search for k^(XOR till now), if found any then increase count.
        3. Put this XOR into map for further calculation.

CodeStudio : https://www.codingninjas.com/studio/problems/subarrays-with-xor-k_6826258?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM