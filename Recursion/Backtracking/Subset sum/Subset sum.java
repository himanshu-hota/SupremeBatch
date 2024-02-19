// CodeStudio Variant

public class Solution {

    // Function to check if a subset with the given target sum is present
    public static boolean solve(int arr[], int i, int target) {
        // Base case: subset with target sum found
        if (target == 0) return true;
        
        // Base case: target sum exceeded
        if (target < 0) return false;
        
        // Base case: end of array reached
        if (i >= arr.length) {
            // Check if the target sum is achieved
            if (target == 0) return true;
            
            // Target sum not achieved
            return false;
        }

        // Include the current element in the subset
        if (solve(arr, i + 1, target - arr[i])) return true;

        // Exclude the current element from the subset
        if (solve(arr, i + 1, target)) return true;

        // Target sum not achieved with the current element (include or exclude)
        return false;
    }

    // Wrapper function to check if a subset with the given target sum is present
    public static boolean isSubsetPresent(int n, int k, int[] a) {
        // Call the recursive function starting from the first element (index 0)
        return solve(a, 0, k);
    }
}


CodeStudio : https://codingninjas.com/studio/problems/subset-sum_630213?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM


-----------------------------------------------------------------------------------------------

// GFG Variant

class Solution {
    
    // This recursive method generates all possible subset sums
    // by including or excluding each element in the array.
    // It uses backtracking to explore all possibilities.
    public void solve(ArrayList<Integer> ans, ArrayList<Integer> arr, int i, int sum) {
        
        // Base case: if the index exceeds the array size,
        // add the current sum to the result and return.
        if (i >= arr.size()) {
            ans.add(sum);
            return;
        }
        
        // Recursive call to include the current element in the subset sum
        solve(ans, arr, i + 1, sum + arr.get(i));
        
        // Recursive call to exclude the current element from the subset sum
        solve(ans, arr, i + 1, sum);
    }
    
    // This method initializes the process of generating subset sums
    // by calling the recursive solve method and sorting the result.
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        
        // Initialize an ArrayList to store the subset sums
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Start the recursive process with initial values
        solve(ans, arr, 0, 0);
        
        // Sort the subset sums in ascending order
        Collections.sort(ans);
        
        // Return the sorted subset sums
        return ans;
    }
}


Notes : 1. We simply use include/exclude pattern.
        2. Go to each index at ask whether to inlcude this element or not, if yes then subtract the current element with sum and go forward,if no then go forward without subtracting.


GFG : https://www.geeksforgeeks.org/problems/subset-sums2234/1

CodeStudio : https://www.codingninjas.com/studio/problems/subset-sum_3843086?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM