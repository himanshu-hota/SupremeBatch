class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int a = m-1; 
        int b = n-1;
        // this will point to the index where final elements will be put.
        int pos = m+n-1;

        // iterate the array and keep putting the larger element at pos index.
        while(a >=0  && b >= 0){
            int first = nums1[a];
            int second = nums2[b];

            // if array1 has larger element then put element from array1, otherwise from array2
            if(first >= second){
                nums1[pos--] = nums1[a--];
            }else{
                nums1[pos--] = nums2[b--];
            }
        }

        // put the remaining elements.
        while(b >= 0){
            nums1[pos--] = nums2[b--];
        }

    }
}

// Note : we are filling from end because if we try to fill from begining by putting smaller at pos index then what about if we found 0 at any index? thats why we are filling elements from end.

LeetCode : https://leetcode.com/problems/merge-sorted-array/
