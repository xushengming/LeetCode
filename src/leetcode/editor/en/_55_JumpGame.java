//Given an array of non-negative integers, you are initially positioned at the first index of the array. 
//
// Each element in the array represents your maximum jump length at that position. 
//
// Determine if you are able to reach the last index. 
//
// Example 1: 
//
// 
//Input: [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: [3,2,1,0,4]
//Output: false
//Explanation: You will always arrive at index 3 no matter what. Its maximum
//             jump length is 0, which makes it impossible to reach the last index.
// 
// Related Topics Array Greedy

  package leetcode.editor.en;
  public class _55_JumpGame{
      public static void main(String[] args) {
           Solution solution = new _55_JumpGame().new Solution();
           int[] input = new int[]{2, 3, 1, 1, 4};
           System.out.println(solution.canJump(input) + " --- true");
          System.out.println(solution.canJump(new int[]{2}) + " --- true");
          System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}) + " --- true");
          System.out.println(solution.canJump(new int[]{1, 1, 2, 2, 0, 1, 1}) + " --- true");
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return true;
        }
       int index = 0;
       int maxIndex = 0;
       int currentMaxIndex = 0;
       while (index < nums.length){
          for (; index <= maxIndex; index++){
              currentMaxIndex = Math.max(index + nums[index], currentMaxIndex);
              if(currentMaxIndex >= nums.length - 1){
                  return true;
              }
          }
          if(currentMaxIndex > maxIndex){
              maxIndex = currentMaxIndex;
          }else if(currentMaxIndex == maxIndex){
              break;
          }
       }
       return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
