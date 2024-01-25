
// One way of code
 static ArrayList<Integer> factorial(int N){
        //code here
     ArrayList<Integer> result = new ArrayList<>();
        int size = 1;
        int carry =0;
        result.add(0,1);
        int val =2;
        
        while(N>=val){
            
            for(int i = size-1;i>=0;i--){
                int temp = result.get(i)*val+carry;
                result.set(i,temp%10);
                carry = temp/10;
            }
            
            while(carry!=0){
                result.add(0,carry%10);
                carry = carry/10;
                size++;
            }
            val++;
        }
        
        
        return result;
    }

    // Another way of coding


class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(1);
        // start calculating factorial from 2 => n
        for(int val = 2; val <= N ; val++){
            // calculate factorial
            int carry = 0;
            for(int i = 0; i < ans.size(); i++){
                int temp = ans.get(i) * val + carry;
                ans.set(i,temp%10);
                carry = temp/10;
            }
            
            
            // handle the carry part
            while(carry > 0){
                ans.add(carry%10);
                carry /= 10;
            }
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}

    Practice Link :- https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1 
    Video :- https://www.youtube.com/watch?v=vxPBrr5x2jk&t=2s