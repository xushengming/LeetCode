//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics Backtracking

  package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations{
      public static void main(String[] args) {
           Solution solution = new _77_Combinations().new Solution();
      }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(k > n){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        combineImpl(1, n, k, result, new ArrayList<>());
        return result;
    }

    private void combineImpl(int start, int n, int remain, List<List<Integer>> result,
                             List<Integer> current){
        if(remain == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n - remain + 1; i++){
            current.add(i);
            combineImpl(i + 1, n, remain - 1, result, current);
            current.remove(current.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}