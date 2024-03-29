// Method 1

class Solution {

    public boolean isSafe(char board[][],int row,int col){

        int i = row;
        int j = col;

        // upLeft check
        while( i>=0 && j>= 0){
            if(board[i][j] == 'Q') return false;
            i--;
            j--;
        }

        // bottomLeft check
        i = row;
        j = col;
        
        while( i<board.length && j>= 0){
            if(board[i][j] == 'Q') return false;
            i++;
            j--;
        }

        // row check
        i = row;
        j = col;
        while( j>=0){
            if(board[i][j] == 'Q') return false;
            j--;
        }


        return true;
    }

    public void storeAns(char board[][],List<List<String>> ans){
        
        List<String> curr = new ArrayList<>();

        // take each row and convert it into string and store int in a list.
        for(char row[] : board){
            String rowString = new String(row);
            curr.add(rowString);
        }

        // finaly store the ans
        ans.add(curr);
    }

    public void solve(List<List<String>> ans,char board[][],int col){
        // base case
        if(col >= board.length){
            storeAns(board,ans);
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                solve(ans,board,col+1);
                board[row][col] = '.';
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];

        // intial board values
        for(char row[] : board) Arrays.fill(row,'.');

        // solve using recursion
        solve(ans,board,0);

        return ans;
    }
}


// Method 2

class Solution {

    public boolean isSafe(char board[][],int row,int col,Map<Integer,Boolean> rowCheck,Map<Integer,Boolean> bottomLeftCheck,Map<Integer,Boolean> upperLeftCheck){

        // upLeft check
        if(upperLeftCheck.getOrDefault(row-col,false)) return false;

        // bottomLeft check
        if(bottomLeftCheck.getOrDefault(row+col,false)) return false;

        // row check
        if(rowCheck.getOrDefault(row,false)) return false;


        return true;
    }

    public void storeAns(char board[][],List<List<String>> ans){
        
        List<String> curr = new ArrayList<>();

        // take each row and convert it into string and store int in a list.
        for(char row[] : board){
            String rowString = new String(row);
            curr.add(rowString);
        }

        // finaly store the ans
        ans.add(curr);
    }

    public void solve(List<List<String>> ans,char board[][],int col,Map<Integer,Boolean> rowCheck,Map<Integer,Boolean> bottomLeftCheck,Map<Integer,Boolean> upperLeftCheck){
        // base case
        if(col >= board.length){
            storeAns(board,ans);
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(board,row,col,rowCheck,bottomLeftCheck,upperLeftCheck)){
                board[row][col] = 'Q';
                bottomLeftCheck.put(row+col,true);
                upperLeftCheck.put(row-col,true);
                rowCheck.put(row,true);

                solve(ans,board,col+1,rowCheck,bottomLeftCheck,upperLeftCheck);

                bottomLeftCheck.put(row+col,false);
                upperLeftCheck.put(row-col,false);
                rowCheck.put(row,false);
                board[row][col] = '.';
            }
        }
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char board[][] = new char[n][n];

        // intial board values
        for(char row[] : board) Arrays.fill(row,'.');

        // maps
        Map<Integer,Boolean> row = new HashMap<>();
        Map<Integer,Boolean> bottomLeft = new HashMap<>();
        Map<Integer,Boolean> upperLeft = new HashMap<>();

        // solve using recursion
        solve(ans,board,0,row,bottomLeft,upperLeft);

        return ans;
    }
}


Notes : 1. We are placing queens on 1st column and then going on next columns one by one.
        2. But we are Iterating row wise, why ?? --> because on the first column we are trying to put 1 queen at first row and we check if we can place it or not , then we put queen on second row being on the first col and so on....
        3. When using map we put row + col for bottom left check and row-col for upper left check, why is that ? --> because when we create n*n matrix and put sum of its row index and col index on each cell, then we would find all diagonal elements on the right direction are same so we can make use of it to check for bottom left.

        same for upper left.

        One interesting thing is that we can either use row+col || col+row for bottom left particular and row-col || col-row for upper left part.
        


LeetCode :- https://leetcode.com/problems/n-queens/