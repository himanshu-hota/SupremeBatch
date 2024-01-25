// This is a simple Java program that demonstrates how to reverse an array.
public class Solution {
    public static void main(String[] args) {
        // Initialize an array with values from 1 to 9.
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length; // Get the length of the array.

        int start = 0; // Initialize the start pointer.
        int end = n - 1; // Initialize the end pointer.
        int temp = 0; // Temporary variable for swapping elements.

        // Print the original array.
        for (int x : arr) {
            System.out.print(x + ", ");
        }

        // Reverse the array using a two-pointer approach.
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++; // Move the start pointer to the right.
            end--;   // Move the end pointer to the left.
        }

        System.out.println(); // Print a newline for clarity.

        // Print the reversed array.
        for (int x : arr) {
            System.out.print(x + ", ");
        }
    }
}
