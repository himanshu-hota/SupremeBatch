public class Solution {
    
    // Helper method to find the first occurrence of a target value
    public int first(long arr[], int start, int end, long k) {
        int firstIndex = -1;
        
        while (start <= end) {
            int mid = end - (end - start) / 2;
            
            if (arr[mid] == k) {
                firstIndex = mid;
                end = mid - 1; // Search in the left subarray for the first occurrence
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return firstIndex;
    }
    
    // Helper method to find the last occurrence of a target value
    public int end(long arr[], int start, int end, long k) {
        int lastIndex = -1;
        
        while (start <= end) {
            int mid = end - (end - start) / 2;
            
            if (arr[mid] == k) {
                lastIndex = mid;
                start = mid + 1; // Search in the right subarray for the last occurrence
            } else if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return lastIndex;
    }
    
    // Method to find both the first and last occurrences of a target value and return them as a pair
    public pair indexes(long v[], long x) {
        int n = v.length;
        int first = first(v, 0, n - 1, x);
        int last = end(v, 0, n - 1, x);
        
        pair ans = new pair(first, last);
        
        return ans;
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/find-first-and-last-occurrence-of-x0849/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

LeetCode :- https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/