//Given a set of distinct integers, nums, return all possible subsets (the power
// set). 
//
// Note: The solution set must not contain duplicate subsets. 
//
// Example: 
//
// 
//Input: nums = [1,2,3]
//Output:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//] 
// Related Topics Array Backtracking Bit Manipulation

  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class _78_Subsets{
      public static void main(String[] args) {
           Solution solution = new _78_Subsets().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        subsetsImple(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void subsetsImple(int[] nums, int start, List<List<Integer>> result,
                              List<Integer> current){
        result.add(new ArrayList<>(current));
        for(int i = start; i < nums.length; i++){
            current.add(nums[i]);
            subsetsImple(nums, i + 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}