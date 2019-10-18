//Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target. 
//
// The same repeated number may be chosen from candidates unlimited number of times. 
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
//Input: candidates = [2,3,6,7], target = 7,
//A solution set is:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8,
//A solution set is:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
// 
// Related Topics Array Backtracking

  package leetcode.editor.en;

import java.util.*;

public class _39_CombinationSum{
      public static void main(String[] args) {
           Solution solution = new _39_CombinationSum().new Solution();
//           int[] array = new int[]{2,3,6,7};
          int[] array = new int[]{2, 3, 5};
          int target = 7;
           List<List<Integer>> result = solution.combinationSum(array, target);
           int i = 1;
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentResult = new ArrayList<>();
//        Arrays.sort(candidates);
        findResult(candidates, target, result, currentResult, 0);
        return result;
    }

    private void findResult(int[] candidates, int target, List<List<Integer>> result, List<Integer> currentResult, int startIndex){
        if(target == 0){
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.addAll(currentResult);
            result.add(tmp);
            return;
        }
        for (int i = startIndex; i < candidates.length && target >= candidates[i]; i++){
            if(target >= candidates[i]){
                currentResult.add(candidates[i]);
                findResult(candidates, target - candidates[i], result, currentResult, i);
                currentResult.remove(currentResult.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
