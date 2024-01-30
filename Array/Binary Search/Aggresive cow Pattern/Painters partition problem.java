// Logic based on this question

     public static boolean isPossible(ArrayList<Integer> arr,int n , int k, int sol){
         
         int timeSum = 0 ;
         int painters = 1;
         
         for(int i = 0 ; i < n ; i++) {
             // if current time is greater than sol then there is no possibility 
             if(arr.get(i) > sol){
                 return false;
             }
             
             //if sum till current time is greater than solution then 
             if(timeSum + arr.get(i) > sol){

                //allocate board to new painter
                 painters++;

                 //reset time
                 timeSum = arr.get(i);

                 //if current number of painter is greater than required then there is no possibility
                 if(painters > k){
                     return false;
                 }
             }else{
                // add current time to sum of time
                 timeSum += arr.get(i);
             }
             
         }
         return true;
     }


    public static int findLargestMinDistance(ArrayList<Integer> arr, int k)
    {
        //    Write your code here.
        int sum =0;
        //calculate total time
        for(Integer i : arr){
            sum += i;
        }

        int n = arr.size();
        int ans = 0;
        int start  =0;
        int end = sum;
        int mid = start + (end - start)/2;
        
        while(start <= end) {
        
        //if there is possibility of current time to be ans then
            if(isPossible(arr,n,k,mid)){
                //search for lower time 
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
            }
            
            mid = start + (end - start) /2;
        }
        
        return ans;
    }


// Logic based on "Allocates min num of pages"

public class Solution 
{   
     public static boolean isPossible(ArrayList<Integer> books,int maxStudents,int maxPages){
        
        int n = books.size();
        int students = 1;
        int pageSum = 0;
        
        
        // try distributing books here
        for(int i = 0; i<n ;i++){
            
            int book = books.get(i);
            // if any single page has more than allowed pages then there is no way to distribute books to M students.
            if(book > maxPages) return false;
            
            // adding current book exceeds the max allowed pages then allocate books till now excludint current book as it exceeds the limit.
            if( pageSum + book > maxPages){
                // allocate books excluding current book to one student.
                students++;
                // allocate new books from now on including this book.
                pageSum = book;
                
                // if books are remaining and no strudents is left to allocate book then this is not a valid combination.
                if(students > maxStudents){
                    return false;
                }
                
            }else{ // include current book.
                pageSum += book;
            }
        }
        
        // if each book got allocated then this is a valid combination of distribution.
        return true;
    }
    public static int findLargestMinDistance(ArrayList<Integer> A, int k)
    {
         int start = 0;
         int M = k;
        int end = 0;
        
        for(int x : A) end += x;        
        
        int ans = 0;
        
        while(start <= end){
            
            int mid = (start + (end - start)/2);
             
            if(isPossible(A,M,mid)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }
}


CodeStudio :- https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557

Note :- This question can be solved by exactly same code and logic of "Allocate min num of pages" question.

Link :- https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
