


   ArrayList<Integer> findSum(int a[], int b[]) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = a.length-1;
        int j = b.length-1;
        int k = ans.size() - 1;
        int carry = 0 ;
        int sum = 0 ;
        int digit = 0;
        
        // Calculate sum of single digits and store it
        while(i >= 0 && j >= 0){
            sum = a[i] + b[j] + carry;
            digit = sum % 10;
            carry = sum / 10;
            ans.add(digit);
            
            i--;
            j--;
        }
        
        // if number A has more digits than store it as it is
        while(i >= 0){
            sum = a[i] + 0 + carry;
            digit = sum % 10;
            carry = sum / 10;
            ans.add(digit);
            
            i--;
        }
        
        // if number B has more digits than store it as it is
         while(j >= 0){
            sum =  0 + b[j] + carry;
            digit = sum % 10;
            carry = sum / 10;
            ans.add(digit);
            
            j--;
        }
        
        // Add the carry if it is there
        if(carry !=0){
            ans.add(carry);
        }
        
        
        // remove all -s from the begining
        // while(ans.get(k) == 0){
        //     ans.remove(k);
        //     k--;
        // }
        
           Collections.reverse(ans);
           
           return ans;
        
    }

Steps:- 1. Add each digit from end of the both arrays.
        2. If num1 has more count of digits then add the remaining digits of num1 to ans.
        3. If num2 has more count of digits then add the remaining digits of num2 to ans.

GFG :- https://practice.geeksforgeeks.org/problems/sum-of-two-numbers-represented-as-arrays3110/1