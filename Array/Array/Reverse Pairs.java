// Method 1 

class Solution {
    public int reversePairs(int[] arr) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1 ; j<n ; j++){
                if( (long)(arr[i]) > (2*(long)arr[j])) count++;
            }
        }

        return count;
    }
}


// Method 2

class Solution {
    public int reversePairs(int[] arr) {
        int n = arr.length;
         return mergeSort(arr, new int[n], 0, n - 1);
    }

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
 // This method merges two sorted subarrays and counts the inversions
public static int merge(int arr[], int temp[], int start, int mid, int end) {
    int left = start;
    int right = mid + 1;
    int tempStart = start;
    int count = 0;

    // Merge the two subarrays and count inversions
    while (left <= mid && right <= end) {
        if ((long)arr[left] > 2 * (long)arr[right]) {
            count += (mid - left + 1);
            right++;
        } else {
            left++;
        }
    }

    left = start;
    right = mid + 1;
                       
    // Merge the subarrays
    while (left <= mid && right <= end) {
        if (arr[left] <= arr[right]) {
            temp[tempStart++] = arr[left++];
        } else {
           temp[tempStart++] = arr[right++];
        }
    }

    // Copy remaining elements from the left and right subarrays
    while (left <= mid) temp[tempStart++] = arr[left++];
    while (right <= end) temp[tempStart++] = arr[right++];

    // Copy the merged elements back to the original array
    while (start <= end) arr[start] = temp[start++];

    return count;
}
}


LeetCode : https://leetcode.com/problems/reverse-pairs/description/