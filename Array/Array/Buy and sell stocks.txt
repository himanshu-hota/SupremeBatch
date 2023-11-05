class Solution {
    // This method calculates the maximum profit that can be obtained from a given array of stock prices.
    public int maxProfit(int[] prices) {
        // Initialize the 'buy' and 'max' variables to their extreme values to ensure correct calculations.
        int buy = Integer.MAX_VALUE; // Represents the minimum stock price encountered so far.
        int max = Integer.MIN_VALUE; // Represents the maximum profit obtained.

        // Iterate through the array of stock prices.
        for(int x : prices) {
            // If the current stock price is lower than the previous minimum price ('buy'),
            // update 'buy' to the current price, indicating a potential new buying opportunity.
            if(x < buy) {
                buy = x;
            }

            // Calculate the profit that can be obtained by selling at the current price ('x') after buying at 'buy'.
            int currprofit = x - buy;

            // Update the 'max' variable to store the maximum profit encountered so far.
            max = Math.max(currprofit, max);
        }

        // Return the maximum profit obtained after iterating through the stock prices.
        return max;
    }
}

Steps: 1. If the todays price of the stock is less than prev then buy today.
       2. Calculate today's profit, and if today's profit is greater then update max. 

LeetCode : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
