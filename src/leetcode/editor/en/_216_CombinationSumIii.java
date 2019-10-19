//
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers. 
//
// Note: 
//
// 
// All numbers will be positive integers. 
// The solution set must not contain duplicate combinations. 
// 
//
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
// 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics Array Backtracking
  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSumIii{
      public static void main(String[] args) {
           Solution solution = new _216_CombinationSumIii().new Solution();
           List<List<Integer>> result = solution.combinationSum3(3, 7);
           int i = 1;
      }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentResult = new ArrayList<>();
        combinationSum3(n, k, result, currentResult, 1);
        return result;
    }

    private void combinationSum3(int target, int count, List<List<Integer>> result,
                                 List<Integer> currentResult, int startIndex){
        if(target == 0){
            List<Integer> tmp = new ArrayList<>(currentResult);
            result.add(tmp);
            return;
        }
        if(count <= 0){
            return;
        }
        for (int i = startIndex; i < 10 && target >= i * count + (count - 1) * count / 2/*also can use target >= i*/; i++){
            currentResult.add(i);
            combinationSum3(target - i, count - 1, result, currentResult, i + 1);
            currentResult.remove(currentResult.size() - 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}