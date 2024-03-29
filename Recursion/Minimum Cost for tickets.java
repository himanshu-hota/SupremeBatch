// Method 1

class Solution {

    static int mincostTicketsHelper(int days[],int costs[],int i){

        // base case
        if(i >= days.length) return 0;

        // 1 Day cost
        int cost1 = costs[0] + mincostTicketsHelper(days,costs,i+1);

        // 7 Days cost
        int lastDayOfTicket = days[i] + 7 - 1;
        int j = i;
        while( j< days.length && days[j] <= lastDayOfTicket) j++; 
        int cost2 = costs[1] + mincostTicketsHelper(days,costs,j);

        // 30 Days cost
        lastDayOfTicket = days[i] + 30 - 1;
        j = i;
        while(j< days.length && days[j] <= lastDayOfTicket) j++; 
        int cost3 = costs[2] + mincostTicketsHelper(days,costs,j);


        return Math.min(cost1,Math.min(cost2,cost3));

    }

    public int mincostTickets(int[] days, int[] costs) {
        return mincostTicketsHelper(days,costs,0);
    }
}


// Method 2 (optimized)

class Solution {

    public int solve(int days[],int costs[],int i,int dp[]){

        if(i >= days.length) return 0;

        if(dp[i] != 0) return dp[i];

        // 1 Day cost
        int cost1 = costs[0] + solve(days,costs,i+1,dp);
        // 7 Day cost
        int j = i;
        int lastDay = days[i] + 7 - 1;
        while(j < days.length && days[j] <= lastDay) j++;
        int cost2 = costs[1] + solve(days,costs,j,dp);
        // 30 Day cost
        j = i;
        lastDay = days[i] + 30 - 1;
        while(j < days.length && days[j] <= lastDay) j++;
        int cost3 = costs[2] + solve(days,costs,j,dp);

        dp[i] =  Math.min(cost1,Math.min(cost2,cost3));
        return dp[i];
    }

    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length+1];
        return solve(days,costs,0,dp);
    }
}


Why we are iterating ?

Answer: because we dont want to buy tickets on the day we have already bought in case of buying tickets for 7 days or 30 days.

for an example if we buy tickets on day 2 for 7 days then we should buy next ticket on day 9 right?

Notes : 1. ye jo loop hai wo days wale array me us day tak hume pahucha deta hai jis day par hume naya ticket lena padega . kaise ? --> 

lets assume days[i] = 4 

now agar hum 4th day ko 7 din ka pass lenge to 4,5,6,7,8,9,10 itne dino tak pass valid hoga right?

ab hume 11th day par naya pass lena padega right?

lekin dhyan me rakho ki days wale array me days random hai, days[i] = 4 hai to ye fix nahi hai ki days[i+1] 5 hoga ki koi aur jaise 45 67 83 336 345 to is case ko handle karna ke liye wo loop laga hai.

let say days[] = {1,4,6,8,10,52,321} to agar days[2] ko 7 din ka pass le to ye days[4] tak cover kar dega to j hume days[5] par pahucha dega.

ab agar days[] = {1,4,6,12,45,65,89} aisa hota to j days[3] par pahucha deta. 


LeetCode : https://leetcode.com/problems/minimum-cost-for-tickets/description/