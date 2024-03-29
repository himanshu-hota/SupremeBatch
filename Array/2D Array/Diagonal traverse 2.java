class Solution {

    // Function to get the maximum number of columns in the given list of lists
    public int getMaxCol(List<List<Integer>> nums){
        int max = Integer.MIN_VALUE;
        for(List<Integer> x : nums){
            max = Math.max(x.size(), max);
        }
        return max;
    }

    // Function to find diagonal order traversal of a 2D list
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        // HashMap to store elements based on the sum of row and column indices
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Get the maximum number of rows and columns in the given list of lists
        int maxRow = nums.size();
        int maxCol = getMaxCol(nums);

        // Calculate the total number of diagonals
        int total = maxRow + maxCol;

        // Initialize lists in the HashMap for each diagonal
        for(int i = 0; i < total ; i++){
            map.put(i, new ArrayList<>());
        }

        // Populate the HashMap with elements from the input list of lists
        int totalElements = 0;
        for(int i = 0; i < maxRow; i++){
            for(int j = 0; j < nums.get(i).size(); j++){
                int key = i + j;
                map.get(key).add(nums.get(i).get(j));
                totalElements++;
            }
        }

        // Create an array to store the result in diagonal order
        int ans[] = new int[totalElements];
        int k = 0;
        
        // Traverse the HashMap diagonally and populate the result array
        for(int i = 0; i < total; i++){
            List<Integer> curr = map.get(i);
            
            // Traverse each diagonal in reverse order and add elements to the result array
            for(int j = curr.size() - 1; j >= 0; j--){
                ans[k++] = curr.get(j);
            }
        }

        return ans;
    }
}9


Steps : 1. Get the count of max rows and max cols.
        2. Lets assume max count of rows is i and max count of col is j, then the last element would be at (i,j).
        3. The max number of digonal traversal would be i+j times.
        4. Create a map and put 0 -> i+j as keys and put emty arraylist.
        5. These arraylist would contain the traversal values.
        6. Traverse tha matrix and get the key in map by i+j, and put element here.
        7. Now we have our map with diagonal elements.
        8. Put the elements from 0 -> i+j, in reverse order.
        9. Why reverse order ? -> because when we are adding elements we are going top to bottom and left to right , but the ans must be in order of top to bottom and then left to right.

LeetCode : https://leetcode.com/problems/diagonal-traverse-ii/
        