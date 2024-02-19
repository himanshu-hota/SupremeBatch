// Method 1

class Solution {

    public void solve(StringBuilder str,int i , List<String> ans){
        if(i >= str.length()){
            ans.add(str.toString());
            return;
        }

        for(int idx = i; idx < str.length(); idx++){
            swap(str,i,idx);
            solve(str,i+1,ans);
            swap(str,i,idx);
        }
    }

    public void swap(StringBuilder str, int i , int j){
        char temp = str.charAt(i);
        str.setCharAt(i,str.charAt(j));
        str.setCharAt(j,temp);
    }

    public String getPermutation(int n, int k) {

        StringBuilder str = new StringBuilder();
        for(int i = 1; i <= n; i++) str.append((char)('0' + i));

        List<String> ans = new ArrayList<String>();
        solve(str,0,ans);

        Collections.sort(ans); // why sort ? --> to get in lexicographical order
        return ans.get(k-1);
    }
}

// Method 2

class Solution {
    public String getPermutation(int n, int k) {
        
        int fact = 1;
        ArrayList<Integer> numbers = new ArrayList<>();

        // jo bhi n diya hai us se 1 kam size ka factorial nikalo, is size k block banenge.
        for(int i = 1; i< n ; i++){
          fact = fact*i;
          numbers.add(i);
        }
        
        // nth number ko bhi add karo.
        numbers.add(n);
        // k ko index ki tarah treat karenge isliye -1 kar do
        k = k-1;
        // block size nikalo
        int block = fact;

        String ans = "";

        while(true){
          
          // correct element pick karo.
          ans = ans + (numbers.get(k/block));

          // used number ko nikalo 
          numbers.remove(k/block);

          // agar aur koi element nahi bacha hai to break kar do.
          if(numbers.size() == 0) break;

          // is block me kon sa permutation chahiye wo bhi update karo.
          k = k % block;

          // remaining elements k hisab se block k size ko update karo
          block = block/numbers.size();

          
        }

        return ans;
    }
}

Notes : 1. Jo bhi 'n' diya hai us se ek kam size k, (n-1)! block banenge, kitne bar banenge ? n bar banenge.

        n = 4 then n-1 => 3! , ==> 6 size k block n bar yani k 4 bar banenge.

        n = 4  , k = 17 --> (17-1) ---> 16th permutation ====>

        0th    1 + [2,3,4]  | --> 0th to 5th
        1st    2 + [1,3,4]  | --> 6th to 11th
        2nd    3 + [1,2,4]  | --> 12th to 17th
        3rd    4 + [1,2,3]  | --> 18th to 23th

        Ab jo bhi k dya diya hai yani wo wala permutation kis range me hai wo dekho.
        kaise dekhenge ? k/block kar k ==> 16/6 ==> 2 ==> 2nd row pakdo yani ki 12th --> 17th wala.
        isme se ek number pick kar lo yahi pahla number hoga jo ki 3 hai
        Final Ans = 3 _ _ _
        Since 3 ko use kar chuke hai to isko hata do [1,2,4].
        Ab k ko bhi update kar do. kaise karenge? k%block 16%6 ==> 4, 4th permutation chahiye 12th --> 17th me se
        Ab block size ko update kar do. kaise karenge? block/total_available_digits ==> 6/3 ==> 2

        Jab bhi koi digit na bache to break kar do.
        
        


LeetCode : https://leetcode.com/problems/permutation-sequence/description/