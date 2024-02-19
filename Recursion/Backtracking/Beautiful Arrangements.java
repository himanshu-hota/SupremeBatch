class Solution {


    public int solve(int arr[],int num){
        if(num >= arr.length) return 1;

        int ans = 0;

        for(int i = 1; i < arr.length; i++){

            if(arr[i] == 0 && (num%i == 0 || i%num == 0)){
                arr[i] = num;
                ans += solve(arr,num+1);
                arr[i] = 0;
            }
        }

        return ans;
    }

    public int countArrangement(int n) {

        int arr[] = new int[n+1];

        return solve(arr,1);

    }
}

Thought Process : We will pick a number and try to put this number in the array , on the index which satisfies the condition given in the question.

Steps : 1. Create a array of size (n+1) , why n+1 ? --> beacause we want we want to stroe the nth num also.
        2. We wil start picking the number from 1 => n.
        3. Pick a number lets say 1.
        4. Try to put this number in the index which satisfies the given condition.
        5. Now make recursive call for the rest of the numbers and indices.


Keep in mind : 1. We are picking a number and traversing through the whole every time.          
               2. We put the number only when the cell is empty and satisfies the condition. 

LeetCode :- https://leetcode.com/problems/beautiful-arrangement/description/