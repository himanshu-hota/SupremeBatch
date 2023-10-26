// Method 1 =>

class Solution {
    public int findDuplicate(int[] nums) {
        
        // length of the array
        int n = nums.length;

        // traverse the array
        for(int i = 0; i< n ; i++){
            // grab the index
            int index = Math.abs(nums[i]);

            // if this index has already been visited then this index valus is the ans.
            if(nums[index] < 0){
                return index;
            }else{ // otherwise mark it as visited by multiplying it with -1.
                nums[index] *= -1;
            }
        }

        // if we reach till here then no answer is found.
        return -1;
    }
}

Steps :- 1. Loop from index 0 to n.
         2. Grab an index
            check if its value is negative then it is already visited.
            otherwise mark it is visited by multiplying it by 1.



// Method 2 =>
    

class Solution {
    public int findDuplicate(int[] nums) {
      List<Integer> arr = new ArrayList<Integer>();
	        int i = 0,temp = 0, n= nums.length;

            // sort all the elements (put element at their respective index)
	        while(i < nums.length){
                //get the value that should be index of the element
	            int index = nums[i]-1;

            // if element is not at their respective index than swap it 
	            if(nums[i] != nums[index]){
	                 temp  = nums[i];
	                nums[i] = nums[index];
	                nums[index] = temp;
	            }else{
                    // if element is in their correct index their move forward the pointer
	                ++i;
	            }
	        }

        // check for duplicacy
        for(i = 0; i< n ; i++){
            // the index which doesn't hold index+1 value hass the duplicate element.
            if(nums[i] != i+1) return nums[i];
        }

        return -1;
    }
}

Steps:- 1. Place each valus at its correct position ( use find missing element's logic).
        2. Whichever index doesn't hold the i+1 value contains the ans.

Leetcode :- https://leetcode.com/problems/find-the-duplicate-number/description/
    