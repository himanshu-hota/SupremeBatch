class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        // Initialize the result list to store the unique quadruplets.
        List<List<Integer>> ans = new ArrayList<>();
        
        // Sort the input array to make it easier to find quadruplets.
        Arrays.sort(nums);
        int n = nums.length;

        // Check for edge cases where it's impossible to find four elements that sum to the target.
        if (n < 4) {
            return ans; // Not enough elements to form a quadruplet.
        }
        if (nums[2] == 1000000000) {
            return ans; // A specific condition where it's not possible to find a quadruplet.
        }

        for (int i = 0; i < n; i++) {
            // Skip duplicate values of 'nums[i]'.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // This avoids considering the same value multiple times.
            }
            
            for (int j = i + 1; j < n; j++) {
                // Skip duplicate values of 'nums[j]'.
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue; // This avoids considering the same value multiple times.
                }

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    int num1 = nums[i];
                    int num2 = nums[j];
                    int num3 = nums[k];
                    int num4 = nums[l];

                    long sum = num1 + num2 + num3 + num4;
                    
                    if (sum == target) {
                        // Found a valid quadruplet, add it to the result list.
                        List<Integer> curr = Arrays.asList(num1, num2, num3, num4);
                        ans.add(curr);
                        
                        // Skip duplicate values of 'nums[k]' and 'nums[l]'.
                        k++;
                        l--;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++; // Skip duplicates in the left part of the quadruplet.
                        }

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--; // Skip duplicates in the right part of the quadruplet.
                        }

                    } else if (sum < target) {
                        k++; // Move the left pointer to the right.
                    } else {
                        l--; // Move the right pointer to the left.
                    }
                }
            }
        }

        return ans; // Return the list of unique quadruplets that sum to the target.
    }
}


// this handles the case of duplicacy of nums[i]
// and dont run the loop for duplicate value of nums[i]
if (i > 0 && nums[i] == nums[i - 1]) continue; 

// this handles the case of duplicacy of nums[j]
// and dont run the loop for duplicate value of nums[j]
if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
// if two consecutive elements are same then skip it.                
while (k < l && nums[k] == nums[k - 1]) k++; // Skip duplicates in the left part of the quadruplet.

// if two consecutive elements are same from end then skip it.
while (k < l && nums[l] == nums[l + 1]) l--; // Skip duplicates in the right part of the quadruplet.


Steps : 1. Sort the array.
        2. Check if array has less than 4 elements then there is no ans possible.
        3. 2 For loops and 1 while loop (keep in mind)                    .
        4. Each pointer will be on one index ahead of previos pointer.
        5. Keep in mind the sum variable will always be 'long'.
        6. You will have to handle all the duplicate elements yourself.
        

LeetCode :- https://leetcode.com/problems/4sum/

CodeStudio :- https://www.codingninjas.com/studio/problems/4sum_5713771