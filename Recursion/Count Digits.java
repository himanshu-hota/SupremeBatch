// Method 1

class Solution{
    static int evenlyDivides(int n){
        
        if(n == 0) return 0;
        int N = n;
        int count = 0;
        
        while(N>0){
            int digit = N%10;
            if(digit != 0 && n%digit == 0) count++;
            N /= 10;
        }
        
        return count;
        
    }
}

// Method 2

class Solution {
    
    // Function to count the number of digits in a given number
    static int countDigits(int n) {
        // Base case: If the number is 0, there are no digits
        if (n == 0) 
            return 0;
        
        // Recursively count the digits by dividing the number by 10
        return 1 + countDigits(n / 10);
    }
    
    // Function to count the number of digits that evenly divide the given number
    static int evenlyDivides(int N) {
        // Get the count of digits in the given number
        int digits = countDigits(N);
        
        // Initialize a counter for the digits that evenly divide the number
        int count = 0;
        
        // Store the original number in 'num' for later reference
        int num = N;
        
        // Iterate through each digit of the number
        for (int i = 0; i < digits; i++) {
            // Extract the rightmost digit
            int digit = N % 10;
            
            // Check if the digit is not 0 and evenly divides the original number
            if (digit != 0 && num % digit == 0)
                count++;
            
            // Move to the next digit by dividing the number by 10
            N = N / 10;
        }
        
        // Return the count of digits that evenly divide the number
        return count;
    }
}


GFG : https://www.geeksforgeeks.org/problems/count-digits5716/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article