// calculate for each subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;

            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}

// Kadane's algo

class Solution {
    public int maxSubArray(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        for(int j = 0; j< n; j++){
            if(sum < 0) sum = nums[j];
            else sum += nums[j];
            max = Math.max(sum,max);
        }

        return max;
    }
}


LeetCode : https://leetcode.com/problems/maximum-subarray/