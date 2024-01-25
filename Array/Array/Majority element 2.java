class Solution {
    // This method finds the elements in the given array that appear more than n/3 times (n is the length of the array).
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length; // Get the length of the input array.
        int k = n/3; // Calculate the threshold for an element to be considered a majority element.

        List<Integer> ans = new ArrayList<>(); // Create a list to store the majority elements.
        HashMap<Integer,Integer> map = new HashMap<>(); // Create a hash map to count the occurrences of each element.

        // Iterate through the input array 'nums' to count the occurrences of each element.
        for(int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1); // Update the count of the current element in the map.
        }

        // Iterate through the entries in the map to check if any element appears more than n/3 times.
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            int key = e.getKey(); // Get the element.
            int val = e.getValue(); // Get the count of the element.

            // If the count of the element is greater than 'k', it is a majority element, so add it to the result list.
            if(val > k) {
                ans.add(key);
            }
        }

        // Return the list of majority elements found in the input array.
        return ans;
    }
}


LeetCode : https://leetcode.com/problems/majority-element-ii/
