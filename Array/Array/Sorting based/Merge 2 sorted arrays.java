import java.util.*;
public class Solution {
    public static List<Integer> sortedArray(int[] a, int[] b) {
        // Initialize pointers for both arrays and create a list to store the merged result.
        int start1 = 0;
        int start2 = 0;
        int end1 = a.length;
        int end2 = b.length;
        List<Integer> ans = new ArrayList<>();

        // Merge the two sorted arrays while removing duplicates.
        while (start1 < end1 && start2 < end2) {
            int x = a[start1];
            int y = b[start2];

            // If element from 'a' is smaller than element from 'b', add 'x' to the result.
            if (x < y) {
                // Check if the result list is empty or if 'x' is not the same as the last element added.
                if (ans.isEmpty() || ans.get(ans.size() - 1) != x) {
                    ans.add(x);
                }
                start1++; // Move the pointer for 'a' array.
            } else if (x > y) {
                // If element from 'b' is smaller than element from 'a', add 'y' to the result.
                if (ans.isEmpty() || ans.get(ans.size() - 1) != y) {
                    ans.add(y);
                }
                start2++; // Move the pointer for 'b' array.
            } else {
                // If both elements are equal, add one and move both pointers to avoid duplicates.
                if (ans.isEmpty() || ans.get(ans.size() - 1) != x) {
                    ans.add(x);
                }
                start1++;
                start2++;
            }
        }

        // Add any remaining elements from 'a' and 'b' to the result while removing duplicates.
        while (start1 < end1) {
            int x = a[start1++];
            if (ans.isEmpty() || ans.get(ans.size() - 1) != x) {
                ans.add(x);
            }
        }

        while (start2 < end2) {
            int y = b[start2++];
            if (ans.isEmpty() || ans.get(ans.size() - 1) != y) {
                ans.add(y);
            }
        }

        // Return the merged and deduplicated list.
        return ans;
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/sorted-array_6613259?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM