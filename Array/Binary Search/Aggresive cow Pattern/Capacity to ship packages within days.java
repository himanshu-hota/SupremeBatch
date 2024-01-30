class Solution {

    public boolean isPossible(int weights[],int days,int maxWeight){
        int day = 1;
        int weight = 0;
        int n = weights.length;

        for(int x : weights){
            
            // if including current weight exceeds the allowed weight then start from next day.
            if(weight + x > maxWeight){
                day++;
                weight = x;
                if(day > days) return false;
            }else{
                weight += x;
            }
        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        
        int totalW = 0;
        int minCap = 0;
        for(int x : weights){
            totalW += x;
            minCap = Math.max(minCap,x);
        }

        // why is that? because cargos capacity must be (must be) min of the max weights to carry the heaviest item in the weight array.
        int start = minCap;
        int end = totalW;

        int ans = 0;

        while(start <= end){
            int mid = start + (end - start)/2;

            // check if we can ship all packages with minimum of mid amount of capacity.
            if(isPossible(weights,days,mid)){
                ans = mid;
                end = mid - 1; // if yes then try check if we can minimum the capacity futhre more.
            }else{
                start = mid+1; // otherwise we have to try for higher minimum capacity.
            }

        }

        return ans;
    }
}


Note : Same logic as 'Allocate minimum number of pages'.

LeetCode : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

CodeStudio : https://www.codingninjas.com/studio/problems/capacity-to-ship-packages-within-d-days_1229379?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION