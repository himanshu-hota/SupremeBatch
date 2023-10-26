
// Method 1

class Solution {
    int missingNumber(int arr[], int n) {
        
        // get sum of all elements in the array
        int result = 0;
        for (int num : arr) {
            result += num;
        }
        
        // right shift opearator diveides the num / 2;
        int actualSum = (n * (n+1)) >> 1 ;
        
        // subtract the total actual sum value with sum of array elements to get the missing elements
        int missingElement = actualSum - result;
        return missingElement;
    }
}



// Method 2

class Solution {
    int missingNumber(int arr[], int n) {
        // Initialize the result to 0; it will accumulate the XOR of elements in the array.
        int result = 0;
        
        // Calculate the XOR of all elements in the array.
        for (int num : arr) {
            result ^= num;
        }

        // Initialize expectedXOR to 0; it will accumulate the XOR of expected sequence elements.
        int expectedXOR = 0;
        
        // Calculate the XOR of numbers from 1 to N (inclusive).
        for (int i = 1; i <= n; i++) {
            expectedXOR ^= i;
        }

        // Calculate the missing element by XORing expectedXOR and result.
        int missingElement = expectedXOR ^ result;
        
        // Return the missing element.
        return missingElement;
    }
}


GFG :- https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


Steps :- 1. Get sum of all elements from the array.
         2. Get the actual sum.
         3. Subtract actual sum with sum of array elements.
         4. the value after subtracting is the ans.   