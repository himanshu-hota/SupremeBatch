public class Solution {
    public static int upperBound(int []arr, int x, int n){
        // Write your code here.
        
        int start = 0;
        int end = n -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == x){
                start = mid+1;
            }else if(arr[mid] < x){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return end;

    }
}

Note : Lower bound => 1. if(arr[mid] == x) end = mid-1;
                      2. return start;
       Upper bound => 1. if(arr[mid] == x) start = mid+1;
                      2. return end;  


CodeStudio : https://www.codingninjas.com/studio/problems/implement-upper-bound_8165383?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf