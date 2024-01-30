ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        
        // pointers to traverse the arrays.
        int i = 0, j = 0, k = 0;
        // final ans arraylist/array
        ArrayList<Integer> ans = new ArrayList<>();
        
        // if any of the aray is is empty then there is no solution possible
        if(n1 == 0 || n2 == 0 || n3 == 0) return ans;
        
        // traverse the array
        while(i < n1 && j < n2 && k < n3){
            if((A[i] == B[j]) && (B[j] == C[k])){
                // dont add the this value if it is already in the ans 
                if(!(ans.size() > 0 && ans.get(ans.size() -1) == A[i])){
                    ans.add(A[i]);    
                }
                
                // move each pointer 1 step futher as current element has been processed.
                i++;
                j++;
                k++;
            }else if(A[i] < B[j] || A[i] < C[k]){ // if A is the smallest then move A's pointer 1 step ahead.
                i++;
            }else if(B[j] < C[k] || B[j] < A[i]){ // if B is the smallest then move B's pointer 1 step ahead.
                j++;
            }else if(C[k] < A[i] || C[k] < B[j]){ // if C is the smallest then move C's pointer 1 step ahead.
                k++;
            }
            
        }
        
        // finally return the ans.
        return ans;
    }

    GFG :- https://practice.geeksforgeeks.org/problems/common-elements1132/1

    Steps :- 

    1. If any of the Array is empty then return an empty ans.
    2. If any common element is found then check if it is already in the ans or not , if not then add the ans array.
       and move each pointer 1 step ahead.
    3. If A has the smalles element then move A's pointer 1 step ahead to find common element.
    4. If B has the smalles element then move B's pointer 1 step ahead to find common element.
    5. If C has the smalles element then move C's pointer 1 step ahead to find common element.
    6. Finally return ans.