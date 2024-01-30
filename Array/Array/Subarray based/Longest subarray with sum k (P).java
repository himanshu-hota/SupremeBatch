// Method 1 

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here

        int start =0;
        int end = -1;
        int n= a.length;
        long currentSum =0;
        int maxLength = 0;

        while(start < n){
            // till our sum <= 'k' or we
            // are not out of bounds
            while ((end + 1 < n) && (currentSum + a[end + 1] <= k)) {
                currentSum += a[end + 1];
                ++end;
            }

            // We have found a subarray with the
            //  required sum.
            if (currentSum == k) {
                maxLength = Math.max(maxLength, end - start + 1);
            }

            // Shifting the start index
            currentSum -= a[start];
            ++start;
        }

        return maxLength;
    }
}

Steps : 1. The idea is to maintain a totalSum that contains the sum of each element till now.
        2. start pointer tell that "what was the starting index of the subarray that sums to k".
        3. end pointer tell that "what is the ending index of the subarray that sums to k".
        4. currentSum maintains sum till now.
        5. currentSum -= a[start]; throw the unwanted element out of sum.
        6. The end pointer will toward right and keep adding element just before the sum become greater than the target, if by adding the any element the sum becomes greater then it doesn't add it at all.
        7. Now check if the sum is equal to the target, if yes then store the max length ( since start and end are indices , not position so we have to add +1 to it to get the right length ).
        8. At the end of the while loop remove the element at start pointer ( this removes the current element out of window, as we have checked that if we include the start element then what is the sum, so now we want to check what if we dont include the start element. )


CodeStudio : https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

GFG : https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1