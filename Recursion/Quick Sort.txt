public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 1, 3, 4, 20, 50, 50, 50, 50, 50, 5, 1, 1, 1, 1, 2, 2, 2, 50, 30};
        int n = arr.length;

        int s = 0;
        int e = n - 1;
        quickSort(arr, s, e);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    static void quickSort(int arr[],int s, int e){
        if(s>=e){
            return;
        }
        
        // Get the partition point
        int p = partition(arr,s,e);
        // Recursive call for left part from pivot
        quickSort(arr,s,p-1);
        // Recursive call for right part from pivot
        quickSort(arr,p+1,e);
    }

    static int partition(int arr[],int s, int e){
        // pick pivot element
        int pivot = arr[s]; 
        // pick pivot index
        int pivotIndex= s;

        // count number of elements smaller than pivot
        int count = 0;
        for(int i =s+1;i<=e;i++) {
            if(arr[i] <= pivot) count++;
        }

        // calculate correct position of pivot element
        int correctIndex = s + count;
        // place pivot element at its correct position
        swap(arr,correctIndex,pivotIndex);
        // update pivot index
        pivotIndex = correctIndex;

        // assign i as starting point and j as ending point
        int i = s;
        int j = e;

        // iterate till i is less than pivotIndex also j is greater than pivotIndex
        while(i< pivotIndex && j > pivotIndex){
            while(arr[i] <= pivot) i++; // go to the element which is larger than pivot if any
            while(arr[j] > pivot) j--; // go to the element which is less than pivot if any 

            // swap the elements if found such pair which are not in order
            if(i < pivotIndex && j> pivotIndex){
                swap(arr,i,j);
            }
        }

        // return pivot index as element in the pivot index is at its correct position 
        return pivotIndex;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}



// method 2

class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high){
        
        if(low >= high) return ;
        
        int p = partition(arr,low,high);
        
        quickSort(arr,low,p-1);
        quickSort(arr,p+1,high);
        
    }
   
   static int partition(int arr[], int low, int high) {
   
        int pivotIndex = high;
        int pivot = arr[pivotIndex];
        int i = low-1;
        int j = low;
        
        while( j < high){ // <= also works fine
            
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
            
            j++;
        }
        
        
        swap(arr,i+1,pivotIndex);
        
        pivotIndex = i+1;
        
        return pivotIndex;
    
   }

    
    static void swap(int arr[], int i , int j){
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

Steps : 1. Take last index as pivot index and last element as pivot element;
        2. Put i pointer just 1 step behind the given low and j pointer on low index.
        3. Iterate the array till j < high and do following
            a. if element at jth index is less than the pivot then 
                i. Move ith pointer 1 step ahead.
                ii. Swap ith element with jth.
            b. Move jth pointer 1 step ahead each time.
        4. Now the ith index (including ith) contains the elements smaller than pivot, so i+1 will be the correct new index(partition point) for the pivot.
        5. Place the pivot element at its correct index (i+1) by swapping i+1 with pivotIndex.
        6. Update the pivotIndex to i+1.
        7. Return this pivotIndex as left to pivotIndex are smaller than element at pivotIndex at right to pivotIndex are always greater than pivotIndex element.




GFG : https://practice.geeksforgeeks.org/problems/quick-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=quick-sort
