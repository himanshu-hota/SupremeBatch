// Method 1

        // Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {

    public static void mergeSort(int arr[],int start, int end , int temp[]){
        if(start >= end) return ;

        int mid = start + (end - start)/2;

        mergeSort(arr,start,mid,temp);
        System.out.println();
        mergeSort(arr,mid+1,end,temp);
        merge(arr,start,mid,end,temp);

    }

    public static void merge(int arr[],int start,int mid , int end , int temp[]){
        int i = start;
        int j = mid+1;
        int k = start;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid) temp[k++] = arr[i++];
        while(j <= end) temp[k++] = arr[j++];

        while(start <= end) arr[start] = temp[start++];
    }

    public static void main(String[] args) {
        // Write your code here
        int arr[] = {5,4,3,5,498,49561,981,981,9898,4};

        for(int x : arr) System.out.print(x + ", ");
        mergeSort(arr,0,arr.length-1,new int[arr.length]);
        for(int x : arr) System.out.print(x + ", ");
        

    }
}

// Method 2

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {
    public static void main(String[] args) {
        // Write your code here
        int arr[] = {9,5,98,1,981,98,2,3};
        mergeSort(arr);
        for(int i : arr) System.out.print(i +",");
    }

    static void mergeSort(int arr[]){
        if(arr.length <= 1){
            return;
        }

        int mid = arr.length/2;
        // Temporary arrays to hold data
        int left[] = new int[mid];
        int right[] = new int[arr.length-mid];

        //populate temp arrays
        //left
        for(int i = 0; i< mid;i++) {
            left[i] = arr[i];
        } 
        //right
        for(int i = mid; i< arr.length;i++){
             right[i-mid] = arr[i];
        }

        // Recursive call for left sub array
        mergeSort(left);
        // Recursive call for right sub array
        mergeSort(right);

        // merge the sorted arrays
        merge(left,right,arr);

    }

    static void merge(int left[],int right[],int arr[]){

        int leftLength = left.length; // length of left array
        int rightLength = right.length; // length of right array
        int i=0,j=0,mainIndex=0;

        //compare and place right item in its place in main array
        while(i<leftLength && j<rightLength){
            if(left[i]<=right[j]){ // if element in left array is greater than pick form here
                arr[mainIndex++] = left[i++];
            }else{ // else pick from right array
                arr[mainIndex++] = right[j++];
            }
        }

        //copy rest elements of left array if any left
        while(i < leftLength){
            arr[mainIndex++] = left[i++];
        } 
        //copy rest elements of right array if any left
        while(j < rightLength) {
            arr[mainIndex++] = right[j++];
        }
    }
}




Time complexity :- O(nlogn)
Space complexity :- O(n)