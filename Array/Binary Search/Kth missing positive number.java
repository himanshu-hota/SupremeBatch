// Bruteforce

public class Solution {

    // Function to find the kth missing element in the array
    public static int missingK(int[] vec, int n, int k) {
        
        // Iterate through each element in the array
        for(int x : vec){

            // Check if the current element is less than or equal to k
            if(x <= k)
                k++; // Increment k if the current element is less than or equal to k
            
            else if(k > x)
                break; // If k is greater than the current element, exit the loop
        }   

        // Return the final value of k, representing the kth missing element
        return k;
    }
}

Steps: 1. We Iterate through the array, and check whehter the k is greater than the curr.
       2. If it is greater than the curr then we break the loop and return the k itself.
       3. Otherwise Increment the k's value by 1.


// Optimized 

public class Solution {

    public static int missingK(int[] arr, int n, int k) {
        // Initialize the start and end pointers for binary search
        int start = 0;
        int end = n - 1;

        // Perform binary search to find the position where the kth missing element would be
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Calculate the number of missing elements before the current element
            int missingNum = arr[mid] - (mid + 1);

            if (missingNum < k) {
                // If missingNum is less than k, search on the right side of mid
                start = mid + 1;
            } else {
                // If missingNum is greater than or equal to k, search on the left side of mid
                end = mid - 1;
            }
        }

        // At this point, 'end' is the position where the kth missing element would be
        // Return the kth missing positive integer
        return end + k + 1;
    }
}



CodeStudio : https://www.codingninjas.com/studio/problems/kth-missing-element_893215?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf