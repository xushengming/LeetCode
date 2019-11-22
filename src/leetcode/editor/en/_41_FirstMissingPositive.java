//Given an unsorted integer array, find the smallest missing positive integer. 
//
// Example 1: 
//
// 
//Input: [1,2,0]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: [3,4,-1,1]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: [7,8,9,11,12]
//Output: 1
// 
//
// Note: 
//
// Your algorithm should run in O(n) time and uses constant extra space. 
// Related Topics Array

  package leetcode.editor.en;

import java.util.HashMap;
import java.util.HashSet;

public class _41_FirstMissingPositive{
      public static void main(String[] args) {
           Solution solution = new _41_FirstMissingPositive().new Solution();
//           int[] nums = {7,8,9,11,12};
          int[] nums = {1,2,0};
          int result = solution.firstMissingPositive2(nums);
           System.out.println(result);
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int rangeSize = 1 << 16;
        int arraySize = Integer.MAX_VALUE / rangeSize + 1;
        int[] array = new int[arraySize];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= 0) {
                array[num / rangeSize]++;
            }
        }

        int targetBucketIndex = -1;
        for (int i = 0; i < arraySize; i++) {
            if (array[i] < rangeSize) {
                targetBucketIndex = i;
                break;
            }
        }

        byte[] bitArray = new byte[rangeSize / 8 + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > targetBucketIndex * rangeSize && num < (targetBucketIndex * rangeSize + rangeSize)) {
                int numInBucket = num - targetBucketIndex * rangeSize;
                bitArray[numInBucket / 8] |= 1 << (numInBucket % 8);
            }
        }
        for (int i = 0; i < bitArray.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (targetBucketIndex == 0 && i == 0 && j == 0) {
                    continue;
                }
                if ((bitArray[i] & (1 << j)) == 0) {
                    return i * 8 + j + targetBucketIndex * rangeSize;
                }
            }
        }
        return -1;
    }

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int minMiss = 1;
        for (int num : nums){
            if(num == minMiss){
                while (set.contains(++minMiss));
            }else if(num > minMiss && num <= nums.length){
                set.add(num);
            }
        }
        return minMiss;
    }
    public int firstMissingPositive3(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        for (int i = 0; i < nums.length; i++){
            while (nums[i] > 0 && nums[i] <= nums.length
                    && nums[nums[i] - 1] != nums[i]){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
