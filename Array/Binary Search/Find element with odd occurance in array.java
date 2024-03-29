// Method 1

public class Solution 
{
    // This method finds the odd occurrence of an integer in an array.
    // It uses the XOR (^) operation to efficiently find the odd occurrence.

    public static int findOdd(int[] arr, int n) 
    {
        int ans = 0; // Initialize the answer variable to 0.

        // Iterate through the elements of the array.
        for(int x : arr)  
        {
            ans ^= x; // Use the XOR (^) operator to find the cumulative XOR of all elements.
        }

        return ans; // Return the result, which represents the integer with an odd occurrence.
    }
}

// Method 2

class Solution {
    // This function finds the single non-duplicate element in a sorted array of integers.
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        // Perform a binary search to find the single non-duplicate element.
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If 'start' and 'end' are the same, the single non-duplicate element is found.
            if (start == end) {
                return nums[start];
            }

            // Check if 'mid' is at an even index.
            if (mid % 2 == 0) {
                // If the current and next element are the same, the single element is on the right.
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 2; // Update 'start' to skip the current and next elements.
                } else {
                    end = mid; // Update 'end' to search in the left part of the array.
                }
            } else {
                // If 'mid' is at an odd index.
                // If the current and previous element are the same, the single element is on the right.
                if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1; // Update 'start' to skip the current element.
                } else {
                    end = mid; // Update 'end' to search in the left part of the array.
                }
            }
        }

        // If the loop exits without finding the single element, return -1 (an error value).
        return -1;
    }
}


Note :- 

    1. Answer will be always on the even index.
 	2. If middle index is even :-
		a. then check if its next element if same then the single element is on the right half.
		b. otherwise single element is on the left half.
		c. we can skip mid and mid+1 as we have already checked them now.

	 3. If middle index is odd :-
		a. then check if its previous element is same then single the single element is on the right half.
		b. otherwise single element is on the left half.
		c. we can skip mid as we have checked mid and mid-1 , but note that we can not skip mid+1 as we have not touched that yet.

	 4.if both pointer are at same index then it is the answer/


GFG : https://practice.geeksforgeeks.org/problems/alone-in-couple5507/1

CodeStudio : https://www.codingninjas.com/studio/problems/find-odd-occurrence-element_1062620?leftPanelTab=0

LeetCode : https://leetcode.com/problems/single-element-in-a-sorted-array/description/

LeetCode sol :- https://leetcode.com/problems/single-element-in-a-sorted-array/solutions/4229952/beat-100-java-binary-search-method/