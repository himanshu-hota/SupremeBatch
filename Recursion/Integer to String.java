public class Solution {
 private final String ones[]= {"","One", "Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        private final String tens[]= {"","", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        private final String special[] ={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return solve(num); 
    }
    
    private String solve(int num) {
  StringBuilder result = new StringBuilder();
        if (num < 10) result.append(ones[num]);
        else if (num < 20) result.append(special[num -10]);
        else if (num < 100) result.append(tens[num/10]+" "+(solve(num % 10)));
        else if (num < 1000) result.append(solve(num/100)+" Hundred "+(solve(num % 100)));
        else if (num < 1000000) result.append(solve(num/1000)+" Thousand "+(solve(num % 1000)));
        else if (num < 1000000000) result.append(solve(num/1000000)+" Million "+(solve(num % 1000000)));
        else result.append(solve(num/1000000000)+" Billion "+solve(num % 1000000000));
        return result.toString().trim();
    }
}

Trick : 1. 10 k bad 9 '0' maximum lagane hai -> 10
                                             20
                                             100
                                             1000
                                             1000000
                                             1000000000

        2. Har level me maximum 2 recursive call jayegi.
        3. " " , "Hundred" , "Thousand" , "Million" , "Billion".
        4. 1000 se do function call start ho jaega.
        5. return sirf last me hoga.
        6. har if else check me ans me append hoga bhaisahab.

LeetCode :- https://leetcode.com/problems/integer-to-english-words/description/