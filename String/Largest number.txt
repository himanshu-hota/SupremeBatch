    public String largestNumber(int[] nums) {
        // string array to store all integers as individual string
        String[] s = new String[nums.length];         

        // add all integers as individual string 
        for(int i=0; i<nums.length; i++)  s[i] = String.valueOf(nums[i]);

        // sort the string array in with custom comparator 
        Arrays.sort(s, (a,b) -> (b + a).compareTo(a + b));

        // if the largest number is 0 then there will be no value greater than 0 so return "0" other wise concat every entry in string array to form answer
        return s[0].equals("0") ? "0" : String.join("",s);

    }


Note :- here the custom comparator is sorting string in lexicographical order but if we have "3" and "30" then we will say 3 is greter not 30

    int arr[] = {3,30,34,5,9};

    1. Here if we sort it then it will be 
        
        sorted = [9, 5, 34, 3, 30, ];

    2. 3 comes before 30 because it sorts like this: - 

        String a = "3";
        String b = "30";

        1. b+a - a+b =>  "3" + "30" - "30" + "3" => "330" - "303" => true
            
            so it implies that string a is greater which is 3 thats why after sorting we have 3 before and 30 after it.
        
        one more example :-
 
        String a = "34";
        String b = "3";

        1. b+a - a+b =>  "34" + "3" - "3" + "34" => "343" - "334" => true

            so it implies that string a is greater which is 34 thats why after sorting we have 34 before and 3 after it.

            if we reverse :- 

        String a = "3";
        String b = "34";

        1. b+a - a+b =>  "3" + "34" - "34" + "3" => "334" - "343" => false


Special Note : 1. Here use of .equals when comparing two 'String' values. 
               
In Java, when comparing strings, you should use the equals method rather than the == operator. The == operator checks for reference equality (whether the two references point to the same object in memory), while the equals method checks for content equality (whether the characters in the two strings are the same).

In the context of your code:

return strs[0].equals("0") ? "0" : String.join("",strs);

This line checks if the first element of the strs array is equal to the string "0". It uses the equals method to compare the content of the strings.

On the other hand, if you use == like this:

return strs[0] == "0" ? "0" : String.join("",strs);

It checks for reference equality, which might not work as expected for string comparison. Strings in Java are objects, and using == will check if the two references point to the exact same object, not if the content of the strings is the same. In some cases, it might work due to string interning, but it's not guaranteed and can lead to unexpected behavior.

In general, when comparing strings for equality in Java, it's safer to use the equals method.

Leetcode :- https://leetcode.com/problems/largest-number/