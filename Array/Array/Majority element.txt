// Method 1

class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int el = 0;
        int n = nums.length;

        // this loop will give us the element that has the most frequency in the array.
        for(int x : nums){
            if(count == 0){
                count = 1;
                el =x;
            }else if( x == el){
                count++;
            }else{
                count--;
            }
        }

        // reset the counter to count the freq. of the most occuring element.
        count = 0;

        // count the freq. of the most occuring eleemnt.
        for(int x : nums){
            if(x == el) count++;
        }

        // if it appears more than n/2 then it is the answer otherwise no possible answer exists.
        return count > n/2 ? el : -1;
    }

}

Steps: 1. Get the element that has the most freq.
       2. Count its freq. in the array.
       3. Check if it appears more than n/2 times. 

// Method 2

import java.util.*;

public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length; // Get the length of the 'nums' array.
        int k = n / 2; // Calculate the minimum count required for an element to be the majority element.

        HashMap<Integer, Integer> map = new HashMap<>(); // Create a HashMap to store element frequencies.

        // Count the frequency of each element in the 'nums' array.
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // Iterate through the HashMap entries to find the majority element.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(); // Get the element value.
            int val = entry.getValue(); // Get the frequency of the element.

            // Check if the frequency of the element is greater than or equal to 'k'.
            if (val > k) {
                return key; // Return the element as the majority element.
            }
        }

        return -1; // If there is no majority element, return -1.
    }
}

Steps : 1. Count frequency of each element.
        2. If frequency of any element seem to be more than n/2 then return this element.

// Mehtod 3 

class Solution {
    public int majorityElement(int[] nums) {
     Arrays.sort(nums)   ;
     return nums[nums.length/2];
    }
}

LeetCode : https://leetcode.com/problems/majority-element/submissions/924621134/

CodeStudio : https://www.codingninjas.com/studio/problems/majority-element_6783241?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM