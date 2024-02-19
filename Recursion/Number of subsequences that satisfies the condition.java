// Method 1

class Solution {
    
    public int helper(int arr[],int k , ArrayList<Integer> sub,int i){
        
        if(i>=arr.length){
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int x : sub){
                min = Math.min(min,x);
                max = Math.max(max,x);
            }
            if(min+max <= k){
                return 1;
            }

            return 0;
        }

        // include
        sub.add(arr[i]);
        int ans1 = helper(arr,k,sub,i+1);
        sub.remove(sub.size()-1);
        
        // exclude
        int ans2 = helper(arr,k,sub,i+1);

        return ans1 + ans2;

    }

    public int numSubseq(int[] nums, int target) {
        
        return helper(nums,target,new ArrayList<Integer>(),0) -1;
    }
}

// Method 2 (optimized)

class Solution {
    public int numSubseq(int[] nums, int target) {
        // Sort the array to make it easier to identify valid subsequences
        Arrays.sort(nums);

        // Calculate powers of 2 modulo MOD for efficient calculation of subsequences
        int power[] = new int[nums.length + 1];
        power[0] = 1;
        int MOD = 1000000007;
        for (int i = 1; i < power.length; i++) {
            power[i] = (2 * power[i - 1]) % MOD;
        }

        // Initialize pointers for the two ends of the array
        int start = 0;
        int end = nums.length - 1;

        // Variable to store the count of valid subsequences
        int ans = 0;

        // Iterate through the array while updating pointers based on the sum
        while (start <= end) {
            // If the sum of elements at start and end is less than or equal to target
            if (nums[start] + nums[end] <= target) {
                // Increment ans by the number of subsequences formed by the current pair
                ans = (ans + power[end - start]) % MOD; 
                // Move the start pointer to explore other valid pairs
                start++;
            } else {
                // If the sum is greater than target, move the end pointer to reduce the sum
                end--;
            }
        }

        // Return the final count of valid subsequences
        return ans;
    }
}


steps : 1. Two pointer will be used in this problem.
        2. Sort the array.
        3. Put a pointer at first and one at the last.
        4. According to the question the sum of the min and max of the subsequence must be less than target.
        5. So check if the sum of first and last pointed values is less <= target or not.
        6. If yes then all the subsequences of this array between this pointers will give us the possible ans. so now we would generate all the subsets/subsequences of this pointed array. formula is 2^n. where n is the number of elements end-start , but not including the start becaues we want start to be fixed so that min remains at the correct place.
        7. Now keep generating the ans for remaining.


LeetCode : https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/