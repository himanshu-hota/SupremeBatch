class Solution {
    
    public int findUnique(int a[], int n, int k){
        
        // Create a HashMap to store the frequency of each element in the array.
        Map<Integer, Integer> map = new HashMap<>();
        
        // Count the frequency of each element in the array.
        for (int x : a) {
            if (map.containsKey(x)) {
                // If the element is already in the map, increment its count.
                map.put(x, map.get(x) + 1);
            } else {
                // If the element is not in the map, add it with a count of 1.
                map.put(x, 1);
            }
        }
        
        // Iterate through the entries in the map to find the unique element.
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!(entry.getValue() % k == 0)) {
                // If the count is not a multiple of k, return the unique element.
                return entry.getKey();
            }
        }
        
        // If no unique element is found, return -1.
        return -1;
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/find-unique-element2632/1

