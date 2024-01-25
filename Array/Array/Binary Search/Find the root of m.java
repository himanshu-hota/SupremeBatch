public class Solution {
    
    // Method to find the nth root of a given number 'm'
    public static int NthRoot(int n, int m) {
        
        // Initialize the start and end points for binary search
        int start = 1;
        int end = m;
        
        // Perform binary search to find the nth root
        while (start <= end) {
            // Calculate the middle point
            int mid = start + (end - start) / 2;
            
            // Use long to avoid overflow during multiplication
            // yaha galti karoge ? long ko int kar doge.
            long x = 1;

            // Calculate mid^n
            for (int i = 0; i < n; i++) {
                x *= mid;

                // Check for overflow and break the loop if x exceeds m
                if (x > m) {
                    break;
                }
            }

            // If mid^n equals m, return mid as the nth root
            if (x == m) {
                return mid;
            }

            // Adjust the search range based on the comparison of mid^n and m
            if (x > m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // If no exact nth root is found, return -1
        return -1;
    }
}

Logic : The idea is to Pick a number mid using binary search and multiply the n , mid times and check if got the answer.

Step: 1. Pick a number, multiply n , mid times.
      2. If we exceed the given number then break the loop.
      3. If we got the answer then return.

CodeStudio : https://www.codingninjas.com/studio/problems/nth-root-of-m_1062679?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

