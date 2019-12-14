//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below). 
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below). 
//
// How many possible unique paths are there? 
//
// 
//Above is a 7 x 3 grid. How many possible unique paths are there? 
//
// Note: m and n will be at most 100. 
//
// Example 1: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//1. Right -> Right -> Down
//2. Right -> Down -> Right
//3. Down -> Right -> Right
// 
//
// Example 2: 
//
// 
//Input: m = 7, n = 3
//Output: 28 
// Related Topics Array Dynamic Programming

  package leetcode.editor.en;
  public class _62_UniquePaths{
      public static void main(String[] args) {
           Solution solution = new _62_UniquePaths().new Solution();
           System.out.println(solution.uniquePaths(7, 3));
          System.out.println(solution.uniquePaths(100, 2));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0){
            return -1;
        }
       int[][] path = new int[n][m];
        path[n - 1][m - 1] = 1;
        for (int i = n - 1; i >= 0; i--){
            for (int j = m - 1; j >= 0; j--){
               if(i + 1 <=  n - 1){
                   path[i][j] += path[i + 1][j];
               }
               if(j + 1 <= m - 1){
                   path[i][j] += path[i][j + 1];
               }
            }
        }
      return path[0][0];
    }

    /**
     * Use formula
     *  Combination(N, k) = n! / (k!(n - k)!)
     *  reduce the numerator and denominator and get
     *  C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double value = 1;
        for (int i = 1; i <= k; i++) {
            value *= ((double)N - k + i) / (double)i;
        }
        return (int) Math.round(value);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
