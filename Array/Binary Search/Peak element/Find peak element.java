// Bruteforce

class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;

        
        if(n == 0) return -1;
        if(n == 1) return 0;
        if(nums[0] > nums[1] ) return 0;
        if(nums[n-1] > nums[n-2] ) return n-1;
        

        for(int i = 1; i < n-1; i++){
            int curr = nums[i];
            int prev = nums[i-1];
            int next = nums[i+1];

            if(curr > prev && curr > next) return i;
        }

        return -1;
        
    }
}

// Method 1

class Solution {
    public int findPeakElement(int[] arr) {
        // Get the length of the array
        int n = arr.length;

        // Edge case: Empty array, no peak element
        if (n == 0) return -1;

        // Edge case: Single element array, the only element is a peak
        if (n == 1) return 0;

        // Check if the first element is a peak
        if (arr[0] > arr[1]) return 0;

        // Check if the last element is a peak
        if (arr[n - 1] > arr[n - 2]) return n - 1;

        // Binary search for a peak element
        int start = 1;
        int end = n - 2;

        while (start <= end) {
            // Calculate the middle index
            int mid = start + (end - start) / 2;

            // Check if the middle element is a peak
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            }

            // If the element to the left is smaller, search on the right side
            if (arr[mid - 1] <= arr[mid]) {
                start = mid + 1;
            } else {
                // If the element to the left is larger, search on the left side
                end = mid - 1;
            }
        }

        // No peak element found
        return -1;
    }
}

Special Note : Look carefully if (arr[mid - 1] <= arr[mid]) we are comparing with immediate prev element here, we are assuming if prev is smaller then prior to prev may be smaller.


// Method 2;

import java.util.ArrayList;
public class Solution {
    public static int findPeakElement(ArrayList<Integer> arr) {
        // Write your code here.
        
        int n = arr.size();
        int start = 1;      
        int end = n-2;

        int mid = start + (end- start) /2;
            

        while(start <= end){
            mid = start + (end- start) /2;
            

            int midVal = arr.get(mid);
            int prev = arr.get(mid-1);
            int next = arr.get(mid+1);

            if(midVal > next && midVal > prev){
                return mid;
            }else if(midVal < next){
                start = mid +1;
            }else{
                end = mid-1;
            }

        }

        if(arr.get(0) > arr.get(1)) return 0;
        if(arr.get(n-1) > arr.get(n-2)) return n-1;
        

        return -1;

    }
};


// Method 3

class Solution {
    public int findPeakElement(int[] arr) {
        // Get the length of the array
        int n = arr.length;
        
        // Initialize the start and end indices for binary search
        int start = 1;
        int end = n - 2;

        // Edge case: Empty array or single element array, the only element is a peak
        if (n <= 1) return 0;

        // Check if the first element is a peak
        if (n >= 2 && arr[0] > arr[1]) return 0;

        // Check if the last element is a peak
        if (n >= 2 && arr[n - 1] > arr[n - 2]) return n - 1;

        // Binary search for a peak element
        while (start <= end) {
            // Calculate the middle index
            int mid = start + (end - start) / 2;

            // Get values of the middle element and its neighbors
            int midVal = arr[mid];
            int prev = arr[mid - 1];
            int next = arr[mid + 1];

            // Check if the middle element is a peak
            if (midVal > next && midVal > prev) {
                return mid;
            } else if (midVal < next) {
                // If the element to the right is larger, search on the right side
                start = mid + 1;
            } else {
                // If the element to the left is larger, search on the left side
                end = mid - 1;
            }
        }

        // No peak element found
        return -1;
    }
}


Steps : 1. Following are the edge cases in this question : 
            a. If array has only one element then it is the answer itself.
            b. If first element is the peak element.
            c. If last element is the peak element.
        2. Loop through the array from 1-> n-2. (why skip 0 , n-1 ? -> Already covered int edge cases).
        3. If any element that is strictly greater than its prev and next then it is the answer.    

LeetCode : https://leetcode.com/problems/find-peak-element/

CodeStudio : https://www.codingninjas.com/studio/problems/find-peak-element_1081482?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf