public class Solution {
    public static int[] findMissingRepeatingNumbers(int[] a) {
        // Get the total number of elements, assuming a range from 1 to n
        int n = a.length;
        
        // Calculate the sum of all numbers in the expected range
        int totalSum = (n * (n + 1)) / 2;
        
        // Initialize variables to store the sum of elements in the array and create a map to count occurrences
        int sum = 0;
        int map[] = new int[n + 1];
        
        // Iterate through the input array to calculate the sum and count occurrences
        for (int x : a) {
            map[x]++;
            sum += x;
        }
        
        // Initialize variables to store the repeating and missing numbers
        int rNum = -1;
        
        // Find the repeating number by checking the occurrences in the map
        for (int i = 0; i <= n; i++) {
            if (map[i] == 2) {
                rNum = i;
                break;
            }
        }
        
        // Calculate the missing number using the totalSum and the repeating number
        int mNum = totalSum - (sum - rNum);
        
        // Create an array to store the result (repeating number and missing number)
        int ans[] = { rNum, mNum };
        
        // Return the array with the repeating and missing numbers
        return ans;
    }
}


Steps: 1. Calculate actual sum of N elements.
       2. Get the freq. of each element in the array, and get the element that appears twice.
       3. Calculate the sum of elements in the array.
       4. Subtract the array sum with repeating num.
       5. Subtract the actualSum with the value we get in the step 4.

CodeStudio : https://www.codingninjas.com/studio/problems/missing-and-repeating-numbers_6828164?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
