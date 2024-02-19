// Method 1

class Solution {

    // Recursive function to generate permutations
    public void solve(int arr[], List<List<Integer>> ans, ArrayList<Integer> curr, boolean map[]) {

        // Check if the current permutation is complete
        if (curr.size() == arr.length) {
            // Add a copy of the current permutation to the result
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Try adding each element to the current permutation
        for (int i = 0; i < arr.length; i++) {
            if (!map[i]) {
                // Include the current element in the permutation
                map[i] = true;
                curr.add(arr[i]);

                // Recursively generate permutations with the current element included
                solve(arr, ans, curr, map);

                // Backtrack: Remove the last added element to explore other possibilities
                curr.remove(curr.size() - 1);
                map[i] = false;
            }
        }
    }

    // Function to generate all permutations of an array
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        // Start the recursive permutation generation
        solve(nums, ans, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }
}

Notes : 1. We are trying fill each index by using the given elements in the array.
        2. We have n(count of elements in the array) ways to fill each index.
        3. After picking any index by using any element, we cant use that element again to fill any other index.
        4. To keep track of used elements we have made use of map to track the used elements.
        5. Go to each index and check whether we can use the element by checking if it is marked true or false, if it is marked false then we cant use it otherwise we can use it.
        6. At each level there will be n recursive calls in general.

Special Notes : 

1. Why we have ran for loop from 0->n-1 ?? ---> because at each level we want to check from the start of the given array if we have chosen that element or not, if we simply do i = idx -> n-1, then the elements placed on left of i will be left.

2. Why not used base base as if(i>=n){} ??? --> because the range of i is handled by the for loop, whenever using this kind of pattern we dont need to worry about the i to be become out of bound.


// Method 2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public void solve(int arr[], int idx, List<List<Integer>> ans) {
        if (idx >= arr.length) {
            List<Integer> curr = new ArrayList<>();
            for(int x : arr) curr.add(x);
            ans.add(curr);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            solve(arr, idx + 1, ans);
            swap(arr, idx, i);
        }
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, ans);
        return ans;
    }
}



LeetCode : https://leetcode.com/problems/permutations/