class Solution {

    public boolean canWeMake(int bloomDay[],int m,int k,int day){
        // check if we can make m bouq. in mid days
        int bouq = 0;
        int consecutive = 0; // Move this line outside the loop
        for (int x : bloomDay) {
            if (x <= day) {
                consecutive++;
                if (consecutive == k) {
                    bouq++;
                    consecutive = 0;
                }
            } else {
                consecutive = 0;
            }
        }

        return bouq >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if (bloomDay.length<(long)m*k){
            return -1;
        }
        int maxDay = 0;
        for (int x : bloomDay) maxDay = Math.max(x, maxDay);

        int start = 1;
        int end = maxDay;

        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If we could able to make m bouq. then try if we can make it in fewer days.
            if(canWeMake(bloomDay,m,k,mid)) {
                ans = mid;
                end = mid - 1;
            } else { // otherwise try for some more days.
                start = mid + 1;
            }
        }

        
        return ans;
    }
}

Logic : 1. If the array size (num of flowers) is less then the required (m*k) flowers then no ans is possible.
        2. The max value in the array is the max day required to bloom all flowers, which means at this max day all flowers would have been bloomed, so this is the day where any how ans is possible.
        3. So we got the range 1 -> maxDay, Now perform the binary search.


Steps : 1. Get the mid value (ith day).
        2. Check how many can we make on this day, if it is greater equal then required then try to minimize the day.
        3. Otherwise try some greater day.


LeetCode : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/

CodeStudio : https://www.codingninjas.com/studio/problems/rose-garden_2248080?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM