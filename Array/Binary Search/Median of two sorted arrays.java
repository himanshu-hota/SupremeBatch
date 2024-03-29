// Method 1

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;

        
        int mid1 = (n/2)-1;
        int mid2 = n/2;
        int count = 0;
        double ele1 = -1;
        double ele2 = -1;
        int i = 0;
        int j = 0;
        while( i < n1 && j < n2 ){

            if(a[i] < b[j]){
                
                if(count == mid1) ele1 = a[i];
                if(count == mid2) ele2 = a[i];
                i++;
                count++;

            }else{
                
                if(count == mid1) ele1 = b[j];
                if(count == mid2) ele2 = b[j];
                j++;
                count++;

            }

        }

        while( i < n1 ){
            
            if(count == mid1) ele1 = a[i];
            if(count == mid2) ele2 = a[i];
            i++;
            count++;
        }

        while( j < n2){
              
            if(count == mid1) ele1 = b[j];
            if(count == mid2) ele2 = b[j];
            j++;
            count++;
        }

        System.out.println(ele1 + " , " + ele2);

        if((n&1) == 0){
            return (ele1+ele2)/2.0;
        }else{
            return ele2;
        }

    }
}

// Optimiazed of above

class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        
        // Get the lengths of the input arrays
        int n1 = a.length;
        int n2 = b.length;
        // Calculate the total length of the merged array
        int n = n1 + n2;

        // Calculate the indices for the two middle elements
        int mid1 = (n / 2) - 1;
        int mid2 = n / 2;
        // Initialize variables to track the elements at the middle indices
        double ele1 = -1;
        double ele2 = -1;
        // Initialize counters and pointers for array traversal
        int count = 0;
        int i = 0;
        int j = 0;
        // Flag to indicate whether both middle elements have been found
        boolean foundBoth = false;

        // Iterate through both arrays until one of them is fully traversed
        while (i < n1 && j < n2) {

            // Compare elements from both arrays and update middle elements accordingly
            if (a[i] < b[j]) {
                
                if (count == mid1) ele1 = a[i];
                if (count == mid2) {
                    ele2 = a[i];
                    // Set the flag to indicate that both middle elements have been found
                    foundBoth = true;
                    break;
                }
                i++;
                count++;

            } else {
                
                if (count == mid1) ele1 = b[j];
                if (count == mid2) {
                    ele2 = b[j];
                    // Set the flag to indicate that both middle elements have been found
                    foundBoth = true;
                    break;
                }
                j++;
                count++;

            }

        }

        // If the second middle element has not been found yet and there are remaining elements in the first array
        while (!foundBoth && (i < n1)) {
            
            if (count == mid1) ele1 = a[i];
            if (count == mid2) ele2 = a[i];
            i++;
            count++;
        }

        // If the second middle element has not been found yet and there are remaining elements in the second array
        while (!foundBoth && (j < n2)) {
              
            if (count == mid1) ele1 = b[j];
            if (count == mid2) ele2 = b[j];
            j++;
            count++;
        }

        // Determine and return the median based on whether the total number of elements is even or odd
        if ((n & 1) == 0) {
            return (ele1 + ele2) / 2.0;
        } else {
            return ele2;
        }

    }
}


// Method 2

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Get the lengths of the input arrays
        int n = nums1.length;
        int m = nums2.length;

        // Ensure nums2 is the larger array to simplify the following logic
        if (m < n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // Calculate the position of the left boundary for the merged array
        int left = (n + m + 1) / 2;
        // Initialize low and high for binary search
        int low = 0;
        int high = n;

        // Binary search to find the correct position of the median
        while (low <= high) {
            // Calculate midpoints for both arrays
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;

            // Initialize values for the left and right elements of the partitions
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            // Update values based on the midpoints
            if (mid1 < n) { r1 = nums1[mid1]; }
            if (mid2 < m) { r2 = nums2[mid2]; }
            if (mid1 - 1 >= 0) { l1 = nums1[mid1 - 1]; }
            if (mid2 - 1 >= 0) { l2 = nums2[mid2 - 1]; }

            // Check if the current partitions are valid for finding the median
            if (l1 <= r2 && l2 <= r1) {
                // If the total number of elements is odd, return the maximum of the left elements
                if ((n + m) % 2 == 1) {
                    return Math.max(l1, l2);
                }
                // If the total number of elements is even, return the average of the maximum left and minimum right elements
                return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) {
                // If l1 is too large, adjust the search space to the left
                high = mid1 - 1;
            } else {
                // If l2 is too large, adjust the search space to the right
                low = mid1 + 1;
            }
        }

        // If no median is found, return 0.0
        return 0.0;
    }
}

Steps : 1. Median hamesha middle element hota hai , agar even number of elements hai to (n/2 + n/2+1)/2 wala aur agar odd ho to n/2 wala.
        2. 

Note : 1. (l1,r1) , (l2,r2) is type ka combination nahi hai.
       2. l1 --> ye batata hai ki kitne elements left array se pick karna hai (starting se).
          l2 --> ye batata hai ki kitne elements right array se pick karna hai (starting se).
          r1 --> ye batata hai ki kitne elements l1 tak chhodkar left se honge.
          r2 --> ye batata hai ki kitne elements l2 tak chhodkar right se honge.
       3. int left = (n+m+1)/2; is condition me +1 is liye hai kiya hai kyoki hum left wale array me se jyada elements lena chahte hain.
       4. Chhote wale array ko traverse kar rahe hai kyoki isse complexity better milege kyoki search space kam hoga.
       5. int left = (n + m + 1) / 2; ye batata hai ki kitne elements left se pick karne hain.



LeetCode : https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/4284137/100-best-approach-using-binary-search/

CodeStudio : https://www.codingninjas.com/studio/problems/median-of-two-sorted-arrays_985294?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM