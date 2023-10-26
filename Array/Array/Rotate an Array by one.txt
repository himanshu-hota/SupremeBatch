
class Compute {
    
       static void reverse(int arr[], int start, int end) {
        int temp = 0;
        // Use a temporary variable to swap elements from 'start' to 'end'
        while (start <= end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // Move the 'start' pointer forward and the 'end' pointer backward
            start++;
            end--;
        }
    }

    
    public void rotate(int arr[], int n)
    {
        int k = 1;
        
        // Calculate the effective rotation count 'k' by taking 'k' modulo 'n'
        k = k % n;
        // Calculate the pivot point for rotation (n - k)
        k = n - k;

        // Step 1: Reverse the first 'k' elements
        reverse(arr, 0, k - 1);

        // Step 2: Reverse the remaining 'n-k' elements
        reverse(arr, k, n - 1);

        // Step 3: Reverse the entire array to obtain the final rotated array
        reverse(arr, 0, n - 1);
    }
}

GFG :- https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article


Large Rotation Values: If k is greater than the length of the array n, it means that you're rotating the array more times than there are elements. For example, if the array has 5 elements, and you want to rotate it 7 times to the right, it's equivalent to rotating it 2 times (7 % 5 = 2). This operation effectively reduces k to the smallest positive integer that produces the same effect.

Negative Rotation Values: If k is negative, it represents a left rotation. However, it's common to work with positive rotation values. By applying k % n, you're effectively converting a negative left rotation into an equivalent positive right rotation. For example, if you want to perform a left rotation of -3, it's equivalent to a right rotation of 2 (3 % 5 = 2 in an array of length 5).