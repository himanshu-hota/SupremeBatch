// Method 1

class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        
        int totalBananas = 0;
        int maxSpeed = 0;
        for(int x : piles){
            maxSpeed = Math.max(maxSpeed,x);
            totalBananas += x;
        }

        int start = 1;
        int end = maxSpeed;

        while(start <= end){
            int mid = start + (end - start)/2;

            // check how many hours would it take to finish totalBanans with mid speed.
            int totalHours = 0;
            for(int i = 0; i< piles.length; i++){
                totalHours += Math.ceil((double)piles[i] / (double)mid);
            }

            // if we got totalHours less then required hours then it is a possible soluion.
            // try to minimize the hour.
            if(totalHours <= h){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return start;
    }
}

// Method 2

class Solution {

    // Function to check if it is possible to eat all bananas within given hours
    public boolean canEatBananas(int arr[], int speed, int maxHours) {
        int totalHours = 0;

        // Calculate total hours needed to eat all bananas at the given speed
        for (int x : arr) {
            totalHours += Math.ceil((double) x / (double) speed);
        }

        // Check if the total hours needed is within the allowed maximum hours
        return totalHours <= maxHours;
    }

    // Function to find the minimum eating speed required to eat all bananas within given hours
    public int minEatingSpeed(int[] piles, int h) {

        // Find the maximum pile size
        int maxSpeed = 0;
        for (int x : piles) {
            maxSpeed = Math.max(x, maxSpeed);
        }

        // Binary search to find the minimum eating speed
        int start = 1;
        int end = maxSpeed;

        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if it is possible to eat all bananas at the current speed
            if (canEatBananas(piles, mid, h)) {
                ans = mid;
                // If possible, update the answer and search for lower speeds
                end = mid - 1;
            } else {
                // If not possible, search for higher speeds
                start = mid + 1;
            }
        }

        // Return the minimum eating speed found
        return ans;
    }
}


Steps : 1. Get the total count of bananas and pile that has max bananas(which will be the max speed).
        2. Perform binary search from 1 -> totalBananas as the speed must be between this range.
        3. From 1 -> totalBananas, try the mid as speed and check if koko can eat all bananas with mid speed, if yes then try to minimize the speed(as ques. said).
        

LeetCode : https://leetcode.com/problems/koko-eating-bananas/

CodeStudio : https://www.codingninjas.com/studio/problems/minimum-rate-to-eat-bananas_7449064?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM&count=25&page=1&search=&sort_entity=order&sort_order=ASC