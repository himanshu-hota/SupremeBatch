import java.util.*;

public class Solution {
    public static List<Integer> superiorElements(int[] a) {
        // Initialize a variable to keep track of the maximum element encountered so far
        int max = -1;
        // Initialize a variable to point to the end of the input array
        int end = a.length - 1;
        // Create a list to store the superior elements
        List<Integer> ans = new ArrayList<>();

        // Traverse the input array from the end to the beginning
        while (end >= 0) {
            // Check if the current element is greater than the current maximum
            if (a[end] > max) {
                // Update the maximum if the current element is greater
                max = Math.max(max, a[end]);
                // Add the current element to the list of superior elements
                ans.add(a[end]);
            }
            // Move to the previous element in the array
            end--;
        }

        // Return the list of superior elements
        return ans;
    }
}

LeetCode : https://www.codingninjas.com/studio/problems/superior-elements_6783446?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM