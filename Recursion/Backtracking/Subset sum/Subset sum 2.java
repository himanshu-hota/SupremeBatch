class Solution {

       public void solve(int[] arr ,int i,List<List<Integer>> ans,List<Integer> curr){
        // this if check is optional but keep in mind that we can not use >= beacuse we also want to store ans of size n.
        // if(i> arr.length) return;
        ans.add(new ArrayList<>(curr));

        for(int idx = i; idx < arr.length; idx++){
            if( idx != i && arr[idx] == arr[idx-1]) continue;
            
            curr.add(arr[idx]);
            solve(arr,idx+1,ans,curr);
            curr.remove(curr.size()-1);
        }
        
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums.length == 0) return ans;

        Arrays.sort(nums);

        solve(nums,0,ans,new ArrayList<>());

        return ans;
    }

}

Note : 1. This is similar to what we did in 'Combination sum 2', with only 1 change.
          change ---> We directly add the curr to ans. without checking for the i to be out of bound.

          why i is not going out of bound? --> because in the for loop we are passing value of i within range.


LeetCode : https://leetcode.com/problems/subsets-ii/