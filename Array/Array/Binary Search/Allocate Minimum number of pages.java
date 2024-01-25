
class Solution{
    
    public static boolean isPossible(int books[],int maxStudents,int maxPages){
        
        int n = books.length;
        int students = 1;
        int pageSum = 0;
        
        
        // try distributing books here
        for(int i = 0; i<n ;i++){
            
            // if any single page has more than allowed pages then there is no way to distribute books to M students.
            if(books[i] > maxPages) return false;
            
            // adding current book exceeds the max allowed pages then allocate books till now excludint current book as it exceeds the limit.
            if( pageSum + books[i] > maxPages){
                // allocate books excluding current book to one student.
                students++;
                // allocate new books from now on including this book.
                pageSum = books[i];
                
                // if books are remaining and no students is left to allocate book then this is not a valid combination.
                if(students > maxStudents){
                    return false;
                }
                
            }else{ // include current book.
                pageSum += books[i];
            }
        }
        
        // if each book got allocated then this is a valid combination of distribution.
        return true;
    }
    
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M){
        
        if(M > N) return -1;
        
        int start = 0;
        int end = Arrays.stream(A).sum();        
        
        int ans = 0;
        
        while(start <= end){
            
            int mid = (start + (end - start)/2);
            // try to allocate at max mid number of pages to each student, if it is possible to do so then it is a valid answer 
            if(isPossible(A,M,mid)){
                ans = mid;
                end = mid-1; // now try to minimize the number of pages as the question says "Diff of pages should be minimum"
            }else{
                start = mid+1; // if not poosible to allocate at max mid pages then try higher number of pages
            }
        }

        return ans;
    }
}

Steps: 1. Get sum of all pages in each book.  
       2. Get the middle value of total pages and try from here if you can allocate this amount of pages.
       3. Start the loop to allocate books to M students.
       4. Try if you can allocate mid amount of pages to M students.
       5. Try adding each book one by one.
       6. If any single book has greater count of pages than max allowed pages then no distribution is possible.
       7. If at any point of time we exceed the max page limit then allocate books excluding current book because by inlcuding this book we exceed the limit so if we exclude this book then we can allocate this much amount of pages(books) to one student.
       8. If any point of time all students were allocated books, and there are still remaining books then, in this case also distribution is not possible.  
 

GFG :- https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

Note :- Aggresive cows wale problem me ans(diff between cow's stall) ko maximize kar rahe the, isiliye if wale condition me start = mid + 1 kar rahe the.
        Is wale question me ans(difference in pages) ko minimize kar rahe hai, isiliye if wale condiition me end = mid - 1 kar rahe hain. 


VVIMP Note :- Code of this question and logic of this question is exactly same as "Painter's partition problem", We can use exactly use same code to solve that question.

Painter's partition :- https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557