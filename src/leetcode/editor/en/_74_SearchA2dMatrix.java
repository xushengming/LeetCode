//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties: 
//
// 
// Integers in each row are sorted from left to right. 
// The first integer of each row is greater than the last integer of the previous row. 
// 
//
// Example 1: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//Output: true
// 
//
// Example 2: 
//
// 
//Input:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//Output: false 
// Related Topics Array Binary Search

  package leetcode.editor.en;
  public class _74_SearchA2dMatrix{
      public static void main(String[] args) {
           Solution solution = new _74_SearchA2dMatrix().new Solution();
           int[][] input = new int[][]{{1, 1}};
           System.out.println(solution.searchMatrix(input, 2));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            int value = matrix[middle / matrix[0].length][middle % matrix[0].length];
            if(value == target){
                return true;
            }else if(value < target){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
