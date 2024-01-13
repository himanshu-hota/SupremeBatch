class Solution {

    // Recursive function to find combinations that sum up to 'sum' with 'size' elements
    public void solve(int arr[], int i, List<List<Integer>> ans, List<Integer> curr, int sum, int size) {

        // Base case: If the current sum is negative, return
        if (sum < 0) return;

        // Base case: If the current sum is 0 and the current combination has the required size,
        // add it to the answer list
        if (sum == 0 && curr.size() == size) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Base case: If the index 'i' exceeds the array length, return
        if (i >= arr.length) return;

        // Include the current element in the combination if it is less than or equal to the remaining sum
        if (arr[i] <= sum) {
            curr.add(arr[i]);
            solve(arr, i + 1, ans, curr, sum - arr[i], size);
            curr.remove(curr.size() - 1); // Backtrack by removing the last added element
        }

        // Exclude the current element and move to the next index
        solve(arr, i + 1, ans, curr, sum, size);
    }

    // Main function to find combinations that sum up to 'n' with 'k' elements
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        // If n is 0, return an empty list as there are no combinations
        if (n == 0) return ans;

        // Create an array containing integers from 1 to 9
        int arr[] = new int[9];
        for (int i = 1; i <= 9; i++) arr[i - 1] = i;

        // Call the solve function with initial parameters
        solve(arr, 0, ans, new ArrayList<>(), n, k);

        // Return the list of combinations
        return ans;
    }
}

Notes : 1. This question is same as 'Combination sum 1' , but with minor changes.
        2. Instead of adding the combination when sum is 0 , addtionally we are checking if the size is equal to the given size then only add this combination.



LeetCode : https://leetcode.com/problems/combination-sum-iii/description/