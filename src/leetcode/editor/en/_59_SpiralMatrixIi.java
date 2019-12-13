//Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order. 
//
// Example: 
//
// 
//Input: 3
//Output:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//]
// 
// Related Topics Array
  package leetcode.editor.en;
  public class _59_SpiralMatrixIi{
      public static void main(String[] args) {
           Solution solution = new _59_SpiralMatrixIi().new Solution();
           int[][] result = solution.generateMatrix(1);
           for (int[] items : result){
               for (int item : items){
                   System.out.print(item + " ");
               }
               System.out.println();
           }
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int rTop = 0, rBottom = n - 1;
        int cLeft = 0, cRight = n - 1;
        int currentNum = 1;
        while (rTop <= rBottom && cLeft <= cRight){
            for (int c = cLeft; c <= cRight; c++){
               result[rTop][c] = currentNum++;
            }
            for (int r = rTop + 1; r <= rBottom; r++){
                result[r][cRight] = currentNum++;
            }
            if(rTop < rBottom && cLeft < cRight){
                for (int c = cRight - 1; c >= cLeft; c--){
                    result[rBottom][c] = currentNum++;
                }
                for (int r = rBottom - 1; r > rTop; r--){
                    result[r][cLeft] = currentNum++;
                }
            }
            rTop++;
            rBottom--;
            cLeft++;
            cRight--;
        }
       return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}