
class Solution {

    
    void reverse(ArrayList<Integer> arr,int start ,int end){
        if(start> end) return;
        int temp = 0;
        while(start <= end){
            temp = arr.get(start);
            arr.set(start,arr.get(end));
            arr.set(end,temp);;
            
            start++;
            end--;
        }
    }

    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        
        int start = 0;
        // get the correct index of first k group.
        int end = k-1;
        
        while(end < n){
            reverse(arr,start,end);
            start = end+1;
            end +=k;
        }
        
        // handle the last k group
        
        // get how many elements are left to be reversed
        int last = n % k;
        
        // get the correct indices to reverse.
        start = n-last ;
        end = n-1;
        // reverse the last k group.
        reverse(arr,start,end);
        
        
    }
}

GFG :- https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1
