//Given an array of non-negative integers, you are initially positioned at the first index of the array. 
//
// Each element in the array represents your maximum jump length at that position. 
//
// Your goal is to reach the last index in the minimum number of jumps. 
//
// Example: 
//
// 
//Input: [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2.
//    Jump 1 step from index 0 to 1, then 3 steps to the last index. 
//
// Note: 
//
// You can assume that you can always reach the last index. 
// Related Topics Array Greedy

  package leetcode.editor.en;
  public class _45_JumpGameIi{
      public static void main(String[] args) {
           Solution solution = new _45_JumpGameIi().new Solution();
//           int[] array = new int[]{2,3,0,1,4};
//           int[] array = new int[]{0};
          int[] array = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
//          int[] array = new int[]{7,8,4,2,0,6,4,1,8,7,1,7,4,1,4,1,2,8,2,7,3,7,8,2,4,4,5,3,5,6,8,5,4,4,7,4,3,4,8,1,1,9,0,8,2};
          long start = System.currentTimeMillis();
          System.out.println(solution.jumpBFS(array));
          long end = System.currentTimeMillis();
          System.out.println("cost " + (end - start));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jumpBFS(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        int currentIndex = 0;
        int currentMax = 0;
        int nextMax = 0;
        int level = 0;
        while (currentMax - currentIndex + 1 > 0){
            level++;
            for (; currentIndex <= currentMax; currentIndex++){
                nextMax = Math.max(nextMax, nums[currentIndex] + currentIndex);
                if(nextMax >= nums.length - 1){
                    return level;
                }
            }
            currentMax = nextMax;
        }
        return level;
    }
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        int[] jumpsArray = new int[nums.length];
        for (int i = 0; i < jumpsArray.length; i++){
            jumpsArray[i] = -1;
        }
        jumpsArray[jumpsArray.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--){
           jump2(nums, jumpsArray, i, 0);
        }
        return jumpsArray[0];
    }

    /**
     * 1ms method
     * @param nums
     * @param jumpArray
     * @param currentIndex
     * @param level
     * @return
     */
    private int jump2(int[] nums, int[] jumpArray, int currentIndex, int level){
        if(jumpArray[currentIndex] >= 0){
            return jumpArray[currentIndex];
        }
        if(nums[currentIndex] >= nums.length - currentIndex - 1){
            jumpArray[currentIndex] = 1;
            return 1;
        }
        if(nums[currentIndex] == 0){
            return -1;
        }
        for (int jump = nums[currentIndex]; jump >= 1; jump--){
            if(jumpArray[jump + currentIndex] == 1){
                jumpArray[currentIndex] = 2;
                break;
            }
            int steps = jump2(nums, jumpArray, currentIndex + jump, + level + 1);
            if(steps != -1){
                tryUpdateJumpCount(jumpArray, currentIndex, steps + 1);
            }
        }
        return jumpArray[currentIndex];
    }

    /**
     * This is very slow
     * @param nums
     * @param jumpsArray
     * @param currentPosition
     * @param jump
     * @return
     */
    private int jump(int[] nums, int[] jumpsArray, int currentPosition, int jump){
        int newPosition = currentPosition + jump;
        if(newPosition == nums.length - 1){
            tryUpdateJumpCount(jumpsArray, currentPosition, 1);
            return 1;
        }else if(newPosition > nums.length - 1){
            return -1;
        }else {
            for (int i = nums[newPosition]; i >= 1; i--){
                if(newPosition < jumpsArray.length && jumpsArray[newPosition] == 1){
                    tryUpdateJumpCount(jumpsArray, currentPosition, 1 + 1);
                    break;
                }
                int result = jump(nums, jumpsArray, newPosition, i);
                if(result != -1){
                    tryUpdateJumpCount(jumpsArray, currentPosition, 1 + result);
                }
            }
            return jumpsArray[currentPosition];
        }
    }

    private void tryUpdateJumpCount(int[] array, int index, int newCount){
        if(array[index] == -1 || array[index] > newCount){
            array[index] = newCount;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
