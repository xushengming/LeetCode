//The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other. 
//
// 
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. 
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively. 
//
// Example: 
//
// 
//Input: 4
//Output: [
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
// 
// Related Topics Backtracking

  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _51_NQueens{
      public static void main(String[] args) {
           Solution solution = new _51_NQueens().new Solution();
           int n = 4;
           List<List<String>> result = solution.solveNQueens(n);
           for (List<String> list : result){
               for (String str : list){
                   System.out.print(str);
               }
               System.out.println();
           }
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] positions = new int[n];
        for (int i = 0; i < n; i++){
            positions[i] = -1;
        }
        solveNQueens(n, result, positions, 0);
        return result;
    }

    private void solveNQueens(int n, List<List<String>> result, int[] positions, int index){
        if(index == n){
            List<String> solution = new ArrayList<>();
            for (int position : positions){
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < n; i++){
                    if(i == position){
                        stringBuilder.append("Q");
                    }else{
                        stringBuilder.append(".");
                    }
                }
                solution.add(stringBuilder.toString());
            }
            result.add(solution);
            return;
        }

        for (int i = 0; i < n; i++){
            boolean isValid = true;
            for (int j = 0; j < index; j++){
                if(i == positions[j] || Math.abs(index - j) == Math.abs(i - positions[j])){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                positions[index] = i;
                solveNQueens(n, result, positions, index + 1);
                positions[index] = -1;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
