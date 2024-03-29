    public static List<Integer> twoPtr(int arr[],int k , int x){
        int start = 0 ; 
        int end = arr.length -1;
        List<Integer> ans = new ArrayList<>();
        while(end-start >= k){
            if(x - arr[start] > arr[end] - x){
                start++;
            }else{
                end--;
            }
        }

        for(int i = start ; i <= end; i++){
            ans.add(arr[i]);
        }

        return ans;

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = bs_method(arr,k,x);

        return ans;
    }


    Note :- 1. we are maintaining two pointers - one from start , one from end.
            2. we loop till the search space become size of k.
            3. we check if difference between x and start element is greater than 
               difference between x and end element then we we move the start pointer toward x
               else we move the end pointer toward x.
            4. at the end we are returning the elements in the derived range.


    LeetCode : https://leetcode.com/problems/find-k-closest-elements/