import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        // Create a map to count the frequency of each number in 'nums'
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Convert the map values to an array 'count' to represent the count of each number
        int[] count = new int[map.size()];
        int index = 0;
        for (int value : map.values()) {
            count[index++] = value;
        }

        // these two lines are optimizations.
        Arrays.sort(quantity);
        reverseArray(quantity);

        // Check if the quantities can be distributed among the counts
        return helper(count, quantity, 0);
    }

    // Recursive helper method to check if quantities can be distributed
    static boolean helper(int[] count, int[] quantity, int ithCustomer) {
        if (ithCustomer >= quantity.length) {
            // All quantities have been distributed, return true
            return true;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= quantity[ithCustomer]) {
                // Distribute the quantity to the current count
                count[i] -= quantity[ithCustomer];

                // Recursively check if remaining quantities can be distributed
                if (helper(count, quantity, ithCustomer + 1)) {
                    return true;
                }

                // Undo the distribution to explore other possibilities
                count[i] += quantity[ithCustomer];
            }
        }

        // Unable to distribute the quantities, return false
        return false;
    }

    // Helper method to reverse the elements of an array
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

Steps: 1. First we get frequencies of items in the numbers array to make distribution easy.
       2. Convert it into an array. (indices doesn't matter now (just keep in mind that we want to distribute, we are not asked to distribute any specific integer to any specific cutomer, so we can distribute any integer/item to any customer, with one constraint that only allowed to distribute same integer/item to ith customer)).
       3. Call the Recursive function.
       4. The base case saya that if we are able to reach till end of the array then we were successfull to distribute all integers to all customers.
       5. Try to distribute integers from 0 -> n (of count array). why from 0? --> because we are trying to distribute integer in any order, no specific order.
       6. If we have quantity equal to or more than the desired quantity from the customer then only we give this item to this customer.

       Optimizations : If we sort the array in reverse order then we can easily tell that if the customer with largest quantity is not satisfied then no need to check for others as question says that satisfy all customer.

Special Note :  solve(,,ithCustomer) ye wala parameter quantity array ko traverse karta hai aur Recursive function k andar wala for loop har ek ith customer k liye pure count array ko traverse karne k liye hai. pura kyo? kyoki kaise pata chalega ki kon sa count fit baith raha hai (sare combination try karna hai na).


LeetCode :- https://leetcode.com/problems/distribute-repeating-integers/description/