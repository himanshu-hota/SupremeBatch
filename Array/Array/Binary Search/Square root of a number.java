// Method 1

public class Solution {

    // Method to calculate the integer square root of a given long N
    public static int sqrtN(long N) {
        
        // If N is 0, the square root is 0
        if(N == 0) return 0;

        // Initialize the answer variable to 1
        int ans = 1;

        // Loop until the square of ans exceeds N
        while(ans <= (N/ans)){
            ans++;
        }

        // Since the loop exits when ans^2 > N, return ans-1 as the integer square root
        return ans-1;

    }
}

Steps : 1. The idea is to find the number which divides the N and the remainder is equal greater then the number itself.
        2. If we get the num that divides the number and remainder is greater than the num then we try for greater value. Otherwise lesser value.



// Method 2

public class Solution {

	public static int sqrtN(long n) {
		
		if (n == 0 || n == 1) {
            return (int)(n);
        }

        long low = 1, high = n, result = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            // Instead of calculating mid * mid, we compare mid with n / mid
            if (mid <= n / mid) {
                low = mid + 1;
                result = mid;  // Update result as we found a potential floor value
            } else {
                high = mid - 1;
            }
        }

        return (int)(result);  
	}
}


// Method 3


public class Solution {

	public static int sqrtN(long n) {
		
	      if (n == 0 || n == 1) {
            return (int)(n);
        }

        long low = 1, high = n, result = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long square = mid * mid;

            if (square == n) {
                return (int)(mid);  // n is a perfect square, return the square root
            } else if (square < n) {
                low = mid + 1;
                result = mid;  // Update result as we found a potential floor value
            } else {
                high = mid - 1;
            }
        }

        return (int)(result);
	}
}

CodeStudio : https://www.codingninjas.com/studio/problems/square-root-integral_893351?leftPanelTab=0%3Futm_source%3Dstriver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM

GFG : https://practice.geeksforgeeks.org/problems/find-nth-root-of-m5843/1