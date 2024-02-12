// method 1 

public class Solution 
{
    public static String removeDuplicates(String str) 
    {
        int map[] = new int[26];
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - 'a';
            if(map[index] == 0){
                ans.append(str.charAt(i));
            }
            map[index] = 1;
        }

        

        return ans.toString();
    }
}


Note : 1. Har ek character pe jao and check karo ki kya ye pahle add ho chuka hai? agar ha to mat add karo ans me nahi to add kar do ans me.
       2. Kaise check karenge ? --> a. index generate karo us character ka map ke liye.
                                    b. agar is index pe 0 hai to ye character pahli bar aaya hai, aur agar 1 hai to pahle bhi aa chuka hai.

// method 2 

public static String removeDuplicates(String str) {
        // Create a HashSet to store unique characters
        HashSet<Character> set = new HashSet<>();
        
        // Create a StringBuilder to store the result without duplicates
        StringBuilder s = new StringBuilder();

        // Iterate through each character in the input string
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If the character is not in the set, add it to both the set and the StringBuilder
            if (!set.contains(ch)) {
                set.add(ch);
                s.append(ch);
            }
        }

        // Return the result as a string without duplicate characters
        return s.toString();
}

LeetCode : https://www.codingninjas.com/studio/problems/remove-duplicates-from-string_630470?leftPanelTabValue=PROBLEM