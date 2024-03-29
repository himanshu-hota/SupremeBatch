class Solution {

    // Recursive function to calculate x raised to the power of n
    public double solve(double x, long n){
        // Base case: if n is less than or equal to 0, return 1.0
        if (n <= 0) {
            return 1.0;
        }

        // Recursive call to calculate x^(n/2)
        double half = solve(x, n / 2);

        // If n is even, return the square of x^(n/2)
        if (n % 2 == 0) {
            return half * half;
        } else {
            // If n is odd, return x times the square of x^(n/2)
            return x * half * half;
        }
    }

    // Function to calculate x raised to the power of n
    public double myPow(double x, int n) {
        // Base case: if n is 0, return 1.0
        if (n == 0) {
            return 1.0;
        }

        // Convert n to a long and take its absolute value
        long nn = Math.abs((long)(n));

        // Calculate the result using the solve function
        double ans = solve(x, nn);

        // If n is negative, take the reciprocal of the result; otherwise, return the result
        return n < 0 ? 1.0 / ans : ans;
    }
}


Galti kaha karoge : long nn = Math.abs((long)(n)); isme n ko long me change karna bhul jaoge.


// Iterative way

class Solution {

    // Function to calculate x raised to the power of n
    public double myPow(double x, int n) {
        // Ensure nn is a non-negative long integer
        long nn = Math.abs((long)(n));

        // Initialize the result variable
        double ans = 1.0;

        // Iterate until nn becomes 0
        while (nn > 0) {
            // If nn is even, square x and halve nn
            if (nn % 2 == 0) {
                x = x * x;
                nn = nn / 2;
            } else {
                // If nn is odd, multiply ans by x and decrement nn by 1
                ans = x * ans;
                nn = nn - 1;
            }
        }

        // If n is negative, take the reciprocal of ans
        return n < 0 ? (double)(1.0) / (double)(ans) : ans;
    }
}

return n < 0 ? (double)(1.0) / (double)(ans) : ans; isme galti karoge , dono ko double me typecast kar k hi divide karna nahi to ans nahi aaega Integer.MIN_VALUE k liye.

Notes : 1. We convert the given n into long value. why is that?

    
Converting n to a long is done to handle the case where n is the most negative value for an integer. The issue arises because the most negative value for an integer cannot be represented as a positive integer. For example, in a 32-bit signed integer, the most negative value is -2147483648. If you try to take the absolute value of this using Math.abs, it will still be -2147483648 because it exceeds the maximum positive value representable by a 32-bit signed integer.

By converting n to a long before taking its absolute value, you ensure that the absolute value is correctly represented, avoiding overflow issues. The long type can represent a wider range of values compared to int, so it accommodates the entire range of possible integer values, including the most negative ones. This is a defensive programming practice to handle potential edge cases and ensure the correctness of the algorithm.


        2. Now we calculate till the n becomes 0.
        3. If n is a even number then we simply multiply the given x 2 times and half the given n.
        4. If n is a odd number then 
            a. we multiply it 2 times and with given x (in Recursive method).
            b. we multiply it with the store ans. and decrease n by 1.
        5. At the end we handle the sign whether the n was positive or negative, if it was negative then we divide 1.0/ans to get the correct value. otherwise simply return ans.

        whey we divided ? 
        
        When n is negative, the algorithm calculates the reciprocal of the result (1.0 / ans) before returning it. This is because, in the context of exponentiation, raising a number x to the power of a negative exponent is equivalent to taking the reciprocal of x raised to the positive exponent.

        For example, if n is -3, then x^n is equivalent to 1 / (x^3). Therefore, when the exponent n is negative, the algorithm returns the reciprocal of the positive result.


LeetCode : https://leetcode.com/problems/powx-n/description/