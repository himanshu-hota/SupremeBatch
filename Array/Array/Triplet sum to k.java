// method 1

class Solution {
    // Function to find if there exists a triplet in the array A[] which sums up to X.
    public static boolean find3Numbers(int a[], int n, int k) { 
        // Iterate through the array to find the first element of the triplet.
        for (int i = 0; i < n; i++) {
            int s1 = k - a[i]; // Calculate the sum required to find the other two elements.
            HashSet<Integer> set = new HashSet<>(); // Create a HashSet to store elements we've seen.

            // Iterate through the elements to find the second element of the triplet.
            for (int j = i + 1; j < n; j++) {
                int s2 = s1 - a[j]; // Calculate the sum required to find the third element.

                // Check if the HashSet contains the required sum (s2) as an element.
                if (set.contains(s2)) {
                    return true; // Triplet found, return true.
                } else {
                    set.add(a[j]); // Add the current element to the HashSet for future checks.
                }
            }
        }

        // No triplet was found in the array that sums up to X, so return false.
        return false;
    }
}

// method 2

class Solution {
    // Function to find if there exists a triplet in the array A[] which sums up to X.
    public static boolean find3Numbers(int a[], int n, int X) { 
        // Sort the input array in ascending order for efficient triplet search.
        Arrays.sort(a);
       
        for(int i = 0; i < n; i++){
            int l = i + 1; // Initialize the left pointer.
            int r = n - 1; // Initialize the right pointer.
           
            // Use a two-pointer approach to find a triplet that sums up to X.
            while (l < r) {
                int sum = a[i] + a[l] + a[r];
                
                if (sum == X) {
                    return true; // Triplet found, return true.
                } else if (sum < X) {
                    l++; // If the sum is less than X, increment the left pointer to increase the sum.
                } else {
                    r--; // If the sum is greater than X, decrement the right pointer to decrease the sum.
                }
            }
        }
    
        // No triplet was found in the array that sums up to X, so return false.
        return false;
    }
}



GFG :- https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1



