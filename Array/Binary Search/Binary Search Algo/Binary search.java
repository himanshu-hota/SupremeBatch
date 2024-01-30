
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


Note : Normal binary search me jab bhi out of loop aate hai to
        1. start index target se just bade element ko point karta hai.
        2. end index target se just chhote element ko point karta hai.
        3. Above observations can be used to 'Find insert position'.

GFG :- https://practice.geeksforgeeks.org/problems/binary-search-1587115620/1


proof ==> 

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5,7,8,9,10};
        
        int n = arr.length;
        int k = 6;

        int start = 0;
        int end = n - 1;
        // calculate mid index
        int mid = end - (end-start) /2;
        
        // find the target
        while(start <= end){
            
            // if element is found then return the index.
            if(arr[mid] == k){
                break;
            }else if(arr[mid] < k){ // if the middle element is smaller than the target then search on right.
                start = mid+1;
            }else{ // else search on left part
                end = mid-1;
            }
            
            // update the middle index
            mid = end - (end-start) /2;
        }

        System.out.println("start => " + arr[start] + " end => " + arr[end]);
    }
}