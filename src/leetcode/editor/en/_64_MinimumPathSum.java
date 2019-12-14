//Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path. 
//
// Note: You can only move either down or right at any point in time. 
//
// Example: 
//
// 
//Input:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//Output: 7
//Explanation: Because the path 1→3→1→1→1 minimizes the sum.
// 
// Related Topics Array Dynamic Programming

  package leetcode.editor.en;
  public class _64_MinimumPathSum{
      public static void main(String[] args) {
           Solution solution = new _64_MinimumPathSum().new Solution();
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length - 1;
        int column = grid[0].length - 1;
        for (int r = row; r >= 0; r--){
            for (int c = column; c >= 0; c--){
                if(c + 1 <= column && r + 1 <= row){
                    grid[r][c] += Math.min(grid[r + 1][c], grid[r][c + 1]);
                }else if(c + 1 <= column){
                    grid[r][c] += grid[r][c + 1];
                }else if(r + 1 <= row){
                    grid[r][c] += grid[r + 1][c];
                }
            }
        }
        return grid[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
