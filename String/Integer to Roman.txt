class Solution {
    public String intToRoman(int num) {
       // Arrays to store Roman symbols and their corresponding values.
        String romanSymbols[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int values[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        // String to store the resulting Roman numeral.
        String ans = "";

        // Iterate through the values array.
        for (int i = 0; i < 13; i++) {
            // While the input number is greater than or equal to the current value,
            // append the corresponding Roman symbol to the result and subtract the value from the input.
            while (num >= values[i]) {
                ans += romanSymbols[i];
                num -= values[i];
            }
        }

        // Return the final Roman numeral representation.
        return ans;
    }
}

Steps : 1. We predefine some values and map this value to roman representation.
        2. We iterate through the array we defined (length of 13), and check which num in the array is <= the given num.
        3. We add the roman representation of this num to our answer, and subtract the value with given num.

Leetcode : https://leetcode.com/problems/integer-to-roman/

CodeStudio : https://www.codingninjas.com/studio/problems/integer-to-roman-numeral_981307