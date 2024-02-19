// Bruteforce

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i< n; i++){
            sum = 0;
            for(int j = i ; j < n ; j++){
                sum += nums[j];
                max = Math.max(max,sum);
            }
        }


        return max;
    }
}


// Method 1 

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int currSum =0;
        for(int i =0; i< nums.length; i
            
            // add current element to total sum.
            currSum += nums[i];
            // Update the max till now. 
            maxSoFar = Math.max(maxSoFar,currSum);
            // if at any point the total sum is negative then reset it to 0.
            currSum = currSum < 0 ? 0 : currSum;
        }

        return maxSoFar;
    }
}

// Method 2

static int maxSubArrayDnC(int arr[], int start, int end) {
    if (start >= end) return arr[start];  // Base case: return the element itself if start and end are the same

    int mid = start + ((end - start) / 2);  // Find the middle index of the array

    // Divide the problem into subproblems
    int maxLeftSum = maxSubArrayDnC(arr, start, mid);  // Find the maximum sum in the left subarray
    int maxRightSum = maxSubArrayDnC(arr, mid + 1, end);  // Find the maximum sum in the right subarray

    // Find the maximum sum that crosses the middle of the array
    int maxLeftBorderSum = Integer.MIN_VALUE, maxRightBorderSum = Integer.MIN_VALUE;
    int leftBorderSum = 0;

    // Compute the maximum sum of the left border
    for (int i = mid; i >= 0; i--) {
        leftBorderSum += arr[i];
        if (leftBorderSum > maxLeftBorderSum) {
            maxLeftBorderSum = leftBorderSum;
        }
    }

    int rightBorderSum = 0;

    // Compute the maximum sum of the right border
    for (int i = mid + 1; i <= end; i++) {
        rightBorderSum += arr[i];
        if (rightBorderSum > maxRightBorderSum) {
            maxRightBorderSum = rightBorderSum;
        }
    }

    int crossBorderSum = maxLeftBorderSum + maxRightBorderSum;  // Compute the sum of the cross-border elements

    // Return the maximum sum among the left subarray, right subarray, and cross-border sum
    return Math.max(crossBorderSum, Math.max(maxRightSum, maxLeftSum));
}


LeetCode :- https://leetcode.com/problems/maximum-subarray/

