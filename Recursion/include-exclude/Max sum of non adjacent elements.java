// Method 1

import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {

	public static int solve(ArrayList<Integer> nums,int i){

		if(i >= nums.size()){
			return 0;
		}

		// include
		int include = nums.get(i) + solve(nums,i+2);

		// exclude
		int exclude = 0 + solve(nums,i+1);

		return Math.max(include,exclude);

	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		
		if(nums.size() <= 0) return 0;
		if(nums.size() == 1) return nums.get(0);
		if(nums.size() == 2) return Math.max(nums.get(0), nums.get(1));

		int ans = solve(nums,0);

		return ans;

	}
}


// Method 2

import java.util.* ;
import java.io.*; 
import java.util.*;

class Result {
	int maxSum;

	Result(){
		this.maxSum = 0;
	}
}

public class Solution {

	public static void solve(ArrayList<Integer> nums,int sum,int i,Result res){

		if(i >= nums.size()){
			res.maxSum = Math.max(sum,res.maxSum);
			return;
		}

		// include
		solve(nums,sum+nums.get(i),i+2,res);

		// exclude
		solve(nums,sum+0,i+1,res);


	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		
		if(nums.size() <= 0) return 0;
		if(nums.size() == 1) return nums.get(0);
		if(nums.size() == 2) return Math.max(nums.get(0), nums.get(1));

		Result res = new Result();

		

		solve(nums,0,0,res);

		return res.maxSum;

	}
}


// method 3 (optimized)

class Solution{
    
    public int solve(int arr[],int i ,int n,int dp[]){
        if(i >= n) return 0;
        
        if(dp[i] != 0) return dp[i];
        // include
        int ans1 = arr[i] + solve(arr,i+2,n,dp);
        
        // exclude 
        int ans2 = 0 + solve(arr,i+1,n,dp);
        
        dp[i] = Math.max(ans1,ans2);
        
        return dp[i];
    }
    
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        int dp[] = new int[n+1];
        return solve(arr,0,n,dp);
    }
}


Special Note : INCLUDE EXCLUDE PATTERN HAI YE BHAI 🔥🔥🔥


// These question has the same logic as above

House robber / Stickler thief :

1. https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

2. https://leetcode.com/problems/house-robber/