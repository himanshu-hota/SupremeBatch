class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Initialize a long variable to store the current element in the row.
        long ans = 1L;

        // Create an ArrayList to store the elements of the row.
        ArrayList<Integer> result = new ArrayList<>();

        // The first element in the row is always 1, so add it to the ArrayList.
        result.add((int)ans);

        // Iterate through the row to calculate each element.
        for (int i = 1; i <= rowIndex; i++) {
            // Calculate the next element using the formula for Pascal's triangle.
            ans = ans * (rowIndex - i + 1);
            ans = ans / i;

            // Add the calculated element (casted to int) to the ArrayList.
            result.add((int)ans);
        }

        // Return the ArrayList containing the elements of the row.
        return result;
    }
}

LeetCode : https://leetcode.com/problems/pascals-triangle-ii/