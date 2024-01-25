// Method 1

public class Solution {
    // Function to find pairs in the array whose sum is equal to 'k'
    public static List<int[]> pairSum(int[] arr, int k) {
        // Get the length of the array
        int n = arr.length;

        // List to store pairs that satisfy the condition
        List<int[]> ans = new ArrayList<>();

        // Iterate through the array to find pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if the sum of elements at indices i and j is equal to 'k'
                if (arr[i] + arr[j] == k) {
                    // Determine the smaller and greater elements among the pair
                    int small = arr[i] < arr[j] ? arr[i] : arr[j];
                    int greater = arr[i] > arr[j] ? arr[i] : arr[j];

                    // Add the pair to the list
                    ans.add(new int[]{small, greater});
                }
            }
        }

        // Sort the list based on the smaller element of each pair
        Collections.sort(ans, (a, b) -> Integer.compare(a[0], b[0]));

        // Return the list of pairs
        return ans;
    }
}


// Method 2

public class Solution {
    // Function to find pairs in the array with a sum equal to k and store them in a list
    public static List<int[]> pairSum(int[] arr, int k) {
        // List to store the pairs
        List<int[]> ans = new ArrayList<>();
        // HashMap to store the frequency of each element in the array
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array elements
        for (int x : arr) {
            // Check if there is a complement in the map
            if (map.containsKey(k - x)) {
                // Determine the order of elements in the pair
                int greater = x > (k - x) ? x : (k - x);
                int small = x < (k - x) ? x : (k - x);

                // Add the pair to the list as many times as its frequency in the array
                for (int i = 0; i < map.get(k - x); i++)
                    ans.add(new int[]{small, greater});
            }
            // Update the frequency of the current element in the map
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // Sort the list of pairs based on the first element of each pair
        Collections.sort(ans, (a, b) -> Integer.compare(a[0], b[0]));

        // Return the list of pairs
        return ans;
    }
}


Special Note : This question is related to "Count pair with given sum" just did some modification and thats all.

Link : https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1

CodeStudio : https://www.codingninjas.com/studio/problems/pair-sum_697295?leftPanelTabValue=PROBLEM