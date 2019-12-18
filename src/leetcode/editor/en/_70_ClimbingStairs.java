//You are climbing a stair case. It takes n steps to reach to the top. 
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? 
//
// Note: Given n will be a positive integer. 
//
// Example 1: 
//
// 
//Input: 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
// 
//
// Example 2: 
//
// 
//Input: 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
// Related Topics Dynamic Programming
  package leetcode.editor.en;
  public class _70_ClimbingStairs{
      public static void main(String[] args) {
          Solution solution = new _70_ClimbingStairs().new Solution();
          System.out.println(solution.climbStairs(1));
          System.out.println(solution.climbStairs(2));
          System.out.println(solution.climbStairs(3));
          System.out.println(solution.climbStairs(4));
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int result = 0;
        int lastOne = 1, lastTwo = 2;
       for (int i = n - 3; i >= 0; i--){
           result = lastOne + lastTwo;
           lastOne = lastTwo;
           lastTwo = result;
       }
       return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}