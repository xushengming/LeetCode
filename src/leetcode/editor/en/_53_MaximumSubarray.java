//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum. 
//
// Example: 
//
// 
//Input: [-2,1,-3,4,-1,2,1,-5,4],
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Follow up: 
//
// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming
  package leetcode.editor.en;
  public class _53_MaximumSubarray{
      public static void main(String[] args) {
           Solution solution = new _53_MaximumSubarray().new Solution();
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++){
            if(currentSum < 0){
                currentSum = 0;
            }
            currentSum += nums[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
    public int maxSubArray2(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++){
            currentSum = Math.max(0, currentSum) + nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
    public int maxSubArrayDivideAndConquer(int[] nums) {
        return subarray(nums, 0, nums.length - 1);
    }

    public int subarray(int[] A,int left, int right){
        if(left == right){return A[left];}
        int mid = left + (right - left) / 2;
        int leftSum = subarray(A,left,mid);// left part
        int rightSum = subarray(A,mid+1,right);//right part
        int crossSum = crossSubarray(A,left,right);// cross part
        if(leftSum >= rightSum && leftSum >= crossSum){// left part is max
            return leftSum;
        }
        if(rightSum >= leftSum && rightSum >= crossSum){// right part is max
            return rightSum;
        }
        return crossSum; // cross part is max
    }
    public int crossSubarray(int[] A,int left,int right){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int mid = left + (right - left) / 2;
        for(int i = mid; i >= left ; i--){
            sum = sum + A[i];
            if(leftSum < sum){
                leftSum = sum;
            }
        }
        sum = 0;
        for(int j = mid + 1; j <= right; j++){
            sum = sum + A[j];
            if(rightSum < sum){
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}