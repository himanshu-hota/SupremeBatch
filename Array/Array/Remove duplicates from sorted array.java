class Solution {
    public int removeDuplicates(int[] arr) {
       
        // we have to put unique elements on this pointer ans so on.
		int count = 0;	
        // start from 0th index.
		int start =0;
        int n = arr.length;

        while(start < n){
            
            // this while loop will take us to the last occurence of the repeating element. 
            while(start+1 < n && (arr[start] == arr[start + 1])) start++;
            // Note : now start is pointing at last index of repeating element. 

            // check if we are still in range , if yes then put element at count index.
            if(start < n && count < n){
                arr[count++] = arr[start];
            }

            start++;
			
		}



		return count;
    }
}

Steps: 1. The idea is to maintain a count/index variable while will hold the unique values , this both the  index at which we have to put unique values as well as count of total unique elements.
       2. If we find any duplicate element then go to its last occurence and put it in the count/index index.
       3. if you put any elemenet then increase the count/index.




// What is this loop doing ? "while(start+1 < n && (arr[start] == arr[start + 1])) start++;"
// for ex. in [1,1,1,1] if we start from start = 0 then after this while loop start will be standing on the 3rd index.
            

LeetCode : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
CodeStudio : https://www.codingninjas.com/studio/problems/remove-duplicates-from-sorted-array_1102307?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION