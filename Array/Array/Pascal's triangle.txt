// Array based

import java.util.*;
public class Solution {
    public static int[][] pascalTriangle(int N) {
        // Write your code here.
        int triangle[][] = new int[N][];

        for(int i = 0; i < N ; i++){
            triangle[i] = new int[i+1];

            // mark edges as 1
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            // generate middle elements
            for(int j = 1 ; j < i; j++){
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }

        return triangle;
    }
}

// List based

class Solution {
    public List<List<Integer>> generate(int n) {
        
        List<List<Integer>> ans = new ArrayList<>();

        if(n == 0) return ans;
        
        List<Integer> firstRow = new ArrayList<>();

        firstRow.add(1);
        ans.add(firstRow);

        if( n == 1 ) return ans;

        for(int i = 1 ; i < n ; i++){
            List<Integer> prevRow = ans.get(i-1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);

            for(int j = 1; j < i; j++){
                currRow.add(prevRow.get(j-1) + prevRow.get(j));
            }

            currRow.add(1);
            ans.add(currRow);
        }

        return ans;

    }
}

---------------


class Solution {
    public List<Integer> getRow(int rowIndex) {
        long  ans = 1L;
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int)ans);
        for(int i=1; i<rowIndex; i++)
        {
            ans = ans * (rowIndex-i+1);
            ans = ans / i;
            result.add((int)ans);
        }
        if(rowIndex > 0)
            result.add(1);
        return result;
    }
}

Note : Draw the tree to understand why we have done 
        a. currRow.add(prevRow.get(j-1) + prevRow.get(j));
        b. triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];

LeetCode : https://leetcode.com/problems/pascals-triangle/

CodeStudio : https://www.codingninjas.com/studio/problems/print-pascal-s-triangle_6917910?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf