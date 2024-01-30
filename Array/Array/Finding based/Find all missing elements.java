    public List<Integer> findDisappearedNumbers(int[] nums) {
        	   List<Integer> arr = new ArrayList<Integer>();
	        int i = 0,temp = 0;

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

            // check if any element is not at their respective index
	        for(int j = 0 ; j < nums.length ; j++){
	        	int k = j;
	            if(nums[j] != k+1){
	                arr.add(j+1);
	                
	            }
	        }
	        
    return arr;
    }

	LeetCode :- https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

	Steps :- 1. Pick one index and check if it has the correct value (i+1 value).
			    if yes then go ahead.
				if no then place it in its correct position.
			 2. Now check which index doesn't has i+1 value, that is the missing element.