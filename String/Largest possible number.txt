
class Solution{
    static String findLargest(int N, int S) {
        // If N is 1 and S is 0, the only possible number is 0.
        if (N == 1 && S == 0) {
            return "0";
        }

        // If N is greater than 1 and S is 0, it's not possible to form a valid number.
        if (N > 1 && S == 0) {
            return "-1";
        }

        // StringBuilder to store the result.
        StringBuilder ans = new StringBuilder();

        // Iterate through each digit.
        while (N-- > 0) {
            // Choose the maximum possible digit (9) or the remaining sum, whichever is smaller.
            int digit = Math.min(S, 9);
            ans.append(digit);
            S -= digit; // Update the remaining sum.
        }

        // If there is still a positive remaining sum, it's not possible to form a valid number.
        return S > 0 ? "-1" : ans.toString();
    }
}

Steps : 1. If we have 1 digit and sum 0 then return 0.
        2. If we have more than 1 digit and sum 0 then no ans is possible.
        3. As we know that we can add '9' which is largest digit that can sum up to given sum in minimum count of digits.
        4. So we keep adding 9 add subtract it with the given sum to minimize the sum.
        5. At the end we return the ans.

Special Note : S > 0 ? "-1" handles the case when we have more sum than the sum we can make with given digit count.

for example N = 9 and S = 82 , in this case we have 9 digit max number which is 999999999, this sums up to 81 but question says that make a num that has 9 digits and sums up to 81 which is not possible so return -1.

GFG : https://www.geeksforgeeks.org/problems/largest-number-possible5028/1

