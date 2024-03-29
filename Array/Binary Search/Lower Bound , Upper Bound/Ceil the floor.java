import java.util.* ;
import java.io.*; 

public class Solution {
    // Function to find the floor and ceiling of a given element in a sorted array
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
             
        int start = 0; // Start index for binary search
        int end = n -1; // End index for binary search
        
        // Binary search loop
        while(start <= end){
            int mid = start + (end - start)/2; // Calculate the middle index

            // If the middle element is equal to x, it is both the floor and ceiling
            if(arr[mid] == x){
                return new int[]{arr[mid], arr[mid]};
            }
            // If x is greater than the middle element, search in the right half
            else if(arr[mid] < x){
                start = mid + 1;
            }
            // If x is smaller than the middle element, search in the left half
            else{
                end = mid - 1;
            }
        }

        // If we reach till here then element not found in the array, now we need just smaller and just greater element. 

        // Just smaller = floor
        // Just greater = ceil

        // If the loop completes, x is not present in the array
        // Calculate the floor and ceiling based on the search boundaries
        int ans[] = {-1, -1};
        ans[1] = (start < n) ? arr[start] : -1; // Ceiling: element at 'start' index or -1 if out of bounds
        ans[0] = (end >= 0) ? arr[end] : -1; // Floor: element at 'end' index or -1 if out of bounds

        return ans; // Return the floor and ceiling array
    }
}

Note : 1. We used the logic of "Find the insert position". Just dry run these two question once.
       2. "Find the insert position" gives us the ciel index, where start points to the index at which just greater element is present. 
       3. Opposite to that end points to the index at which just smaller element is present.

Special Note : 1. When we come out of loop, the start index always point to the just greater element than given k.
               2.  When we come out of loop, the end index always point to the just smaller element then given k.


CodeStudio : https://www.codingninjas.com/studio/problems/ceiling-in-a-sorted-array_1825401?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM