// Method 1

        class Solution {
    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {
        
        int min = -1;
  
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
  
        // Traverse the input array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // If element is already in hash set, update min
            if (set.contains(arr[i]))
                min = i;
  
            else // Else add element to hash set
                set.add(arr[i]);
        }
  
        // Print the result
        if (min != -1){
        // return position not index , if we want the element then arr[min]
            return min+1; 
        }
        else
            return -1;
        
    }
}



// Method 2             

class Solution {
    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {
        // Create a HashMap to store the elements and their positions.
        Map<Integer, Integer> map = new HashMap<>();
        
        // Initialize 'min' to a maximum value to track the minimum position of a repeating element.
        int min = Integer.MAX_VALUE;
        
        // Iterate through the array 'arr' to find the first repeating element.
        for (int i = 0; i < n; i++) {
            // Check if the current element 'arr[i]' is already in the 'map'.
            if (map.containsKey(arr[i])) {
                // If it's in the 'map', update 'min' with the minimum position of the repeating element.
                min = Math.min(min, map.get(arr[i]));
            } else {
                // If it's not in the 'map', add it with its current position 'i'.
                map.put(arr[i], i);
            }
        }
        
        // Check if 'min' was updated during the iteration. If not, return -1 as there are no repeating elements.
        // Otherwise, add 1 to 'min' and return the position of the first repeating element.
        return min == Integer.MAX_VALUE ? -1 : min + 1;
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/first-repeating-element4018/1


Steps :- 1. Create a map.
         2. Put elements one by one from the array.
         3. When found a repeating number then check if it is present on the lesser index, if yes then store it.
         4. Finally return ans.
