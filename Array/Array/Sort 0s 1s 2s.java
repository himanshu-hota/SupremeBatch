// Method 1

class Solution {
    public static void sort012(int arr[], int n) {
        // Initialize count variables for 0s, 1s, and 2s
        int zero = 0;
        int one = 0;
        int two = 0;

        // Count the occurrences of 0s, 1s, and 2s in the array
        for (int x : arr) {
            if (x == 0) zero++;
            else if (x == 1) one++;
            else two++;
        }

        // Initialize the starting index
        int start = 0;

        // Place 0s at the beginning of the array
        while (zero > 0) {
            arr[start++] = 0;
            zero--;
        }

        // Place 1s after the 0s in the array
        while (one > 0) {
            arr[start++] = 1;
            one--;
        }

        // Place 2s at the end of the array
        while (two > 0) {
            arr[start++] = 2;
            two--;
        }
    }
}

Steps:- 1. Count the occurrences of 0, 1, 2 as k,m,n.
		2. Fill the first k with 0.
		3. Fill the first m with 1.
		4. Fill the first n with 2.


// Method 2
class Solution {
    public static void sort012(int arr[], int n) {
        // Initialize three pointers for elements 0, 1, and 2
        int low = 0;    // Pointer for 0s
        int mid = 0;    // Pointer for 1s
        int high = n - 1;  // Pointer for 2s
        int temp = 0;   // Temporary variable for swapping

        // Traverse the array until the mid pointer reaches the high pointer
        while (mid <= high) {

            // Check the value at the mid pointer and perform the appropriate action
            switch (arr[mid]) {
                case 0:
                    // Swap the value at the low pointer with the value at the mid pointer
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;

                    // Move the low and mid pointers one step ahead
                    low++;
                    mid++;
                    break;
                case 1:
                    // The value at mid is already 1, so just move the mid pointer one step ahead
                    mid++;
                    break;
                case 2:
                    // Swap the value at the mid pointer with the value at the high pointer
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;

                    // Move the high pointer one step back
                    high--;
                    break;
            }
        }
    }
}

Steps:- 1. Use three pointers low, mid and high.
		2. Iterate the array (loop till mid<=high)	
			a. if the element is 0 then swap low with mid and Increment both index.
			b. if the element is 1 then do nothing just move mid forward.
			c. if the element is 2 then swap mid with high and decrement high. (yahi galti karoge, sirf high ko decrement karna hai mid do ++ nahi karna hai).


GFG :- https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

Read more :- https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/