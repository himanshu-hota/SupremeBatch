	// bruteforce
	
	public static ArrayList<Integer> intersectionTwoArrays(ArrayList<Integer> arr , ArrayList<Integer> arr2) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
			
		for(int i = 0; i < arr.size() ; i++) {
			int element  = arr.get(i);
			for(int j = 0 ; j < arr2.size() ; j++) {
				if(element == arr2.get(j)) {
					//mark in second arraylist if already added
					arr2.set(j, Integer.MIN_VALUE);
					ans.add(element);
				}
			}
		}

		return ans;
	}
	
	// map method

	class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Create a map to store unique intersecting elements
        Map<Integer, Boolean> map = new HashMap<>();
        
        // Initialize pointers and lengths for the two input arrays
        int i = 0;
        int j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        // Sort the input arrays in ascending order
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // Compare elements in the sorted arrays
        while (i < n1 && j < n2) {
            if (nums1[i] == nums2[j]) {
                // If the elements match, add them to the map
                map.put(nums1[i], true);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                // If the element in the first array is smaller, move the pointer in the first array
                i++;
            } else {
                // If the element in the second array is smaller, move the pointer in the second array
                j++;
            }
        }

        // Create an array to store the unique intersecting elements
        int ans[] = new int[map.size()];
        i = 0;
        // Copy elements from the map to the result array
        for (int x : map.keySet()) {
            ans[i++] = x;
        }
        return ans;
    }
}


// Set method

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        int count = 0;

        for(int i = 0 ; i< nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int j = 0 ; j < nums2.length ; j++){
            if(set.contains(nums2[j])){
                set1.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        int[] arr = new int[set1.size()];
        for(int key: set1){
            arr[count] = key;
            count++;
        }
        return arr;
    }
}

 LeetCode :- https://leetcode.com/problems/intersection-of-two-arrays/
 

