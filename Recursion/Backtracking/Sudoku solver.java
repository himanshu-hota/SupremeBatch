class Solution {
    public void solveSudoku(char[][] board) {
       boolean ans = solve(board,board[0].length);
    }

    static boolean solve(char[][] board,int n){
        for(int i = 0; i< n;i++){
            for(int j =0; j<n;j++){
                // check if current cell is empty
                if(board[i][j] == '.'){
                    // try to fill cells with value 1-9
                    for(char value = '1';value<='9';value++){
                        if(isSafe(board,value,i,j)){
                            // fill the cell
                            board[i][j] = value; 
                            // recursive call
                            boolean nextSol = solve(board,n); 
                            // if next solution is possible then
                            if(nextSol == true){
                                 return true;
                            }else{
                                //otherwise backtrack
                                  board[i][j] = '.'; 
                            }
                        }
                    }
                    //if we could not get any solution by putting 1-9 
                    //then it means there is fault in placing previous element
                    // yaha galti karoge -- isko likhna bhul jaoge
                    return false;
                }
            }
        }

        // all cells filled 
        return true;
    }

    static boolean isSafe(char board[][],char value,int curr_Row,int curr_Col){
        
        for(int i = 0; i<board[0].length;i++ ){
            // col check   
            if(board[curr_Row][i] == value){
                return false;
            }

            // col check
            if(board[i][curr_Col] == value){
                return false;
            }

            // 3*3 check
            if(board[3*(curr_Row/3)+(i/3)][3*(curr_Col/3)+(i%3)] == value){
                return false;
            }
        }

        // current value is not present in current row / col and 3*3 matrix
        return true;
    }
}


Notes : 1. In the for loop we are trying to put each value from 1 --> 9.
        2. Each time we try to put any value if we were able to put any value then we make recursive call for rest of the board, if we got true then there is  a possible solution by putting the current value on this cell so return true for further filling the board.
        3. If we got false then we need to backtrack, we previously put any value that shouldn't be there.
        4. When we come out of loop we immediately see a 'return false', this indicates that we weren't able to put any value from 1 --> 9 which means that there is something wrong value on any previous cell.


Leetcode :- https://leetcode.com/problems/sudoku-solver/description/