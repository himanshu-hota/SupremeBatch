// Method 1

class Solution {
    
    // Recursive helper function to check if there exists a subsequence with sum equal to 'k'
    private static boolean helper(int arr[], int i, int k, int sum) {
        // Base case: if the index is beyond the array length
        if (i >= arr.length) {
            return sum == k; // Check if the sum is equal to 'k'
        }
      
        // Include the current element in the subsequence
        boolean ans1 = helper(arr, i + 1, k, sum + arr[i]);
            
        // Exclude the current element from the subsequence
        boolean ans2 = helper(arr, i + 1, k, sum);
      
        // Return true if either the included or excluded subsequence has the sum 'k'
        return ans1 || ans2;
    }
    
    // Main method to check if there exists a subsequence with sum equal to 'k'
    public static boolean checkSubsequenceSum(int N, int[] arr, int k) {
        // Call the helper function starting from index 0 with initial sum 0
        return helper(arr, 0, k, 0);
    }
}


// Method 2

class Solution {
    
    // Recursive helper function to check if there exists a subsequence with sum equal to 'k'
    private static boolean helper(int arr[], int i, int k, int sum) {
        // Base case: if the index is beyond the array length
        if (i >= arr.length) {
            return sum == k; // Check if the sum is equal to 'k'
        }
      
        // Include the current element in the subsequence
        boolean ans1 = helper(arr, i + 1, k, sum + arr[i]);
      
        // If the sum is found in the included subsequence, return true
        if (ans1) return true; // This line is a optimisation from above approach , this avoids the further recursive calls if we already have found a subsequence that sums to k.
      
        // Exclude the current element from the subsequence
        boolean ans2 = helper(arr, i + 1, k, sum);
      
        // Return true if either the included or excluded subsequence has the sum 'k'
        return ans1 || ans2;
    }
    
    // Main method to check if there exists a subsequence with sum equal to 'k'
    public static boolean checkSubsequenceSum(int N, int[] arr, int k) {
        // Call the helper function starting from index 0 with initial sum 0
        return helper(arr, 0, k, 0);
    }
}


// Method 3


class Solution {
    
  private static boolean helper(int arr[],int i,int k , int sum){
      
      // this single line optimised the above approach by not making call further when the current sum exceeds the given k.
      if(sum > k) return false;
      
      if(i >= arr.length){
         return sum == k;
      }
      
      // include
      boolean ans1 = helper(arr,i+1,k,sum+arr[i]);
      
      if(ans1) return true;
      
      // exclude
      boolean ans2 = helper(arr,i+1,k,sum);
      
      if(ans2) return true;
      
      return false;
  }
    
  public static boolean checkSubsequenceSum(int N, int[] arr, int k) {
      
      return helper(arr,0,k,0);

  }
}

// Print all subsequences sum to k 

import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main"
class Main {

    public static void solve(int arr[],List<List<Integer>> ans,ArrayList<Integer> curr,int i,int sum){

      if(sum < 0) return;

      if(i>=arr.length){
        if(sum == 0){
          ans.add(new ArrayList(curr));
       
        }
         return;
      }      

      // include
      curr.add(arr[i]);
      solve(arr,ans,curr,i+1,sum-arr[i]);
      curr.remove(curr.size()-1);

      // exclude
      solve(arr,ans,curr,i+1,sum);

    }

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int sum = 10;
        List<List<Integer>> ans = new ArrayList<>();
        solve(arr,ans,new ArrayList<Integer>(),0,sum);

        for(List<Integer> x : ans){
          for(int z : x){
             System.out.print(z + ",");
          }
           System.out.println();
        }

    }
}



GFG : https://practice.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/1
