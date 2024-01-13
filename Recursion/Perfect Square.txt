class Solution {
    // Function to find the minimum number of perfect squares that sum up to n
    public int numSquares(int n) {
        // Base case: If n is non-positive, there are no perfect squares to consider
        if (n <= 0) return 0;
        
        // Initialize the answer to the maximum possible value
        int ans = Integer.MAX_VALUE;

        // Determine the range of perfect squares to consider, from 1 to sqrt(n)
        int start = 1;
        int end = (int) Math.sqrt(n);

        // Iterate through the possible perfect squares
        for (int i = start; i <= end; i++) {
            // Calculate the current perfect square
            int perfectSquare = i * i;
            
            // Recursive call to find the minimum number of perfect squares for the remaining value
            int countOfPerfectSquares = 1 + numSquares(n - perfectSquare);
            
            // Update the answer with the minimum count
            ans = Math.min(ans, countOfPerfectSquares);
        }

        // Return the final minimum count of perfect squares
        return ans;
    }
}

Time complexity :- O(square root to the power n); -> O(n to the power n);
Space complexity :- O(n)

LeetCode : https://leetcode.com/problems/perfect-squares/