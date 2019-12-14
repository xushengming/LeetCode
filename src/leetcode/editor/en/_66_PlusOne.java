//Given a non-empty array of digits representing a non-negative integer, plus one to the integer. 
//
// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit. 
//
// You may assume the integer does not contain any leading zero, except the number 0 itself. 
//
// Example 1: 
//
// 
//Input: [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
// 
//
// Example 2: 
//
// 
//Input: [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
// Related Topics Array

package leetcode.editor.en;


public class _66_PlusOne{
      public static void main(String[] args) {
           Solution solution = new _66_PlusOne().new Solution();
           Utils.printIntArray(solution.plusOne(new int[]{4,3,2,1}));
          Utils.printIntArray(solution.plusOne(new int[]{1, 2, 3}));
          Utils.printIntArray(solution.plusOne(new int[]{9, 9, 9}));

      }



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return digits;
        }
        digits[digits.length - 1] += 1;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--){
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
            if(carry == 0){
                break;
            }
        }
        int[] result = digits;
        if(carry > 0){
            result = new int[digits.length + 1];
            result[0] = carry;
            for (int i = 1; i < digits.length; i++){
                result[i] = digits[i];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
