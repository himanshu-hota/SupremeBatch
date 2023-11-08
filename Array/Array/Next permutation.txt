class Solution {
    public void nextPermutation(int[] nums) {
        // Check if the array is empty or has only one element, in which case no permutation is possible
        if (nums == null || nums.length <= 1) {
            return;
        }

        // Find the first element from the right that is smaller than the element to its right
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If such an element is found, find the smallest element to the right of it that is larger, and swap them
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Reverse the elements to the right of the swapped element to get the next lexicographically larger permutation
        reverse(nums, i + 1, nums.length - 1);
    }

    // Helper method to swap two elements in the array
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Helper method to reverse a portion of the array
    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}


Note : Next permutation is a three step process.

Steps : 1. Find breakpoint (the element who is smaller than its next).
        2. Find just greater than this breakpoint from the right ans swap with breakpoint.
        3. Reverse from breakpoint+1 to n.

CodeStudio : https://www.codingninjas.com/studio/problems/next-greater-permutation_6929564?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

LeetCode : https://leetcode.com/problems/next-permutation/