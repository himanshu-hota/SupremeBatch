// Method 1

class Solution {

    public void solve(int arr[],int i, List<List<Integer>> ans ,List<Integer> curr){

        if(i >= arr.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        // include
        curr.add(arr[i]);
        solve(arr,i+1,ans,curr);
        curr.remove(curr.size()-1);

        // exclude
        solve(arr,i+1,ans,curr);
        

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> curr = new ArrayList<>();

        solve(nums,0,ans,curr);

        return ans;
    }
}

// Method 2

class Solution {

    public void solve(int nums[],List<List<Integer>> ans,List<Integer> curr, int idx){
        
        ans.add(new ArrayList<>(curr));

        for(int i = idx; i < nums.length ; i++){
            curr.add(nums[i]);
            solve(nums,ans,curr,i+1);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        solve(nums,ans,new ArrayList<>(),0);

        return ans;
    }
}

Note : 1. Either the element will be included or excluded, so follow this pattern.

LeetCode : https://leetcode.com/problems/subsets/description/