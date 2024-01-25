import java.util.HashSet;

class Solution {
    // This method takes two arrays 'a' and 'b' along with their respective sizes 'n' and 'm'.
    // It calculates the union of the elements in the two arrays and returns the count of unique elements in the union.
    public static int doUnion(int a[], int n, int b[], int m) {
        // Create a HashSet to store unique elements from both arrays.
        HashSet<Integer> set = new HashSet<>();
        
        // Add all elements from array 'a' to the HashSet.
        for (int x : a) {
            set.add(x);
        }
        
        // Add all elements from array 'b' to the HashSet.
        for (int x : b) {
            set.add(x);
        }
        
        // The size of the HashSet now represents the count of unique elements in the union of 'a' and 'b'.
        return set.size();
    }
}


Steps : 1. Add all elements of a to set.
        2. Add all elements of b to set.
        3. Since the HashSet contains only unique value then its size would be our answer.

GFG :- https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1