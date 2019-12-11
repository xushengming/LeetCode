//Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order. 
//
// Example 1: 
//
// 
//Input:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
// 
//Input:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// Related Topics Array

  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix{
      public static void main(String[] args) {
           Solution solution = new _54_SpiralMatrix().new Solution();
          int[][] input = new int[][]{{ 1, 2, 3 },
                 { 4, 5, 6 },
                  { 7, 8, 9 }};
//          int[][] input = new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}};
//          int[][] input = new int[][]{[1],[2],[3],[4],[5],[6],[7],[8],[9],[10]};
           List<Integer> result = solution.spiralOrder(input);
           for (int item : result){
               System.out.print(item + " ");
           }
           System.out.println();
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return new ArrayList<>();
        }
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        int minSize = Math.min(rowSize, columnSize);
        List<Integer> result = new ArrayList<>();
        for (int r = 0; r <= (minSize - 1) / 2; r++){
            int horizonSize = columnSize - 2 * r;
            int verticalSize = rowSize - 2 * r - 2;
            for (int ht = 0; ht < horizonSize; ht++){
                result.add(matrix[r][ht + r]);
            }
            for (int vr = 0; vr < verticalSize; vr++){
                result.add(matrix[vr + r + 1][columnSize - 1 - r]);
            }
            if(verticalSize >= 0){
                for (int hb = 0; hb < horizonSize; hb++){
                    result.add(matrix[rowSize - 1 - r][columnSize - 1 - hb - r]);
                }
            }
            if(horizonSize > 1){
                for (int vl = 0; vl < verticalSize; vl++){
                    result.add(matrix[rowSize - 1 - vl - r - 1][r]);
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
