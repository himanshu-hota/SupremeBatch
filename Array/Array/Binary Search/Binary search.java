
class Solution {
    int binarysearch(int arr[], int n, int k) {
        
        int start = 0;
        int end = n - 1;
        // calculate mid index
        int mid = end - (end-start) /2;
        
        // find the target
        while(start <= end){
            
            // if element is found then return the index.
            if(arr[mid] == k){
                return mid;
            }else if(arr[mid] < k){ // if the middle element is smaller than the target then search on right.
                start = mid+1;
            }else{ // else search on left part
                end = mid-1;
            }
            
            // update the middle index
            mid = end - (end-start) /2;
        }
        
        // if the element was not found then return -1
        return -1;
    }
}

GFG :- https://practice.geeksforgeeks.org/problems/binary-search-1587115620/1