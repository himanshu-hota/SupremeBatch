// Method 1

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        
        solve(nums,0,ans);

        return ans;
    }

    public void solve(int arr[],int idx,List<List<Integer>> ans){

        if( idx >= arr.length){
            List<Integer> curr = new ArrayList<>();
            for(int x : arr) curr.add(x);
            ans.add(curr);
            return;
        }

        HashMap<Integer,Boolean> visited = new HashMap<>();
        for(int i = idx; i<arr.length; i++){
            if(visited.getOrDefault(arr[i],false)) continue;
            visited.put(arr[i],true);
            swap(arr,i,idx);
            solve(arr,idx+1,ans);
            swap(arr,i,idx);
        }

    }

    public void swap(int arr[],int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


Notes : 1. It is same as 'Permutation 1' , just difference is that we dont run the recursive call for the same value if we have swapped that element before.

        HashMap<Integer,Boolean> visited = new HashMap<>();
                for(int i = idx; i<arr.length; i++){
                    if(visited.getOrDefault(arr[i],false)) continue;
                    visited.put(arr[i],true);


       2. Only above lines are changes. that check at the current level if we have swapped any element before then dont do any calculations for this.


// Method 2

class Solution {
        public void solve(int arr[], int idx, List<List<Integer>> ans) {
        if (idx >= arr.length) {
            List<Integer> curr = new ArrayList<>();
            for(int x : arr) curr.add(x);
            ans.add(curr);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = idx; i < arr.length; i++) {
            if(set.contains(arr[i])) continue;
            set.add(arr[i]);
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
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums,0,ans);

        return ans;
    }
}

LeetCode : https://leetcode.com/problems/permutations-ii/