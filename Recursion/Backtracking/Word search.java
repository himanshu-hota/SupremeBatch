class Solution {

    // Helper method to perform DFS search for the word
    public boolean solve(char board[][], int i, int j, String word, int k, int dx[], int dy[]) {
        // If the entire word is found, return true
        if (k == word.length()) return true;
        
        // Check if the current position is out of bounds or if the character doesn't match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }

        // Temporarily mark the current position as visited
        char temp = board[i][j];
        board[i][j] = '.';

        // Explore all four directions
        for (int idx = 0; idx < 4; idx++) {
            int ni = i + dx[idx];
            int nj = j + dy[idx];
            
            // Recursively check the next position
            if (solve(board, ni, nj, word, k + 1, dx, dy)) {
                return true;
            }
        }

        // Backtrack by restoring the original character at the current position
        board[i][j] = temp;

        return false;
    }

    // Main method to check if the word exists on the board
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        // Direction vectors for exploring adjacent cells
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};

        // Iterate through each cell on the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the first character of the word matches the current cell, initiate DFS search
                if (board[i][j] == word.charAt(0) && solve(board, i, j, word, 0, dx, dy)) {
                    return true; // If word is found, return true
                }
            }
        }

        // If the entire board is searched and the word is not found, return false
        return false;
    }
}


Note : 1. Go to each cell and check if found the first char of the given string.
       2. If found the first char of the strig on any cell then start recursive call from this cell on all the possible  directions(right,down,left,up). 
       3. If any possible ans is found then return true otherwise keep searching till last cell.


LeetCode : https://leetcode.com/problems/word-search/description/