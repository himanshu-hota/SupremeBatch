// Bruteforce

public class Solution {
    // This method takes an integer 'n' (unused in the code) and an array 'a'.
    // It finds the second largest and second smallest elements in the array 'a'.
    public static int[] getSecondOrderElements(int n, int[] a) {
        
        // Initialize variables to keep track of the maximum and minimum values.
        int min = Integer.MAX_VALUE; // Initialize 'min' to the maximum possible integer value.
        int max = Integer.MIN_VALUE; // Initialize 'max' to the minimum possible integer value.
        
        // Initialize temporary variables to find the maximum and minimum values.
        int tempMin = Integer.MAX_VALUE; // Initialize 'tempMin' to the maximum possible integer value.
        int tempMax = Integer.MIN_VALUE; // Initialize 'tempMax' to the minimum possible integer value.

        // Loop through the elements of the array 'a' to find the actual maximum and minimum values.
        for (int x : a) {
            tempMax = Math.max(tempMax, x); // Update 'tempMax' if 'x' is greater than the current 'tempMax'.
            tempMin = Math.min(tempMin, x); // Update 'tempMin' if 'x' is smaller than the current 'tempMin'.
        }

        // Loop through the elements of the array 'a' again to find the second maximum and second minimum values.
        for (int x : a) {
            if (x > max && x != tempMax) {
                max = x; // Update 'max' if 'x' is greater than the current 'max' and not equal to 'tempMax'.
            }

            if (x < min && x != tempMin) {
                min = x; // Update 'min' if 'x' is smaller than the current 'min' and not equal to 'tempMin'.
            }
        }

        // Create an array 'ans' to store the second maximum and second minimum values found.
        int ans[] = {max, min};

        // Return the 'ans' array containing the second maximum and second minimum values.
        return ans;
    }
}


// optimal

public class Solution {
    // This method takes an integer 'n' (unused in the code) and an array 'a'.
    // It finds the second largest and second smallest elements in the array 'a'.
    public static int[] getSecondOrderElements(int n, int[] a) {
        int max1 = Integer.MIN_VALUE; // Initialize the first maximum to the minimum possible integer value.
        int max2 = Integer.MIN_VALUE; // Initialize the second maximum to the minimum possible integer value.
        int min1 = Integer.MAX_VALUE; // Initialize the first minimum to the maximum possible integer value.
        int min2 = Integer.MAX_VALUE; // Initialize the second minimum to the maximum possible integer value.

        // Loop through the elements of the array 'a'.
        for (int x : a) {
            // Update the maximum values.
            if (x > max1) {
                max2 = max1; // Update 'max2' to the previous 'max1' value.
                max1 = x;   // Update 'max1' to the new maximum value 'x'.
            } else if (x > max2 && x != max1) {
                max2 = x; // Update 'max2' if 'x' is greater than the current 'max2' and not equal to 'max1'.
            }

            // Update the minimum values.
            if (x < min1) {
                min2 = min1; // Update 'min2' to the previous 'min1' value.
                min1 = x;   // Update 'min1' to the new minimum value 'x'.
            } else if (x < min2 && x != min1) {
                min2 = x; // Update 'min2' if 'x' is smaller than the current 'min2' and not equal to 'min1'.
            }
        }

        // Create an array 'ans' to store the second maximum and second minimum values found.
        int ans[] = {max2, min2};

        // Return the 'ans' array containing the second maximum and second minimum values.
        return ans;
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM