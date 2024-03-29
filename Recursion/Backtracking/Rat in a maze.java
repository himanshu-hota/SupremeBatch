class Solution {
    
    // Check if the current position (i, j) is safe to move to
    public static boolean isSafe(int maze[][], int i, int j, boolean visited[][]) {
        int rows = maze.length;
        int cols = maze[0].length;
        
        // Check if the position is within the maze boundaries, has a value of 1, and has not been visited
        if (((i >= 0 && i < rows) && (j >= 0 && j < cols)) && (maze[i][j] == 1 && !visited[i][j])) {
            return true;
        }
        
        return false;
    }
    
    // Recursive function to find paths in the maze
    public static void solve(int maze[][], int i, int j, ArrayList<String> ans, String path, boolean visited[][], int dx[], int dy[], char direction[]) {
        
        // If we reach the bottom-right corner of the maze, add the path to the result
        if (i == maze.length-1 && j == maze[0].length-1) {
            ans.add(path);
            return;
        }
        
        // Explore all possible moves (up, down, left, right)
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            char ch = direction[k];
            
            // If the move is safe, mark the current cell as visited and explore further
            if (isSafe(maze, newX, newY, visited)) {
                visited[i][j] = true;
                solve(maze, newX, newY, ans, path + ch, visited, dx, dy, direction);
                visited[i][j] = false;  // Backtrack: Mark the current cell as not visited
            }
        }
    }
    
    // Main function to find paths in the maze
    public static ArrayList<String> findPath(int[][] m, int n) {
        int row = m.length;
        int col = m[0].length;
        
        ArrayList<String> ans = new ArrayList<>();
        
        // If the starting cell has a value of 0, return an empty list
        if (m[0][0] == 0) return ans;
        
        // Initialize path, visited array, and direction arrays
        String path = "";
        boolean visited[][] = new boolean[row][col];
        visited[0][0] = true;
        int dx[] = {1, 0, 0, -1};
        int dy[] = {0, -1, 1, 0};
        char direction[] = {'D', 'L', 'R', 'U'};
        
        // Start the recursive function to find paths
        solve(m, 0, 0, ans, path, visited, dx, dy, direction);
        
        return ans;
    }
}


Steps : 1. If the (0,0) indices itselves are 0 then no ans is possible as no way to go though this cell.
        2. Create helping direction arrays dx,dy,direction to easily go on all the 4 directions.
        3. Call solve method.
        4. In this method if we reach till the last row and last col then it is an possible ans, store it.
        5. Now try to go in all 4 directions
            a. Generate new co-ordinates.
            b. Get the direction.
            c. Check if we go through the current cell by calling isSafe() and pass relevent values.
            d. If it is possible to go though this cell then mark this cell as visited and make recursive call.
            e. When coming back from recursive call mark the visited to false (for getting more ways).
        6. In the isSafe function we check if 'i' and 'j' are within range and also ensure that this cell is not visited previously and this cell is a valid cell to go throug (cell contains 1 is a valid cell).
        7. If it doesn't passes the if check then not possible to go throug this cell so return false, otherwise true.


TIme Complexity :- O(4*n);
Space Complexity :- O(n);


GFG :- https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=





