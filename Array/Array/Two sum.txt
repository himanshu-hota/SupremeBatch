// Variant 1

class Solution {
    // Function to find two indices in the array such that the corresponding
    // elements sum up to the target value.
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store elements and their corresponding indices.
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // Get the current element.
            int curr = nums[i];

            // Check if the complement (target - current) is present in the HashMap.
            if (map.containsKey(target - curr)) {
                // If found, return the indices of the two elements.
                // The current index (i) and the index of the complement.
                return new int[]{i, map.get(target - curr)};
            }

            // If complement not found, store the current element and its index in the HashMap.
            map.put(curr, i);
        }

        // If no solution is found, return an array with {-1, -1}.
        return new int[]{-1, -1};
    }
}


Special Note : Logic used in the above approach : "Count pairs with given sum".

Link : https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1

// Variant 2

public class Solution {

    // Binary search function to check if a target value is present in the array.
    public static boolean bs(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        // Binary search loop
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If the middle element is the target, return true.
            if (arr[mid] == target)
                return true;
            // If the middle element is less than the target, search in the right half.
            else if (arr[mid] < target)
                start = mid + 1;
            // If the middle element is greater than the target, search in the left half.
            else
                end = mid - 1;
        }

        // If the target is not found, return false.
        return false;
    }

    // Function to read an integer n, an array of integers 'book', and a target value.
    public static String read(int n, int[] book, int target) {

        // Sort the array 'book'.
        Arrays.sort(book);

        // Iterate through each element x in the sorted array.
        for (int x : book) {
            // Check if there exists another element in the array whose sum with x is equal to the target.
            boolean found = bs(book, target - x);

            // If such an element is found, return "YES".
            if (found)
                return "YES";
        }

        // If no pair of elements sum up to the target, return "NO".
        return "NO";
    }
}


CodeStudio : https://www.codingninjas.com/studio/problems/reading_6845742?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION

LeetCode : https://leetcode.com/problems/two-sum/description/