//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: 
//
// 
// All numbers (including target) will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5,
//A solution set is:
//[
//  [1,2,2],
//  [5]
//]
// 
// Related Topics Array Backtracking

  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSumIi{
      public static void main(String[] args) {
           Solution solution = new _40_CombinationSumIi().new Solution();
           int[] array = new int[]{10,1,2,7,6,1,5};
           int target = 8;
           List<List<Integer>> result = solution.combinationSum2(array, target);
           int i = 0;
      }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentResult = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, result, currentResult, 0);
        return result;
    }

    private void combinationSum2(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentResult, int startIndex) {
       if(target == 0){
           List<Integer> tmp = new ArrayList<Integer>(currentResult);
           result.add(tmp);
           return;
       }
       for (int i = startIndex; i < candidates.length && target >= candidates[i]; i++){
           if((i == startIndex || candidates[i - 1] != candidates[i])){
               currentResult.add(candidates[i]);
               combinationSum2(candidates, target - candidates[i], result, currentResult, i + 1);
               currentResult.remove(currentResult.size() - 1);
           }
       }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
