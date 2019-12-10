//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other. 
//
// 
//
// Given an integer n, return the number of distinct solutions to the n-queens puzzle. 
//
// Example: 
//
// 
//Input: 4
//Output: 2
//Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics Backtracking
  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _52_NQueensIi{
      public static void main(String[] args) {
           Solution solution = new _52_NQueensIi().new Solution();
           System.out.println(solution.totalNQueens(8));
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {
//        HashSet<Integer> columnSet = new HashSet<>();
//        HashSet<Integer> diagonal45Set = new HashSet<>();
//        HashSet<Integer> diagonal135Set = new HashSet<>();
        boolean[] column = new boolean[n];
        boolean[] diagonal45 = new boolean[2 * n - 1];
        boolean[] diagonal135 = new boolean[2 * n - 1];
        return totalNQueens(n, 0, column, diagonal45, diagonal135);
    }
    private int totalNQueens(int n, int row,
                             /*Set<Integer> columnSet,
                             Set<Integer> diagonal45Set,
                             Set<Integer> diagonal135Set,*/
                             boolean[] column,
                             boolean[] diagonal45,
                             boolean[] diagonal135){
        if(row == n){
            return 1;
        }

        int count = 0;
        for (int c = 0; c < n; c++) {
//            if (columnSet.contains(c)
//                    || diagonal45Set.contains(row - c)
//                    || diagonal135Set.contains(row + c)) {
//                continue;
//            }
            if(column[c]
            || diagonal45[row - c + n - 1]
            || diagonal135[row + c]){
                continue;
            }
            column[c] = true;
            diagonal45[row - c + n - 1] = true;
            diagonal135[row + c] = true;
            count += totalNQueens(n, row + 1, column, diagonal45, diagonal135);
            column[c] = false;
            diagonal45[row - c + n - 1] = false;
            diagonal135[row + c] = false;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}