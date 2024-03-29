 public static boolean isPossible(int arr[],int n , int k , int  diff){
    
    int cows = 1; // count of current placed cows
    int pos = arr[0]; // place first cow at very first position
 
    for(int i =1 ; i< n ; i++){
        // if current difference is a possible difference then place a new cow
        if(arr[i] - pos >= diff){
            cows++; // increase count of cows
            pos = arr[i]; //place a new cow
            
            //if all desired cows are placed then return true 
            if(cows == k ){
                return true; 
            }
        }
    }
    
        // else return false because it is not a possible solution
        return false;
    }
    
    public static int solve(int n, int k, int[] stalls) {
        //sort the array at the very first of the code if it is not sorted
        Arrays.sort(stalls);
        
        int start = 0; 
        int end = stalls[stalls.length-1] - stalls[0]; // calculate max difference
        int mid = start + (end - start) /2;
        int ans = 0 ;
               
        while(start <= end){
            // if solution is possible then search for larger difference
            if(isPossible(stalls ,n , k , mid)){
                ans = mid;
                start = mid+1;
                
            }else{
                end = mid -1;
            }
            
            mid = start + ( end - start)/2;
        }
        
        return   ans;
    }

    Yaha galti karoge --> cows = 1 karna bhul jaoge.

    Steps: 1. Sort the array (VVIMP).
           2. One thing to notice here is, our range will be (0 --> maxElementOfArray - firstElementOfArray). Why is that ? because each element represents a stall, and we are asked to put cows on those stalls.
           3. Here mid will be our difference at which we will try putting cows.
           4. Loop from start --> end, and update mid accrondingly.
           5. Try to put cows at difference of mid, if it is possible to put all cows in the difference of mid then it is a possible answer so store it, and now try to maximizing the difference by putting the start pointer one step ahead of mid(simply means try putting start at difference mid+1).
           6. If its not possible to put all cows at mid difference then try minimizing the difference by putting end pointer one step behind (simply means try putting end at difference mid-1).
            


    GFG :- https://practice.geeksforgeeks.org/problems/aggressive-cows/1

    CodeStudio :- https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559?leftPanelTab=1