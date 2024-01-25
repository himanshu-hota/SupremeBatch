class Solution {

    public boolean canBeDivided(int arr[],int k,int maxSum){

        int sum = 0;
        int subArray = 1;

        for(int i = 0; i<arr.length; i++){
            
            // if curr element is greater than max allowed sum then no there is no possible solution.
            if(arr[i] > maxSum) return false;

            // if by including the curr element we exceed the max allowed sum then create a new subarray
            if(sum + arr[i] > maxSum){
                subArray++;
                sum = arr[i];

                if(subArray > k) return false;
            }else{
                sum += arr[i];
            }
        }

        // if everything went well then it it a possible solution.
        return true;

    }

    public int splitArray(int[] nums, int k) {
        
        int start = 0;
        int end = 0;

        for(int x :nums) end += x;

        int ans = 0;

        while(start <= end){
            int mid = start + (end - start)/2;

            // check if we can have mid as sum of subarrays.
            if(canBeDivided(nums,k,mid)){
                ans = mid; // store the curr ans.
                end = mid-1;
            }else{
                start = mid+1;
            }

        }

        return ans;
    }
}


Special note : This is the same question and logic as "Painter's partition", "Book allocation" problem.

LeetCode : https://leetcode.com/problems/split-array-largest-sum/

CodeStudio : https://www.codingninjas.com/studio/problems/largest-subarray-sum-minimized_7461751?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

