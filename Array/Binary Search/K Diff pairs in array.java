import java.util.*;

public class Solution {


	public static int getPairsWithDifferenceK(int arr[], int k) {
		//Write your code here
		int count = 0;
		int i = 0 ; 
		int j = i+1;

    //-------------------Brute 1 ------------------------
        // Arrays.sort(arr);
		// while( j< arr.length){
		// 	int diff = Math.abs(arr[i] - arr[j]);
		// 	if(diff == k){
		// 		count++;
		// 		i++;
		// 		j++;
		// 	}else if(diff < k){
		// 		j++;
		// 	}else {
		// 		i++;
		// 	}
		// }
        //------------------- End ------------------------


    //-------------------Brute 2 ------------------------
		for(i=0 ; i< arr.length ; i++){
			for(j=i+1 ; j< arr.length ; j++){
				int diff = Math.abs(arr[i] - arr[j]);

				if(diff==k){
					count++;
				}
			}
		}
        //-------------------Brute 1------------------------
		return count;
	}
}






-----------------------------------Optimized---------------------------------------------------


class Solution {
    // Binary search method to check if 'target' exists in the sorted array 'arr'
    public boolean bs(int arr[], int start, int target) {
        int end = arr.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true; // 'target' found, return true
            } else if (arr[mid] < target) {
                start = mid + 1; // Adjust 'start' to search in the right half
            } else {
                end = mid - 1; // Adjust 'end' to search in the left half
            }
        }

        return false; // 'target' not found, return false
    }

    // Method to find pairs in the 'nums' array with a difference of 'k'
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // Create a map to store pairs
        Arrays.sort(nums); // Sort the 'nums' array
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int num1 = nums[i];
            int num2 = nums[i] + k; // Calculate the potential second number in the pair

            // If a number with a difference of 'k' exists in the array, add it to the map
            if (bs(nums, i + 1, num2)) {
                map.put(num1, num2);
            }
        }

        

        return map.size(); // Return the count of unique pairs found
    }
}

why we are doing curr+k instead of curr -k

For example, let's say you have an array [1, 3, 5] and you are looking for k-diff pairs with k = 2. If you choose curr - k, you would be checking for pairs like (1, -1), (3, 1), etc., which might not be meaningful in the context of finding pairs with an absolute difference of k.

On the other hand, using curr + k ensures that you are looking for pairs where the second element is k greater than the first one, resulting in pairs like (1, 3), (3, 5), which satisfies the condition |nums[i] - nums[j]| == k.

Special Note : 1. element1 + k = element2 agar hai to simiple hai ki element1 - element2 = k hoga.
               2. Har ek element pe jao aur check karo ki kya aisa koi element hai jo element1+k ho, agar hai to ek pair mil gaya bhaisab.

Note :- 1. In the Optimized Solution we are sorting the array.
        2. then we are traversing the array and checking if for any element at index 'i'
           there is an element in the range i+1 to n such that arr[i] - arr[x] = key
           which can be also written as arr[i] + k = arr[x]
        3. then we are performing Binary Search to search the element and then 
           adding the pair (arr[i] , arr[i+1] + k) to the map for unique pairs.



LeetCode : https://leetcode.com/problems/k-diff-pairs-in-an-array/

GFG : https://practice.geeksforgeeks.org/problems/count-distinct-pairs-with-difference-k1233/1