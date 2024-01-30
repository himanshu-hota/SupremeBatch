class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int currentProduct = 1;

        // Forward traversal
        for (int num : nums) {
            currentProduct *= num;
            maxProduct = Math.max(maxProduct, currentProduct);
            if (currentProduct == 0) {
                currentProduct = 1;
            }
        }

        // Reset currentProduct for reverse traversal
        currentProduct = 1;

        // Reverse traversal
        for (int i = nums.length - 1; i >= 0; i--) {
            currentProduct *= nums[i];
            maxProduct = Math.max(maxProduct, currentProduct);
            if (currentProduct == 0) {
                currentProduct = 1;
            }
        }

        return maxProduct;
    }
}


Note : Kadane's algo.


LeetCode : https://leetcode.com/problems/maximum-product-subarray/

CodeStudio : https://www.codingninjas.com/studio/problems/subarray-with-maximum-product_6890008?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM