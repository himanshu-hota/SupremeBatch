// Method 1 

public class Solution {
    public static int numberOfInversions(int []a, int n) {
        
        int count = 0;
        
        for(int i = 0; i< n ;i++){
            
            for(int j = i+1; j< n; j++){
                if(a[i] > a[j]) count++;
            }
        }


        return count++;
    }
}


Logic : count all greater elements on right of the each index and that is the answer.



// Method 2

import java.util.*;

public class Solution {

    // This method counts the number of inversions using the Merge Sort algorithm
    public static int mergeSort(int arr[], int temp[], int start, int end) {
        // Base case: if the subarray has only one element or is empty, there are no inversions
        if (start >= end) return 0;

        // Calculate the middle index of the subarray
        int mid = start + (end - start) / 2;

        int ans = 0;

        // Recursively count inversions in the left and right subarrays
        ans += mergeSort(arr, temp, start, mid);
        ans += mergeSort(arr, temp, mid + 1, end);

        // Merge the subarrays and count inversions during the merge
        ans += merge(arr, temp, start, mid, end);

        return ans;
    }

    // This method merges two sorted subarrays and counts the inversions
    public static int merge(int arr[], int temp[], int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int tempStart = start;
        int count = 0;

        // Merge the two subarrays and count inversions
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[tempStart++] = arr[left++];
            } else {
                temp[tempStart++] = arr[right++];
                // Count inversions when an element from the right subarray is placed before an element from the left subarray.
                count += (mid - left + 1); // only this line is changed in merge sort code.
            }
        }

        // Copy remaining elements from the left and right subarrays
        while (left <= mid) temp[tempStart++] = arr[left++];
        while (right <= end) temp[tempStart++] = arr[right++];

        // Copy the merged elements back to the original array
        while (start <= end) arr[start] = temp[start++];

        return count;
    }

    // This method calculates the number of inversions in an array
    public static int numberOfInversions(int[] a, int n) {
        return mergeSort(a, new int[n], 0, n - 1);
    }
}


Logic : When applying mergeSort if the element from right part is smaller then count all the elements greater than that element and add it to the answer.


CodeStudio : https://www.codingninjas.com/studio/problems/number-of-inversions_6840276?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

GFG : https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1