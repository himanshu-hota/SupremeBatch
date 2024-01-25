// Method 1

public class Solution {

    // This method checks if the given array 'arr' contains the target integer 'target'.
    // It iterates through the elements of 'arr' and returns true if 'target' is found, otherwise, it returns false.
    public static boolean ls(int arr[], int target) {
        for (int x : arr) {
            if (x == target) {
                return true;
            }
        }
        return false;
    }

    // This method calculates the length of the longest sequence of successive elements in the array 'a'.
    public static int longestSuccessiveElements(int[] a) {
        int count = 0;  // Initialize the count of the longest successive sequence to 0.

        // Iterate through each element 'x' in the array 'a'.
        for (int x : a) {
            int currCount = 1;  // Initialize the current count to 1 for the current element 'x'.

            // While there is a successive element in the array, increment 'x' and increase the current count.
            while (ls(a, x + 1)) {
                x++;
                currCount++;
            }

            // Update the longest count if the current count is greater.
            count = Math.max(count, currCount);
        }

        return count;  // Return the length of the longest successive sequence.
    }
}


// Method 2

public class Solution {

    // This method checks if the given array 'arr' contains the target integer 'target'.
    // It returns true if 'target' is found, otherwise, it returns false.
    public static boolean ls(int arr[], int target) {
        for (int x : arr) {
            if (x == target) {
                return true;
            }
        }
        return false;
    }

    // This method calculates the length of the longest sequence of successive elements in the array 'a'.
    public static int longestSuccessiveElements(int[] a) {
        int count = 0;  // Initialize the count of the longest successive sequence to 0.

        // Iterate through each element 'x' in the array 'a'.
        for (int x : a) {
            int currCount = 1;  // Initialize the current count to 1 for the current element 'x'.

            // While there is a successive element in the array, increment 'x' and increase the current count.
            while (ls(a, x + 1)) {
                x++;
                currCount++;
            }

            // Update the longest count if the current count is greater.
            count = Math.max(count, currCount);
        }

        return count;  // Return the length of the longest successive sequence.
    }
}


// Method 2

class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length <= 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();

        // Remove all duplicates & store unique values in the set.
        for(int x : nums) set.add(x);

        // if there is only one element then also the min conse. will be one.
        int consecutives = 1;

        // traverse the array
        for(int x : nums){
            
            // if just smaller than then current value exists in the set then skip this element.
            // and if it doesn't exists then start searching if there is greater element than current element.
            if(!set.contains(x - 1)){
                int curr = x;
                // check how many conse. elements are there in set.
                while(set.contains(curr)){
                    curr++;
                }

                // store the maximum conse. length.
                consecutives = Math.max(consecutives, curr - x);
            }
        }

        return consecutives;
    }
}

Steps : 1. Put each number into set to get hold of unique elements.
        2. Now keep in mind "Hum current element se kitni dur ja sakte hai wahi store karna hai, aise sabhi combinations me se jo bhi max distance ja sakta hai wahi answer hoga."
        3. It will give TLE, so will have to optimize it , To optimize it we can check if just smaller element of curr exist then no need to check for this current element because ye element kisi na kisi case me include ho jaega to isko mat karo check aur aage badho.


CodeStudio : https://www.codingninjas.com/studio/problems/longest-successive-elements_6811740?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

LeetCode : https://leetcode.com/problems/longest-consecutive-sequence/