// Method 1

    static boolean checkSorted(int arr[],int n , int i){

        if(i == n-1){
            return true;
        }

        if(arr[i+1]> arr[i]){
          return checkSorted(arr,n ,i+1);
        }else{
            return false;
        }
    }
}

// Method 2

class Solution {
    
    boolean helper(int arr[],int i,int n){
        if(i >= n) return true;
        
        if( i+1 < n && arr[i] > arr[i+1]) return false;
        
        return helper(arr,i+1,n);
    }
    
    boolean arraySortedOrNot(int[] arr, int n) {
        // code here
        
        return helper(arr,0,n);
    }
}

GFG : https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1