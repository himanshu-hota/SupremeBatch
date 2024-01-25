class Solution {
    // This function checks if the number of occurrences of each element in the 'arr' array is unique.
    public boolean uniqueOccurrences(int[] arr) {
        // Create a HashMap to store the count of occurrences for each element.
        Map<Integer, Integer> map = new HashMap<>();

        // Count the occurrences of each element in the 'arr' array and store them in the 'map'.
        for (int x : arr) {
            if (map.containsKey(x)) {
                // If the element already exists in the 'map', increment its count by 1.
                map.put(x, map.get(x) + 1);
            } else {
                // If the element is not in the 'map', add it with a count of 1.
                map.put(x, 1);
            }
        }

        // Create a HashSet to store the unique counts of occurrences.
        HashSet<Integer> set = new HashSet<>();

        // Check if the count of occurrences is unique by iterating through the values in 'map'.
        for (int x : map.values()) {
            if (set.contains(x)) {
                // If a count is already in the 'set', it means it's not unique, so return false.
                return false;
            } else {
                // If the count is unique, add it to the 'set' for future comparisons.
                set.add(x);
            }
        }

        // If all counts are unique, return true.
        return true;
    }
}

Steps: 1. Count frequency.
       2. Put it into set, if it already there then occurrences are not unique.
       3. Otherwise unique. 

LeetCode : https://leetcode.com/problems/unique-number-of-occurrences/
