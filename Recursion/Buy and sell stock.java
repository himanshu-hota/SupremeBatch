

class Solution {
    
    
    class Stock {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
    }


    static void maxProfitRec(int prices[],Stock stock , int i ){
        // if array has been traversed then return;
        if(i == prices.length){
            return;
        }
        // check if todays price is minimum
        if(prices[i] < stock.minPrice) stock.minPrice = prices[i];

        // calculate todays profit
        int todayProfit = prices[i] - stock.minPrice;

        // if todays profit is greater than set maxProfit to todayProfit
        if(todayProfit > stock.maxProfit) stock.maxProfit = todayProfit;

        // Recursive call
        maxProfitRec(prices,stock,i+1);

    }

    public int maxProfit(int[] prices) {
        Stock stock = new Stock();

        maxProfitRec(prices,stock,0);

        return stock.maxProfit;
    }
}


LeetCode : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/