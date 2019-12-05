//You are given an n x n 2D matrix representing an image. 
//
// Rotate the image by 90 degrees (clockwise). 
//
// Note: 
//
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
//
// Example 1: 
//
// 
//Given input matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//rotate the input matrix in-place such that it becomes:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// Example 2: 
//
// 
//Given input matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//rotate the input matrix in-place such that it becomes:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics Array

  package leetcode.editor.en;
  public class _48_RotateImage{
      public static void main(String[] args) {
          Solution solution = new _48_RotateImage().new Solution();
          int[][] matrix = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
          solution.rotate(matrix);
          for (int[] items : matrix){
              for (int item : items){
                  System.out.print(" " + item);
              }
              System.out.println();
          }
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++){
            int start = i;
            int end = size - i;
            for (int j = start; j < end; j++){
                int tmp = matrix[i][j];
                if(i + j != size - 1){
                    matrix[i][j] = matrix[size - 1 - j][i];
                }
                if(size - 1 - j != i){
                    matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];
                }
                if(size - 1 - i + size - 1 - j != size - 1){
                    matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];
                }
                if(j != size - 1 - i){
                    matrix[j][size - 1 - i] = tmp;
                }
            }
        }
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
