class Solution {
    public int[][] merge(int[][] intervals) {
        // Create an ArrayList to store the merged intervals.
        List<int[]> ans = new ArrayList<>();
        
        // Get the number of intervals.
        int n = intervals.length;
        
        // If there are no intervals, return an empty array.
        if (n == 0) return ans.toArray(new int[0][]);

        // Sort the intervals based on their starting values.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize variables to track the current merged interval.
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Iterate through the sorted intervals.
        for (int interval[] : intervals) {
            int currStart = interval[0];
            int currEnd = interval[1];

            // If the current interval overlaps with the previous one, merge them.
            if (currStart <= end) {
                end = Math.max(end, currEnd);
            } else {
                // If there is no overlap, add the current merged interval to the result.
                ans.add(new int[]{start, end});
                // Update the start and end to the new interval.
                start = currStart;
                end = currEnd;
            }
        }

        // Add the last merged interval to the result.
        ans.add(new int[]{start, end});

        // Convert the ArrayList to an array of integer arrays and return it.
        return ans.toArray(new int[0][]);
    }
}


Steps: 1. Sort the array so that we can merge intervals smoothly.
       2. Pick 0th element of first array as start and 1th element as end.
       3. Iterate the matrix/given array of arrays, and pull out currEnd, currStart.
       4. Check if this interval overlaps with previous, if yes then marge them by picking start from previous array and end (max of currEnd and prevMax).
       5. if it doesn't overlap then simply add it to the ans.


leetcode : https://leetcode.com/problems/merge-intervals/