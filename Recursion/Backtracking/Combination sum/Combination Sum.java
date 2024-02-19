// Method 1

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>(); // List to store current combination
        List<List<Integer>> ans = new ArrayList<>(); // List to store all combinations
        helper(candidates, target, arr, ans, 0); // Call the helper function to find combinations
        return ans; // Return the list of combinations
    }

    static void helper(int[] candidates, int target, List<Integer> arr, List<List<Integer>> ans, int idx) {
        // Base case: If the target is achieved (sum is 0), add the current combination to the result list
        if (target == 0) {
            ans.add(new ArrayList<>(arr)); // Create a new instance of 'arr' before adding to 'ans'
            return;
        }

        // If the target is negative, it means the current combination exceeds the target, so backtrack
        if (target < 0) {
            return;
        }

        // Iterate through the candidates starting from the given index
        for (int i = idx; i < candidates.length; i++) {
            arr.add(candidates[i]); // Add the current candidate to the combination
            // Recursive call: Reduce the target by the current candidate and move to the next index
            helper(candidates, target - candidates[i], arr, ans, i);
            arr.remove(arr.size() - 1); // Remove the last added candidate (backtrack)
        }
    }
    
}

// Method 2


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,target,arr,ans,0);
        return ans ;
    }

    static void helper(int[] candidates, int target,List<Integer> arr,  List<List<Integer>> ans,int idx){

        if(target == 0){
            ans.add(new ArrayList<>(arr));
            return;
        }

        if(target<0){
            return;
        }

        for(int i =idx;i<candidates.length;i++){

            if(i!=0 && candidates[i] == candidates[i-1]) continue;

            if(candidates[i] <= target){
                arr.add(candidates[i]);
                helper(candidates,target-candidates[i],arr,ans,i);
                arr.remove(arr.size()-1);
            }

            
        }

    }
}


Note : The if checks are the optimisation that avoids the call when 
            a. In case of duplicates.
            b. In case when current element is greater than target then no sense to add this number.

// Method 3

class Solution {

    // Main recursive function to find combinations that sum up to the target
    public void solve(int arr[], int i, List<List<Integer>> ans, List<Integer> curr, int target) {
        
        // if target is negative then no need to do further calculations.
        if(target < 0) return;

        // Base case: If we have processed all elements in the array
        if (i >= arr.length) {
            // If the target is achieved, add the current combination to the result
            if (target == 0)
                ans.add(new ArrayList<>(curr));
            return;
        }

        // Include the current element in the combination if it does not exceed the target
        if (arr[i] <= target) {
            curr.add(arr[i]);
            // Recursively call solve with the reduced target
            solve(arr, i, ans, curr, target - arr[i]);
            // Backtrack: Remove the last added element to explore other possibilities
            curr.remove(curr.size() - 1);
        }

        // Exclude the current element and move on to the next one
        solve(arr, i + 1, ans, curr, target);
    }

    // Main function to find combinations that sum up to the target
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Initialize the result list
        List<List<Integer>> ans = new ArrayList<>();

        // If the candidates array is empty, return an empty result
        if (candidates.length == 0)
            return ans;

        // Start the recursive process to find combinations
        solve(candidates, 0, ans, new ArrayList<>(), target);

        // Return the final result
        return ans;

    }
}

Note : 1. We have used include/exclude pattern.
       2. We can use any digit any number of times so in the first recursive call we are not going forward, instead we are trying to add this number again and again untill we get the target or exceed it.
       3. In the second recursive call we are exluding this element and going forward.

LeetCode :- https://leetcode.com/problems/combination-sum/description/