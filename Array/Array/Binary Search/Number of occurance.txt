class Solution {
    
    static int fbs(int arr[], int start, int end, int target) {
        int mid;
        int idx = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            
            if (arr[mid] == target) {
                idx = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return idx;
    }
    
    static int lbs(int arr[], int start, int end, int target) {
        int mid;
        int idx = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            
            if (arr[mid] == target) {
                idx = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return idx;
    }
    
    int count(int[] arr, int n, int target) {
        
        // find first occurance of the target in the array
        int first = fbs(arr, 0, n - 1, target);
        // find last occurance of the target in the array
        int last = lbs(arr, 0, n - 1, target);
        
        // if any of above is invalid then target is not present in the array
        if(first < 0 || last < 0)
             return 0;
        else
             return last - first + 1;
    }
}

GFG :- https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article 