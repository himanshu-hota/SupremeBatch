import java.util.ArrayList;

public class Solution {
    // Function to find the kth element in the merged sorted arrays 'a' and 'b'
    // n1: size of array 'a', n2: size of array 'b', k: kth element to find
    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int n1, int n2, int k) {
        // Total number of elements in the merged array
        int n = n1 + n2;
        
        // Pointers for arrays 'a' and 'b'
        int i = 0;
        int j = 0;
        
        // Position of the kth element in the merged array (0-indexed)
        int pos = k - 1;
        
        // Count of elements processed
        int count = 0;
        
        // Variable to store the kth element
        int kthElement = -1;
        
        // Flag to indicate if the kth element is found
        boolean found = false;

        // Iterate through both arrays until kth element is found or arrays are exhausted
        while (i < n1 && j < n2) {
            if (a.get(i) < b.get(j)) {
                if (count == pos) {
                    kthElement = a.get(i);
                    found = true;
                    break;
                }
                i++;
                count++;
            } else {
                if (count == pos) {
                    kthElement = b.get(j);
                    found = true;
                    break;
                }
                j++;
                count++;
            }
        }

        // If kth element is not found in the first loop, check the remaining elements in array 'a'
        while (!found && i < n1) {
            if (count == pos) {
                kthElement = a.get(i);
                found = true;
                break;
            }
            i++;
            count++;
        }

        // If kth element is not found in the second loop, check the remaining elements in array 'b'
        while (!found && j < n2) {
            if (count == pos) {
                kthElement = b.get(j);
                found = true;
                break;
            }
            j++;
            count++;
        }

        // Return the kth element
        return kthElement;
    }
}


Special Note : The logic used in this question is derived from "Median of two sorted Arrays", exacly same logic and code is used.

"Median of two sorted Arrays" : 
    
    1. LeetCode : https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/4284137/100-best-approach-using-binary-search/
    
    2. CodeStudio : https://www.codingninjas.com/studio/problems/median-of-two-sorted-arrays_985294?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM


CodeStudio : https://www.codingninjas.com/studio/problems/k-th-element-of-2-sorted-array_1164159?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION






