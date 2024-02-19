// Method 1

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();  // List to store the generated parentheses combinations
        StringBuilder output = new StringBuilder();  // StringBuilder to build the parentheses combinations
        int open = n;  // Number of remaining opening parentheses
        int close = n;  // Number of remaining closing parentheses
        solve(ans, open, close, output);  // Call the solve() function to generate parentheses combinations
        return ans;  // Return the generated combinations
    }

    static void solve(List<String> ans, int open, int close, StringBuilder output) {
        if (open == 0 && close == 0) {  // Base case: no remaining opening or closing parentheses
            ans.add(output.toString());  // Add the generated combination to the list
            return;  // Return from the function
        }

        if (open > 0) {  // If there are remaining opening parentheses
            output.append("(");  // Add an opening parenthesis to the current combination
            solve(ans, open - 1, close, output);  // Recursive call with one opening parenthesis used
            output.deleteCharAt(output.length() - 1);  // Backtrack: remove the added opening parenthesis
        }

        if (close > open) {  // If there are more closing parentheses available than opening parentheses
            output.append(")");  // Add a closing parenthesis to the current combination
            solve(ans, open, close - 1, output);  // Recursive call with one closing parenthesis used
            output.deleteCharAt(output.length() - 1);  // Backtrack: remove the added closing parenthesis
        }
    }
}


// Method 2

class Solution {

    public void solve(List<String> ans, String str, int open,int close){
        if(open == 0 && close == 0){
            ans.add(str);
            return;
        }

        // open
        if(open > 0)
        solve(ans,str + "(",open-1,close);
        
        // close
        if(close > open)
        solve(ans,str + ")",open,close-1);
        
        
    }

    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();

        solve(ans,"",n,n);

        return ans;

    }
}

Leetcode :- https://leetcod e.com/problems/generate-parentheses