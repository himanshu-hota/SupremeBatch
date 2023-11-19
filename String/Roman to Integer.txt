class Solution {
    public int romanToInt(String s) {
        // Create a HashMap to store the values of Roman numerals
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        // Initialize variables for the result and the previous value
        int result = 0;
        int prevValue = 0;

        // Iterate through the input string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int currValue = map.get(ch); // Get the value of the current Roman numeral

            // Check if the current value is less than the previous value
            if (currValue < prevValue) {
                // If so, subtract the current value (following the Roman numeral rules)
                result -= currValue;
            } else {
                // If not, add the current value to the result
                result += currValue;
            }

            // Update the previous value for the next iteration
            prevValue = currValue;
        }

        // Return the final result
        return result;
    }
}


Steps :  1. Create a map store all the roman representation and its corresponding integer.
         2. Traverse the string from end to start.
         3. Pick one Character and get its corresponding integer.
         4. If this integer is smaller than the prev then add this to final ans.
         5. Otherwise subtract this integer.


Leetcode : https://leetcode.com/problems/roman-to-integer/

CodeStudio : https://www.codingninjas.com/studio/problems/roman-numeral-to-integer_981308?leftPanelTabValue=PROBLEM