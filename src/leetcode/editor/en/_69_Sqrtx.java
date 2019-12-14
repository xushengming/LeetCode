//Implement int sqrt(int x). 
//
// Compute and return the square root of x, where x is guaranteed to be a non-negative integer. 
//
// Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned. 
//
// Example 1: 
//
// 
//Input: 4
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since 
//             the decimal part is truncated, 2 is returned.
// 
// Related Topics Math Binary Search
  package leetcode.editor.en;
  public class _69_Sqrtx{
      public static void main(String[] args) {
           Solution solution = new _69_Sqrtx().new Solution();
          System.out.println(solution.mySqrt(0));
          System.out.println(solution.mySqrt(8));
          System.out.println(solution.mySqrt(1));
          System.out.println(solution.mySqrt(4));
          System.out.println(solution.mySqrt(100));
          System.out.println(solution.mySqrt(2147395599));
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x;
        while (left <= right){
            int middle = (left + right) / 2;
            if(middle == x / middle){
                return middle;
            }else if(middle < x / middle){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}