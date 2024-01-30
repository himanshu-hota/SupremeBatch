

// Method 1

class Main {
    public static void main(String[] args) {

      // int arr[] = {1,5,7,1};
      int arr[] = {2,2,2,2};
      int n = arr.length;
      int k = 4;
      for(int i = 0; i< n; i++){
        for(int j = i+1; j< n; j++){
          if(arr[i]+arr[j] == k)
            System.out.println(arr[i] + " , " + arr[j]);
        }
      }

    }
}

Steps : 1. Get all pairs and check if its sum id equal to k.

// Method 2

class Solution {
    // Function to count pairs in the array with a sum equal to k
    int getPairsCount(int[] arr, int n, int k) {
        // HashMap to store the frequency of each element in the array
        HashMap<Integer, Integer> map = new HashMap<>();
        // Variable to store the count of pairs
        int count = 0;

        // Iterate through the array elements
        for (int x : arr) {
            // Check if there is a complement in the map, increment count accordingly
            count += map.getOrDefault(k - x, 0);
            // Update the frequency of the current element in the map
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // Return the final count of pairs
        return count;
    }
}


Special Note : 1. Look at this equation =>  x + y = k
                                            y = k-x;
               2. We will try to find k-x each time. 

Steps : 1. First we check if the complement(k-x) is present in the map then get how many time it appears and simply add the frequency to the count.
        2. Now put the current element, if the current element already in the map then update its frequency.

GFG : https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
