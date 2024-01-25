// Method 1

class Solution {
    // Function to check if there are two elements in the array 'arr' that sum up to 'x'.
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // Create a HashMap to store elements from 'arr' as keys and their presence as values.
        Map<Integer, Boolean> map = new HashMap<>();
        
        // Iterate through the array 'arr' to find two elements that sum up to 'x'.
        for (int num : arr) {
            // Calculate the complementary value 'toFind' for the current 'num' to achieve 'x'.
            int toFind = x - num;
            
            // Check if 'toFind' is present in the 'map', meaning a pair with 'num' exists to achieve 'x'.
            if (map.containsKey(toFind)) {
                return true;
            } else {
                // If 'toFind' is not in the 'map', mark 'num' as present in the 'map'.
                map.put(num, true);
            }
        }
        
        // If the loop completes without finding a pair that sums up to 'x', return false.
        return false;
    }
}

Steps : 1. Create a map.
        2. Pick one element and check if x - element is present in the map , if yes then we found a pair, return true.
        3. Otherwise put the element into the map.


// Method 2

class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int k) {
        // code here
        Arrays.sort(arr);
        int start = 0; 
        int end = arr.length-1;
        int currSum = 0;

        // traverse the array
        while(start < end){
            // calculate current sum
            currSum = arr[start] + arr[end] ;
            // if current sum is = targetSum then it is the pair we are searching for
            if(currSum == k) return true;
            // if the sum is greater then we need to reduce it by moving end one step back
            else if(currSum > k) end = end-1;
            // otherwise move start one step forward
            else start = start+1;
        }

        // if we reach here then there is no pair that sum up to given target
        return false;

    }
}

Steps: 1. Sort the array.
       2. Put one pointer at starting point and one at ending point.
       3. Calculate current sum,
            a. if current sum is equal to the target sum then return true;
            b. if it is less than target then 'Make it large' by increamenting the start pointer.
            c. if it is greater than the target then 'Make it small' by decreasing the end pointer.
       4. If we reach till end then no pair is found.

GFG :- https://practice.geeksforgeeks.org/problems/key-pair5616/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
