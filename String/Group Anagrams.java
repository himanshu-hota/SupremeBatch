// Method 1 

	public static ArrayList<ArrayList<String>> groupAnagramsTogether(ArrayList<String> strs) {
		// Write your code here.

        // if string is null then there is no possible solution
		if(strs == null){
			return null;
		}

        // map to store values 
		HashMap<String,ArrayList<String>> map = new HashMap<>();

        // iterate the string list
		for(String str : strs){
            
            // convert string to character array
			char ch[] = str.toCharArray();

            // sort the character array to make it possible to convert it into lexicographical order
			Arrays.sort(ch);

            // get strting from character array
			String key = String.valueOf(ch);

            // if map doesnt has this key then create it
			if(!map.containsKey(key)){
				map.put(key,new ArrayList<>());
			}   
            // if current string is an anagram then it should be added to to the list of current anagram
            // if current string is a valid anagram the add it to the list of anagram of current string
			// yaha galti karoge -- Is code ko upar wale if k else me mat dalna nahi to gadbad hogi.
			map.get(key).add(str);
		}

        // return the list of groups of anagram
		return new ArrayList<>(map.values());
	}

Special Note : Which gadbad ? --> Agar else me dal diya to key wala string kabhi add hi nahi hoga final answer me. to isko solve karne k liye aise bhi kar sakte ho ki initially jab pahli bar blank list add karo to wahi pe str ko list me dal do.

// Method 2 

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            char ch[] = str.toCharArray();
            Arrays.sort(ch);

            String key = String.valueOf(ch);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }else{
                map.get(key).add(str);
            }
            
            
        }


        return new ArrayList<>(map.values());
    }
}

// Method 3

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for(String str : strs){
            char ch[] = str.toCharArray();
            Arrays.sort(ch);

            String key = String.valueOf(ch);

            // map.getOrDefault(key,new ArrayList<>()).add(str); ye galat hai
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);


        }

        return new ArrayList<>(map.values());
    }
}

Special Note : 1. map.getOrDefault , map ko modify nahi karta ye bas default value return kar deta hai(it works only as a getter method). jabki computeIfAbsent map ko modify bhi karta hai(it can also work as a setter method).
			     

LeetCode :- https://leetcode.com/problems/group-anagrams/description/

CodeStudio :- https://www.codingninjas.com/codestudio/problems/group-anagrams-together_985354?leftPanelTab=1