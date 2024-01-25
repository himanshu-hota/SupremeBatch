	public static void findPivot(int arr[]) {
		int start = 0 ; 
		int end = arr.length -1;
		int mid = start + (end - start) /2;
		int pivot = -1;
		
		while(start <= end) {
			
			if(start == end) {
				pivot = start;
				break;
			}
			
			if(mid+1 < end  && arr[mid]> arr[mid+1]) {
				pivot = mid;
				break;
			}else if(mid-1 >= start && arr[mid-1] > arr[mid]) {
				pivot = mid-1;
				break;
			}else if(arr[start] > arr[mid]) {
				end = mid-1;
			}else {
				start = mid+1;
			}
			
			mid = start + (end - start) / 2;
		}
		
		if(pivot>=0) {
			System.out.println("pivot index : " + pivot);
		}else {
			System.out.println("pivot not found!!!");
		}
		
	}

    Note:- 1. if the element at the middle index is the pivot then it should be greater than the next elment.
           2. if the element just before the middle element is the pivot than it should be greater than the middle element.
           3. if the element just after the middle element is the pivot then it should be greater than the middle element.
           4. if the element at the starting index is greater than the middle element then we dont need the right part of the array as pivot is present in the left part.
           5. if the element at the starting index is smaller than the middle element then the pivot is on the right part of the array. 

    special note:- if the starting element is smaller than the middle element that simply means that array is sorted till middle element , 
                   clearly means that we dont need the left part of the array.





RECURSIVE WAY:-


    public static int findPivot(int arr[],int low , int high ){
  
       // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;
 
        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
        


    }

        public static int BinarySearch(int arr[] , int low , int high , int key){

                if (high < low)
            return -1;
 
        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return BinarySearch(arr, (mid + 1), high, key);
        return BinarySearch(arr, low, (mid - 1), key);

    }
    

    public int search(int[] arr, int key) {
        int n = arr.length;
     int pivot = findPivot(arr, 0, n - 1);
 
        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return BinarySearch(arr, 0, n - 1, key);
 
        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return BinarySearch(arr, 0, pivot - 1, key);
        return BinarySearch(arr, pivot + 1, n - 1, key);
    }


// LeetCode Method

class Solution {

    public int findPivot(int arr[]){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            // We say mid pivot if it is greater than next.
            if(mid+1 <=end && arr[mid] > arr[mid+1]) return mid;
            // We say mid-1 pivot if mid-1 is greater than mid.
            else if(mid-1 >= start && arr[mid] < arr[mid-1]) return mid-1;
            
            // if arr[start] < arr[mid] then array is sorted from start -> mid
            // we wont find the pivot in this range so skip from start -> mid
            if(arr[start] < arr[mid]) start = mid+1;
            else end = mid-1;
        }

        return -1;
    }

    public int bs(int arr[],int start,int end,int x){
        
        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == x) return mid;
            else if(arr[mid] < x) start = mid+1;
            else end = mid-1;
        }

        return -1;
    }

    public int search(int[] arr, int target) {
        
        int start =0;
        int end = arr.length -1;
        int k = findPivot(arr);
        
        // if no pivot found then array is not rotated at all.
        if( k == -1) return bs(arr,0,end,target);   

        // get the pivot element.
        int pivot = arr[k];

        // check if pivot is the target itself.
        if(pivot == target) return k;
        // check if target is smaller than first element then it can no be found from 0 => k
        else if(target < arr[0]) return bs(arr,k+1,end,target);
        // if target is greater than first element than it must be present from 0 => k
        else return bs(arr,start,k,target);

    }
}


GFG : https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

CodeStudio : https://www.codingninjas.com/studio/problems/search-in-rotated-sorted-array_1082554?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

LeetCode : https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1095314231/